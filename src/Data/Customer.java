package Data;

public class Customer {

    protected String personalNumber;
    protected String name;
    protected String surname;
    protected String email;
    protected String password;
    protected int OrtIdFK;

    public boolean isValid(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public void userLogin(String personalnumber, String name, String surname) {
        this.personalNumber = personalnumber;
        this.name = name;
        this.surname = surname;
    }

    public boolean checkPNumber(){
        return !personalNumber.equals("0000000000000");
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
        this.personalNumber = personalnumber;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        OrtIdFK = ortIdFK;
    }



    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personnummer) {
        this.personalNumber = personnummer;
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
