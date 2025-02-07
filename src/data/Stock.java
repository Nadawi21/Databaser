package data;

import java.sql.Timestamp;

public class Stock {
    protected int orderId;
    protected int quantity;
    protected java.sql.Timestamp created;
    protected java.sql.Timestamp lastUpdate;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public Stock(int orderId, int quantity, Timestamp created, Timestamp lastUpdate) {
        this.orderId = orderId;
        this.quantity = quantity;
        this.created = created;
        this.lastUpdate = lastUpdate;

    }
}
