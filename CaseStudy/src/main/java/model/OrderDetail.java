package model;

public class OrderDetail {
    private int orderID;

    private String address;

    private double total;

    private String date;

    private int status;

    public OrderDetail(int orderID,String date, String address, double total, int status) {
        this.orderID = orderID;
        this.address = address;
        this.total = total;
        this.date = date;
        this.status = status;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
