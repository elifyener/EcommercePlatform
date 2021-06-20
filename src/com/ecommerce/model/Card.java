package com.ecommerce.model;

public class Card {
    private String owner;
    private String number;
    private int cvc;
    private String skt;

    public Card(String ks, String kn, int cvc, String skt) {
        setOwner(ks);
        setNumber(kn);
        setCvc(cvc);
        setSkt(skt);
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String n) {
        this.number = n;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public String getSkt() {
        return skt;
    }

    public void setSkt(String skt) {
        this.skt = skt;
    }

}
