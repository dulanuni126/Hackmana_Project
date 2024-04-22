package org.example.hakmana.model;

public class User {
    private String nic;
    private String name;
    private String title;
    private String gmail;

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
    public User() {
    }
    public User(String nic, String name, String title, String gmail) {
        this.nic = nic;
        this.name = name;
        this.title = title;
        this.gmail = gmail;
    }

    /*-----------User verification-------------*/
    //check mail return boolean val

    //store verfication code and generate sql querry

    //get verification code and send bool val

    //cahnge the new password
}
