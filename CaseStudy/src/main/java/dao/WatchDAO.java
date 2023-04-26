package dao;

import model.Item;
import model.Order;
import model.OrderDetail;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WatchDAO implements IWatchDAO{

    private String jdbcURL = "jdbc:mysql://localhost:3306/casestudy?useSSL=false";
    private String jdbcUserName = "root";
    private String jdbcPassword = "Tuila7582621";

    private static final String INSERT_Watch_SQL =  "INSERT INTO watch (name, price, description,img,Type) VALUES (?, ?, ?, ?,?);";
    private static final String SELECT_Watch_BY_ID = "select pID,name,price,description,img,Type from watch where pID =?;";
    private static final String SELECT_ALL_Watch = "select * from watch;";
    private static final String DELETE_Watch_SQL = "delete from watch where pID = ?;";
    private static final String UPDATE_Watch_SQL = "update watch set name = ?,price= ?, description =?, img=?,Type=? where pID = ?;";
    private static final String SELECT_Watch_By_Name = "select * from watch where name = ?";

    private static final String UPDATE_Order_SQL = "update orders set status=? where oID = ?;";



    public WatchDAO() {
    }

    protected Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUserName,jdbcPassword);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }



    @Override
    public void createWatch(Product product) {
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Watch_SQL)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getImg());
            preparedStatement.setString(5, product.getType());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteWatch(int id) {
        boolean rowDelete = false;
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_Watch_SQL);){
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public boolean updateWatch(Product product) {
        boolean rowUpdate = false;
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_Watch_SQL);) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getImg());
            preparedStatement.setString(5, product.getType());
            preparedStatement.setInt(6, product.getId());

            rowUpdate = preparedStatement.executeUpdate()>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public Product selectWatchById(int id) {
        Product product = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Watch_BY_ID)){
            preparedStatement.setInt(1,id);

            ResultSet rs =preparedStatement.executeQuery();

            while (rs.next()){
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String description = rs.getString("description");
                String img = rs.getString("img");
                String type = rs.getString("Type");
                product = new Product(id,name,price,description,img,type);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> selectAllWatch() {
        List<Product> products = new ArrayList<>();

        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Watch);){
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int id = rs.getInt("pID");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String description = rs.getString("description");
                String img = rs.getString("img");
                String type = rs.getString("Type");
                Product product = new Product(id,name,price,description,img,type);
                products.add(product);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> selectWatchByName(String name) {
       List<Product> products = new ArrayList<>();
       try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Watch_By_Name)){
           preparedStatement.setString(1,name);

           ResultSet rs = preparedStatement.executeQuery();

           while (rs.next()){
               int id = rs.getInt("pID");
               String name2 = rs.getString("name");
               double price = rs.getDouble("price");
               String description = rs.getString("description");
               String img = rs.getString("img");
               String type = rs.getString("type");
               Product product = new Product(id,name2,price,description,img,type);
               products.add(product);
           }
       }catch (SQLException e){
           e.printStackTrace();
       }
       return products;
    }

    public List<Product> sortBySolar(){
        String query = "{CALL sortbysolar()}";
        List<Product> products = new ArrayList<>();
        try(Connection connection = getConnection(); CallableStatement callableStatement = connection.prepareCall(query)){
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("pID");
                String name2 = rs.getString("name");
                double price = rs.getDouble("price");
                String description = rs.getString("description");
                String img = rs.getString("img");
                String type = rs.getString("type");
                Product product = new Product(id,name2,price,description,img,type);
                products.add(product);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return products;
    }

    public List<Product> sortByAutomatic(){
        String query = "{CALL sortbyautomatic()}";
        List<Product> products = new ArrayList<>();
        try(Connection connection = getConnection(); CallableStatement callableStatement = connection.prepareCall(query)){
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("pID");
                String name2 = rs.getString("name");
                double price = rs.getDouble("price");
                String description = rs.getString("description");
                String img = rs.getString("img");
                String type = rs.getString("type");
                Product product = new Product(id,name2,price,description,img,type);
                products.add(product);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return products;
    }

    public List<Product> sortByQuartz(){
        String query = "{CALL sortbyquartz()}";
        List<Product> products = new ArrayList<>();
        try(Connection connection = getConnection(); CallableStatement callableStatement = connection.prepareCall(query)){
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("pID");
                String name2 = rs.getString("name");
                double price = rs.getDouble("price");
                String description = rs.getString("description");
                String img = rs.getString("img");
                String type = rs.getString("type");
                Product product = new Product(id,name2,price,description,img,type);
                products.add(product);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return products;
    }

    public List<OrderDetail> getListOrderDetail(){
        String query = "{CALL getOrder()}";
        List<OrderDetail> orderDetails = new ArrayList<>();
        try(Connection connection = getConnection(); CallableStatement callableStatement = connection.prepareCall(query)){
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()){
                int orderID = rs.getInt("OrderID");
                String date = rs.getString("Date");
                String address = rs.getString("address");
                double totalPrice = rs.getDouble("Total");
                int status = rs.getInt("Status");
                OrderDetail orderDetail = new OrderDetail(orderID,date,address,totalPrice,status);
                orderDetails.add(orderDetail);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return orderDetails;
    }

    public List<Item> getListOrder(int id){
        String query = "{CALL getlistOrder(?)}";
        List<Item> items = new ArrayList<>();
        try(Connection connection = getConnection(); CallableStatement callableStatement = connection.prepareCall(query)){
            callableStatement.setInt(1,id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()){
                int productID = rs.getInt("pID");
                int quantity = rs.getInt("quantity");
                Product product = selectWatchById(productID);
                Item item = new Item();
                item.setQuantity(quantity);
                item.setWatch(product);
                items.add(item);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return items;
    }

    public OrderDetail getOrderDetailById(int id){
        String query ="{CALL getOrderById(?)}";
        OrderDetail orderDetail = null;
        try(Connection connection = getConnection(); CallableStatement callableStatement = connection.prepareCall(query)){
            callableStatement.setInt(1,id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()){
                int orderID = rs.getInt("OrderID");
                String date = rs.getString("Date");
                String address = rs.getString("address");
                double totalPrice = rs.getDouble("Total");
                int status = rs.getInt("Status");
                 orderDetail = new OrderDetail(orderID,date,address,totalPrice,status);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return orderDetail;
    }

    public void updateStatusOrder(int status , int id){
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_Order_SQL)) {
            preparedStatement.setInt(1,status );
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
