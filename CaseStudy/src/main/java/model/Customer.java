package model;

public class Customer {
    private int id;

    private int oID;
    private String name;
    private String email;
    private String address;
    private String phone;

    public Customer( String name, String email, String address, String phone , int oID) {
        this.id = (int) Math.floor(((Math.random() * 100) + 100000));
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.oID = oID;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getoID() {
        return oID;
    }

    public void setoID(int oID) {
        this.oID = oID;
    }
}
