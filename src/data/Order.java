package data;

import java.sql.Timestamp;
import java.util.Date;

public class Order {
    protected int orderId;
    protected  String personalNumberFK;
    protected Date date;
    protected OrderStatus status;
    protected java.sql.Timestamp created;
    protected java.sql.Timestamp lastUpdate;

    public Order () {}
    public Order(int orderId, String personalNumberFK, Date date, OrderStatus status, Timestamp created, Timestamp lastUpdate) {
        this.orderId = orderId;
        this.personalNumberFK = personalNumberFK;
        this.date = date;
        this.status = status;
        this.created = created;
        this.lastUpdate = lastUpdate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getPersonalNumberFK() {
        return personalNumberFK;
    }

    public void setPersonalNumberFK(String personalNumberFK) {
        this.personalNumberFK = personalNumberFK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
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

