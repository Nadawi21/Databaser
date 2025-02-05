package Data;

public class Customer {

    protected String personalnumber;
    protected String name;
    protected String surname;
    protected String email;
    protected String password;
    protected int OrtIdFK;

    public void userLogin(String personalnumber, String name, String surname) {
        this.personalnumber = personalnumber;
        this.name = name;
        this.surname = surname;
    }

    public boolean checkPNumber(){
        return !personalnumber.equals("0000000000000");
    }

    @Override
    public String toString() {
        if (checkPNumber()) {
            return "Welcome, " + name + surname + "!";
        }else{
            return "Error, try again";
        }
    }

    public Customer() {}
    public Customer(String personalnumber, String name, String surname, String email, String password, int ortIdFK) {
        this.personalnumber = personalnumber;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        OrtIdFK = ortIdFK;
    }



    public String getPersonnummer() {
        return personalnumber;
    }

    public void setPersonnummer(String personnummer) {
        this.personalnumber = personnummer;
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
