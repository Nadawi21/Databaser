package data;

import java.sql.Timestamp;

public class Color {
    protected int colorId;
    protected String colorName;
    protected java.sql.Timestamp created;
    protected java.sql.Timestamp lastUpdate;

    public Color () {}
    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
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

    public Color(int colorId, String colorName, Timestamp created, Timestamp lastUpdate) {
        this.colorId = colorId;
        this.colorName = colorName;
        this.created = created;
        this.lastUpdate = lastUpdate;
    }
}
