package dao;

import model.Order;
import model.Product;

import java.util.List;

public interface IWatchDAO {

    void createWatch(Product product);


    boolean deleteWatch(int id);

    boolean updateWatch(Product product);

    Product selectWatchById(int id);

    List<Product> selectAllWatch();

    List<Product> selectWatchByName(String name);
}
