package Data;

import java.sql.Timestamp;

public class Categorise {
    private int productIdFK;
    private int categoryIdFK;
    protected java.sql.Timestamp created;
    protected java.sql.Timestamp lastUpdate;

    public Categorise (){}

    public int getProductIdFK() {
        return productIdFK;
    }

    public void setProductIdFK(int productIdFK) {
        this.productIdFK = productIdFK;
    }

    public int getCategoryIdFK() {
        return categoryIdFK;
    }

    public void setCategoryIdFK(int categoryIdFK) {
        this.categoryIdFK = categoryIdFK;
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

    public Categorise(int productIdFK, int categoryIdFK, Timestamp created, Timestamp lastUpdate) {
        this.productIdFK = productIdFK;
        this.categoryIdFK = categoryIdFK;
        this.created = created;
        this.lastUpdate = lastUpdate;


    }
}
