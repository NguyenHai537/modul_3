package dao;

import model.Order;
import model.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class CartDAO implements IWatchDAO{

    private String jdbcURL = "jdbc:mysql://localhost:3306/casestudy?useSSL=false";
    private String jdbcUserName = "root";
    private String jdbcPassword = "Tuila7582621";

    private static final String INSERT_Order_SQL =  "INSERT INTO orders (pID, oID, quantity,TimeOrder,status) VALUES (?, ?, ?,?,?);";
    private static final String SELECT_Cart_BY_ID = "select id,name,price,description,img from Cart where id =?;";
    private static final String SELECT_ALL_Cart = "select * from Cart;";
    private static final String DELETE_Cart_SQL = "delete from Cart where id = ?;";
    private static final String UPDATE_Order_SQL = "update orders set status=? where oID = ?;";
    private static final String SELECT_Cart_By_Name = "select * from Cart where name = ?";

    public CartDAO() {
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

    }





    public void createOrder( int pID , int oID , int quantity, String date , int status) {
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Order_SQL)) {
            preparedStatement.setInt(1,pID );
            preparedStatement.setInt(2, oID);
            preparedStatement.setInt(3, quantity);
            preparedStatement.setString(4, date);
            preparedStatement.setInt(5, status);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }



    @Override
    public boolean deleteWatch(int id) {
        return false;
    }

    @Override
    public boolean updateWatch(Product product) {
        return false;
    }

    @Override
    public Product selectWatchById(int id) {
        return null;
    }

    @Override
    public List<Product> selectAllWatch() {
        return null;
    }

    @Override
    public List<Product> selectWatchByName(String name) {
        return null;
    }
}
