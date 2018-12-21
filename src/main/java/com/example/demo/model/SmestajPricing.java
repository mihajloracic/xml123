package com.example.demo.model;

import com.example.demo.model.dto.PricingDTO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class SmestajPricing implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "smestaj_id", nullable = false)
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    private Smestaj smestaj;

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


    public SmestajPricing(){}


    public SmestajPricing(long id, Smestaj smestaj, int januar, int februar, int mart, int april, int maj, int jun, int jul, int avgust, int septembar, int oktobar, int novembar, int decembar) {
        this.id = id;
        this.smestaj = smestaj;
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

    public SmestajPricing(PricingDTO pricingDTO){
        this.januar = pricingDTO.getJanuar();
        this.februar = pricingDTO.getFebruar();
        this.mart = pricingDTO.getMart();
        this.april  = pricingDTO.getApril();
        this.maj = pricingDTO.getMaj();
        this.jun= pricingDTO.getJun();
        this.jul = pricingDTO.getJul();
        this.avgust= pricingDTO.getAvgust();
        this.septembar = pricingDTO.getSeptembar();
        this.oktobar = pricingDTO.getOktobar();
        this.novembar = pricingDTO.getNovembar();
        this.decembar = pricingDTO.getDecembar();

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Smestaj getSmestaj() {
        return smestaj;
    }

    public void setSmestaj(Smestaj smestaj) {
        this.smestaj = smestaj;
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
