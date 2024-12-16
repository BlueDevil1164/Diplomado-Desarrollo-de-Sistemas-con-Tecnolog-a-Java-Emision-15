package edu.dgtic.ocp;

import java.util.List;

public abstract class Subscriber {
    private Long subscriberId;
    private String address;
    private Long phoneNumber;
    private int baseRate;

    // Constructor vacío
    public Subscriber() {
    }

    // Método abstracto para calcular la factura
    public abstract double calculateBill();

    // Métodos getter y setter para cada campo

    public Long getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Long subscriberId) {
        this.subscriberId = subscriberId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(int baseRate) {
        this.baseRate = baseRate;
    }
}

