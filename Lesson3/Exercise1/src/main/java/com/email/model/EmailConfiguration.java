package com.email.model;

public class EmailConfiguration {
    private int id;
    private String languages;
    private int size;
    private boolean spams;
    private String signature;

    public EmailConfiguration() {
    }

    public EmailConfiguration(int id, String languages, int size, boolean spams, String signature) {
        this.id = id;
        this.languages = languages;
        this.size = size;
        this.spams = spams;
        this.signature = signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean getSpams() {
        return spams;
    }

    public void setSpams(boolean spams) {
        this.spams = spams;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
