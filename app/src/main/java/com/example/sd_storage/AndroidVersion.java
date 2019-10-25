package com.example.sd_storage;

public class AndroidVersion {
    private int logo;
    private String name, rDate;

    public AndroidVersion(int logo, String name, String rDate) {
        this.logo = logo;
        this.name = name;
        this.rDate = rDate;
    }

    public int getLogo() {
        return logo;
    }

    public String getName() {
        return name;
    }

    public String getrDate() {
        return rDate;
    }
}
