package Controller;

import dao.WatchDAO;
import model.Item;
import model.Order;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartControllerServlet", value = "/CartController")
public class CartControllerServlet extends HttpServlet {

    private WatchDAO watchDAO;

    public void init(){watchDAO = new WatchDAO();}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int quantity = 1;
        double sumTotal = 0;
        int id;
        if ( request.getParameter("id")!=null){
            id = Integer.parseInt(request.getParameter("id"));
            Product product = watchDAO.selectWatchById(id);
            if(product !=null){
                if(request.getParameter("quantity")!=null){
                    quantity=Integer.parseInt(request.getParameter("quantity"));
                }
                HttpSession session = request.getSession();
                if(session.getAttribute("order")==null){
                    Order order = new Order();
                    List<Item> listItem = new ArrayList<Item>();
                    Item item = new Item();
                    item.setQuantity(quantity);
                    item.setWatch(product);
                    item.setPrice(product.getPrice());
                    listItem.add(item);
                    order.setItems(listItem);
                    for (Item it: order.getItems()
                         ) {
                        sumTotal = it.getPrice() * it.getQuantity();
                    }
                    order.setTotalPrice(sumTotal);
                    session.setAttribute("order",order);

                }else {
                    Order order = (Order) session.getAttribute("order");
                    List<Item> listItem = order.getItems();
                    boolean check = false;
                    for (Item item: listItem
                    ) {
                        if (item.getWatch().getId() == product.getId()){
                            item.setQuantity(item.getQuantity() + quantity);
                            check = true;
                        }
                    }
                    if (check==false){
                         order = (Order) session.getAttribute("order");
                         double sum2 = order.getTotalPrice();
                        Item item = new Item();
                        item.setQuantity(quantity);
                        item.setWatch(product);
                        item.setPrice(product.getPrice());
                        listItem.add(item);
                        order.setItems(listItem);
                    }
                    for (Item it: order.getItems()
                    ) {
                        sumTotal += it.getPrice() * it.getQuantity();
                    }

                    order.setTotalPrice(sumTotal);
                    session.setAttribute("order",order);

                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("/homepage/cart.jsp");
                try {
                    dispatcher.forward(request,response);
                }catch (IOException | ServletException e){
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
