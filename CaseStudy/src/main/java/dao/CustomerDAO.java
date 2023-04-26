package dao;

import model.Customer;
import model.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CustomerDAO implements IWatchDAO{

    private String jdbcURL = "jdbc:mysql://localhost:3306/casestudy?useSSL=false";
    private String jdbcUserName = "root";
    private String jdbcPassword = "Tuila7582621";

    private static final String INSERT_customers_SQL =  "INSERT INTO customers (cusID,name, email,address,phone,oID) VALUES (?, ?, ?, ?,?, ?);";
    private static final String SELECT_customers_BY_ID = "select id,name,price,description,img from customers where id =?;";
    private static final String SELECT_ALL_customers = "select * from customers;";
    private static final String DELETE_customers_SQL = "delete from customers where id = ?;";
    private static final String UPDATE_customers_SQL = "update customers set name = ?,price= ?, description =?, img=? where id = ?;";
    private static final String SELECT_customers_By_Name = "select * from customers where name = ?";

    public CustomerDAO() {
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

    public void createCustomer(Customer customer) {
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_customers_SQL)) {
            preparedStatement.setInt(1,customer.getId() );
            preparedStatement.setString(2,customer.getName());
            preparedStatement.setString(3,customer.getEmail());
            preparedStatement.setString(4, customer.getAddress());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setInt(6, customer.getoID());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }


    }
    @Override
    public void createWatch(Product product) {

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
