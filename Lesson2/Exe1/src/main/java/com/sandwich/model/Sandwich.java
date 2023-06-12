package com.sandwich.model;

public class Sandwich {
    private int idBills;
    private String condiments;

    public Sandwich() {
    }

    public Sandwich(int idBills, String condiments) {
        this.idBills = idBills;
        this.condiments = condiments;
    }

    public int getIdBills() {
        return idBills;
    }

    public void setIdBills(int idBills) {
        this.idBills = idBills;
    }

    public String getCondiments() {
        return condiments;
    }

    public void setCondiments(String condiments) {
        this.condiments = condiments;
    }
}
