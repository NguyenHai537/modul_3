package Controller;

import dao.CartDAO;
import dao.WatchDAO;
import model.Item;
import model.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "OrderDetailServlet", value = "/CartLineItem")
public class CartLineItemServlet extends HttpServlet {

    private CartDAO cartDAO;

    public void init(){cartDAO = new CartDAO();}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Order order = (Order) session.getAttribute("order");
        for (Item it: order.getItems()
             ) {
            int pID = it.getWatch().getId();
            int oID = order.getId();
            int quantity = it.getQuantity();
            String date = order.getStringDate();
            int status = order.getStatus();
            cartDAO.createOrder(pID,oID,quantity,date,status);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/homepage/checkout.jsp");
        dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
