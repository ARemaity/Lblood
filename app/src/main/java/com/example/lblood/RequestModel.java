package com.example.lblood;

public class RequestModel {


    private  int DID;
    private String fname;
    private String lname;
    private int number;
    private String address;
    private   String blood_group;
public  RequestModel(){


}
    public RequestModel(int DID, String fname, String lname, int number, String address, String blood_group) {
        this.DID = DID;
        this.fname = fname;
        this.lname = lname;
        this.number = number;
        this.address = address;
        this.blood_group = blood_group;
    }

    public int getDID() {
        return DID;
    }

    public void setDID(int DID) {
        this.DID = DID;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }
}
