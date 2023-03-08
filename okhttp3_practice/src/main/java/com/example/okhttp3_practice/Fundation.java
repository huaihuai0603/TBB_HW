package com.example.okhttp3_practice;

public class Fundation {
    private String Fundation;
    private String Name;
    private String Address;
    private String Date;

    public Fundation(){}

    public Fundation(String Fundation, String Name, String Address, String Date){
        this.Fundation=Fundation;
        this.Name=Name;
        this.Address=Address;
        this.Date=Date;
    }

    public String getFundation(){return Fundation;}
    public void setFundation(String Fundation){this.Fundation=Fundation;}
    public String getName(){return Name;}
    public void setName(String Name){this.Name=Name;}
    public String getAddress(){return Address;}
    public void setAddress(String Address){this.Address=Address;}
    public String getDate(){return Date;}
    public void setDate(String Date){this.Date=Date;}

    public String toString(){
        return "Fundation:"+this.Fundation+",Funder:"+this.Name+",Address:"+this.Address+",Date:"+this.Date;
    }

}
