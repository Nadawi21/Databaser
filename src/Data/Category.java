package Data;

import java.sql.Timestamp;
import java.util.List;

public class Category {
    protected int categoryId;
    protected String shoeType;
    protected java.sql.Timestamp created;
    protected java.sql.Timestamp lastUpdate;

    public static Integer getCategoryIdByShoeType(List<Category> categories, String shoeType) {
        for (Category category : categories) {
            if (category.getShoeType().equalsIgnoreCase(shoeType)) {
                return category.getCategoryId();
            }
        }
        return null;
    }


    public Category (){}

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getShoeType() {
        return shoeType;
    }

    public void setShoeType(String shoeType) {
        this.shoeType = shoeType;
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

    public Category(int categoryId, String shoeType, Timestamp created, Timestamp lastUpdate) {
        this.categoryId = categoryId;
        this.shoeType = shoeType;
        this.created = created;
        this.lastUpdate = lastUpdate;
    }
}
