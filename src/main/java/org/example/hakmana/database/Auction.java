package org.example.hakmana.database;

public class Auction {
    private String a_no;
    private String date;
    private String Spects;
    private String Price;

    public String getA_no() {
        return a_no;
    }

    public String getDate() {
        return date;
    }

    public String getSpects() {
        return Spects;
    }

    public String getPrice() {
        return Price;
    }

    public void setA_no(String a_no) {
        this.a_no = a_no;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSpects(String Spects) {
        this.Spects = Spects;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }
}
