package model;

public class Product {
    private int id;
    private String name;
    private double price;

    private String type;
    private String description;
    private String img;

    public Product(int id, String name, double price, String description, String img, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.img = img;
        this.type = type;
    }

    public Product(String name, double price, String description, String img, String type) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.img = img;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
