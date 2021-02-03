package com.test;

public class User {
    private String name;
    private String gener;
    private String idCard;
    private String address;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGener() {
        return gener;
    }
    public void setGener(String gener) {
        this.gener = gener;
    }
    public String getIdCard() {
        return idCard;
    }
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "User [name=" + name + ", gener=" + gener + ", idCard=" + idCard + ", address=" + address + "]";
    }
    
}