package Data;

import java.sql.Timestamp;
import java.util.Date;

public class Order {
    protected int orderId;
    protected  char personalnumberFK;
    protected Date date;
    protected java.sql.Timestamp created;
    protected java.sql.Timestamp lastUpdate;

    public Order(int orderId, char personalnumberFK, Date date, Timestamp created, Timestamp lastUpdate) {
        this.orderId = orderId;
        this.personalnumberFK = personalnumberFK;
        this.date = date;
        this.created = created;
        this.lastUpdate = lastUpdate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public char getPersonalnumberFK() {
        return personalnumberFK;
    }

    public void setPersonalnumberFK(char personalnumberFK) {
        this.personalnumberFK = personalnumberFK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
