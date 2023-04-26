package Controller;

import dao.WatchDAO;
import model.Customer;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/")
public class UserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private  WatchDAO watchDAO;

    public void init(){watchDAO = new WatchDAO();}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action ==null){
            action = "";
        }

        switch(action){
            case "viewid":
                viewWatchByID(request,response);
                break;
            case "viewname":
                viewWatchByName(request,response);
            case "sortsolar":
                viewWatchSortBySolar(request,response);
                break;
            case "sortautomatic":
                viewWatchSortByAutomatic(request,response);
                break;
            case "sortquartz":
                viewWatchSortByQuartz(request,response);
                break;
            default:
                listWatch(request,response);
                break;
        }
    }

    private void viewWatchSortByQuartz(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = watchDAO.sortByQuartz();
        request.setAttribute("watchs",products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("homepage/listWatch.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException e){
            e.printStackTrace();
        }
    }

    private void viewWatchSortByAutomatic(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = watchDAO.sortByAutomatic();
        request.setAttribute("watchs",products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("homepage/listWatch.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException e){
            e.printStackTrace();
        }

    }

    private void viewWatchSortBySolar(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = watchDAO.sortBySolar();
        request.setAttribute("watchs",products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("homepage/listWatch.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException e){
            e.printStackTrace();
        }
    }


    private void viewWatchByID(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = watchDAO.selectWatchById(id);
        request.setAttribute("product",product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("homepage/product.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException e){
            e.printStackTrace();
        }
    }

    private void viewWatchByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("viewname");
        List<Product> products = watchDAO.selectWatchByName(name);
        request.setAttribute("watchs", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("homepage/listWatch.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException e){
            e.printStackTrace();
        }
    }

    private void listWatch(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = watchDAO.selectAllWatch();
        request.setAttribute("watchs", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("homepage/listWatch.jsp");
        try {
            dispatcher.forward(request,response);
        }catch (IOException | ServletException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

}
