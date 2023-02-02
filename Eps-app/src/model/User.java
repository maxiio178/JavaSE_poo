package model;

public abstract class User {
    //prps
    private int id;
    private String name;
    private String email;
    private String phoneNum;
    private String addres;

    //constructor
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    //methos
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddres() {
        return addres;
    }
    public void setAddres(String addres) {
        this.addres = addres;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        if (phoneNum.length() > 8) {
            System.out.println("El numero debe tener 8 caracteres para ser valido.");
        }else if (phoneNum.length() == 8){
            this.phoneNum = phoneNum;
        }
    }

    @Override
    public String toString() {
        return "User: " + name + "\n" +"Email: " + email + "\n" + "Address: " + addres;
    }
    public abstract void showDataUser();
}
