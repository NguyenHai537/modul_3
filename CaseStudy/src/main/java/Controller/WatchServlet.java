package Controller;

import dao.CartDAO;
import dao.IWatchDAO;
import dao.WatchDAO;
import model.Item;
import model.OrderDetail;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "WatchServlet", value = "/watches")

public class WatchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private WatchDAO watchDAO;

    private CartDAO cartDAO;



    public void init(){watchDAO = new WatchDAO();}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ( action ==null){
            action = "";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "delete":
                showDeleteForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "viewid":
                showWatchByID(request,response);
                break;
            case "viewname":
                showWatchByName(request,response);
                break;
            case "listorder":
                showListOrder(request,response);
                break;
            case "orderdetail":
                showOrderDetail(request,response);
                break;
            default:
                listWatch(request,response);
                break;
        }

    }

    private void showOrderDetail(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        OrderDetail orderDetail = watchDAO.getOrderDetailById(id);
        List<Item> items = watchDAO.getListOrder(id);
        request.setAttribute("items",items);
        request.setAttribute("order",orderDetail);
        RequestDispatcher dispatcher = request.getRequestDispatcher("watch/orderdetail.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException e){
            e.printStackTrace();
        }


    }

    private void showListOrder(HttpServletRequest request, HttpServletResponse response) {
        List<OrderDetail> orderDetails = watchDAO.getListOrderDetail();
        request.setAttribute("orders", orderDetails);
        RequestDispatcher dispatcher = request.getRequestDispatcher("watch/listOrder.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException e){
            e.printStackTrace();
        }
    }

    private void showWatchByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("viewname");
        List<Product> products = watchDAO.selectWatchByName(name);
        request.setAttribute("watchs", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("watch/listWatch.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException e){
            e.printStackTrace();
        }
    }

    private void showWatchByID(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("viewid"));
        Product product = watchDAO.selectWatchById(id);
        List<Product> products = new ArrayList<>();
        products.add(product);
        request.setAttribute("watchs", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("watch/listWatch.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException e){
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = watchDAO.selectWatchById(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("watch/edit.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException e){
            e.printStackTrace();
        }

    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = watchDAO.selectWatchById(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("watch/delete.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException e){
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("watch/create.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException e){
            e.printStackTrace();
        }
    }

    private void listWatch(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = watchDAO.selectAllWatch();
        request.setAttribute("watchs", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("watch/listWatch.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException e){
            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action){
            case "create":
                createWatch(request,response);
                break;
            case "delete":
                deleteWatch(request,response);
                break;
            case "edit":
                editWatch(request,response);
                break;
            case "orderdetail":
                processOrder(request,response);
                break;
        }

    }

    private void processOrder(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        watchDAO.updateStatusOrder(0,id);
        List<OrderDetail> orderDetails = watchDAO.getListOrderDetail();
        request.setAttribute("orders", orderDetails);
        RequestDispatcher dispatcher = request.getRequestDispatcher("watch/listOrder.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException exception) {
            exception.printStackTrace();
        }



    }

    private void editWatch(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String img = request.getParameter("img");
        String type = request.getParameter("type");

        watchDAO.updateWatch(new Product(id,name,price,description,img,type));
        request.setAttribute("message","updated");
        RequestDispatcher dispatcher = request.getRequestDispatcher("watch/edit.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException exception){
            exception.printStackTrace();
        }
    }

    private void deleteWatch(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        watchDAO.deleteWatch(id);
        request.setAttribute("message","deleted");
        RequestDispatcher dispatcher = request.getRequestDispatcher("watch/delete.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException exception){
            exception.printStackTrace();
        }
    }

    private void createWatch(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String type = request.getParameter("type");
        String img = request.getParameter("img");

        watchDAO.createWatch(new Product(name,price,description,img,type));
        request.setAttribute("message","Successful created");
        RequestDispatcher dispatcher = request.getRequestDispatcher("watch/create.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException exception){
            exception.printStackTrace();
        }

    }
}
