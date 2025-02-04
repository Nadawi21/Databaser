package Data;

import java.sql.Timestamp;

public class Product {
    protected int productOd;
    protected String brand;
    protected int size;
    protected String price;
    protected int stockIdFK;
    protected int colorIdFK;
    protected java.sql.Timestamp created;
    protected java.sql.Timestamp lastUpdate;

    public int getProductOd() {
        return productOd;
    }

    public void setProductOd(int productOd) {
        this.productOd = productOd;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getStockIdFK() {
        return stockIdFK;
    }

    public void setStockIdFK(int stockIdFK) {
        this.stockIdFK = stockIdFK;
    }

    public int getColorIdFK() {
        return colorIdFK;
    }

    public void setColorIdFK(int colorIdFK) {
        this.colorIdFK = colorIdFK;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Product(int productOd, String brand, int size, String price, int stockIdFK, int colorIdFK, Timestamp created, Timestamp lastUpdate) {
        this.productOd = productOd;
        this.brand = brand;
        this.size = size;
        this.price = price;
        this.stockIdFK = stockIdFK;
        this.colorIdFK = colorIdFK;
        this.created = created;
        this.lastUpdate = lastUpdate;


    }
}

