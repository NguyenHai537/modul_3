package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Order {
    private int id;
    private Customer customer;
    private List<Item> items;

    private double totalPrice;
    private int status;

    private String date;

    public Order() {
        this.id = (int) Math.floor(((Math.random() * 899999) + 100000));
        this.date = getStringDate();
        this.status = 1;
    }

    public Order(int id, Customer customer, List<Item> items, int status) {
        this.id = id;
        this.customer = customer;
        this.items = items;
        this.status = status;
    }

    public Order(Customer customer, List<Item> items, int status) {
        this.customer = customer;
        this.items = items;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStringDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String strDate = formatter.format(new Date());
        return strDate;
    }


}
