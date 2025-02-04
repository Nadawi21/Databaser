package Data;

import java.sql.Timestamp;

public class OrderItem {
    protected int productIdFK;
    protected int orderIdFK;
    protected int amount ;
    protected java.sql.Timestamp created;
    protected java.sql.Timestamp lastUpdate;

    public OrderItem(int productIdFK, int orderIdFK, int amount, Timestamp created, Timestamp lastUpdate) {
        this.productIdFK = productIdFK;
        this.orderIdFK = orderIdFK;
        this.amount = amount;
        this.created = created;
        this.lastUpdate = lastUpdate;
    }

    public int getProductIdFK() {
        return productIdFK;
    }

    public void setProductIdFK(int productIdFK) {
        this.productIdFK = productIdFK;
    }

    public int getOrderIdFK() {
        return orderIdFK;
    }

    public void setOrderIdFK(int orderIdFK) {
        this.orderIdFK = orderIdFK;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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
}
