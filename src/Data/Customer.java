package Data;

public class Customer {

    protected String personnummer;
    protected String name;
    protected String surname;
    protected String email;
    protected String password;
    protected int OrtIdFK;


    public Customer(String personnummer, String name, String surname, String email, String password, int ortIdFK) {
        this.personnummer = personnummer;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        OrtIdFK = ortIdFK;
    }



    public String getPersonnummer() {
        return personnummer;
    }

    public void setPersonnummer(String personnummer) {
        this.personnummer = personnummer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getOrtIdFK() {
        return OrtIdFK;
    }

    public void setOrtIdFK(int ortIdFK) {
        OrtIdFK = ortIdFK;
    }


}
