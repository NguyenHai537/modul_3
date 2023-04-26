package Controller;

import dao.CustomerDAO;
import dao.WatchDAO;
import model.Customer;
import model.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CustomerServlet", value = "/Customers")
public class CustomerServlet extends HttpServlet {

    private CustomerDAO customerDAO;
    public void init(){customerDAO = new CustomerDAO();}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action){
            case "createCustomer":
                createProduct(request,response);
                break;
        }

    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Order order = (Order)session.getAttribute("order");
        int oID = order.getId();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");

        Customer customer = new Customer(name,email,address,phone,oID);
        customerDAO.createCustomer(customer);

        request.setAttribute("message","created");
        RequestDispatcher dispatcher = request.getRequestDispatcher("homepage/checkout.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException exception){
            exception.printStackTrace();
        }

    }


}
