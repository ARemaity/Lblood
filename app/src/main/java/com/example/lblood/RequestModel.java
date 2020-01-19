package com.example.lblood;

import android.util.Log;

import java.time.LocalDate;
import java.time.Period;

public class RequestModel {


    private  int DID;
    private String fname;
    private String lname;
    private int number;
    private String address;
    private   String blood_group;
    private   String DOB;

    private   String health;

    LocalDate today = LocalDate.now();


    public RequestModel(int DID, String fname, String lname, int number, String address, String blood_group, String DOB, String health) {
        this.DID = DID;
        this.fname = fname;
        this.lname = lname;
        this.number = number;
        this.address = address;
        this.blood_group = blood_group;
        this.DOB = DOB;
        this.health = health;
    }

    public  RequestModel(){


}

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
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

    public String getfullName(){

    return  this.fname+" "+this.lname;
    }

    public  String getAge(){
        String [] partsts= this.DOB.split("-");
        int day=Integer.parseInt(partsts[2]);
        int month=Integer.parseInt(partsts[1]);
        int year=Integer.parseInt(partsts[0]);
        Log.d("///////////////////////////////////day//month//year", day+"//"+month+"//"+year );
        LocalDate today = LocalDate.now();                          //Today's date
        LocalDate birthday = LocalDate.of(year,month,day);

        Period p = Period.between(birthday, today);

        int result =p.getYears();
        Log.d("//////////////////////////////////result", "//////:"+result);
        return  Integer.toString(result);

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
