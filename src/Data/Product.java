package Data;

import java.sql.Timestamp;

public class Product {
    protected int productId;
    protected String brand;
    protected int size;
    protected int price;
    protected int stockIdFK;
    protected int colorIdFK;
    protected java.sql.Timestamp created;
    protected java.sql.Timestamp lastUpdate;

    public Product() {}

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public int getPrice() {
         return price;
    }

    public void setPrice(int price) {
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

    public Product(int productId, String brand, int size, int price, int stockIdFK, int colorIdFK, Timestamp created, Timestamp lastUpdate) {
        this.productId = productId;
        this.brand = brand;
        this.size = size;
        this.price = price;
        this.stockIdFK = stockIdFK;
        this.colorIdFK = colorIdFK;
        this.created = created;
        this.lastUpdate = lastUpdate;


    }
}

