public class Produkt {
    protected String märke;
    protected int storlek;
    protected String färgnamn;

    public Produkt(){}

    public String getMärke() {
        return märke;
    }

    public void setMärke(String märke) {
        this.märke = märke;
    }

    public int getStorlek() {
        return storlek;
    }

    public void setStorlek(int storlek) {
        this.storlek = storlek;
    }

    public String getFärgnamn() {
        return färgnamn;
    }

    public void setFärgnamn(String färgnamn) {
        this.färgnamn = färgnamn;
    }
}

