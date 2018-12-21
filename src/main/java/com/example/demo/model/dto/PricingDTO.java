package com.example.demo.model.dto;

public class PricingDTO {
    private int januar;
    private int februar;
    private int mart;
    private int april;
    private int maj;
    private int jun;
    private int jul;
    private int avgust;
    private int septembar;
    private int oktobar;
    private int novembar;
    private int decembar;


    public PricingDTO(){}


    public PricingDTO(int januar, int februar, int mart, int april, int maj, int jun, int jul, int avgust, int septembar, int oktobar, int novembar, int decembar) {
        this.januar = januar;
        this.februar = februar;
        this.mart = mart;
        this.april = april;
        this.maj = maj;
        this.jun = jun;
        this.jul = jul;
        this.avgust = avgust;
        this.septembar = septembar;
        this.oktobar = oktobar;
        this.novembar = novembar;
        this.decembar = decembar;
    }


    public int getJanuar() {
        return januar;
    }

    public void setJanuar(int januar) {
        this.januar = januar;
    }

    public int getFebruar() {
        return februar;
    }

    public void setFebruar(int februar) {
        this.februar = februar;
    }

    public int getMart() {
        return mart;
    }

    public void setMart(int mart) {
        this.mart = mart;
    }

    public int getApril() {
        return april;
    }

    public void setApril(int april) {
        this.april = april;
    }

    public int getMaj() {
        return maj;
    }

    public void setMaj(int maj) {
        this.maj = maj;
    }

    public int getJun() {
        return jun;
    }

    public void setJun(int jun) {
        this.jun = jun;
    }

    public int getJul() {
        return jul;
    }

    public void setJul(int jul) {
        this.jul = jul;
    }

    public int getAvgust() {
        return avgust;
    }

    public void setAvgust(int avgust) {
        this.avgust = avgust;
    }

    public int getSeptembar() {
        return septembar;
    }

    public void setSeptembar(int septembar) {
        this.septembar = septembar;
    }

    public int getOktobar() {
        return oktobar;
    }

    public void setOktobar(int oktobar) {
        this.oktobar = oktobar;
    }

    public int getNovembar() {
        return novembar;
    }

    public void setNovembar(int novembar) {
        this.novembar = novembar;
    }

    public int getDecembar() {
        return decembar;
    }

    public void setDecembar(int decembar) {
        this.decembar = decembar;
    }
}

