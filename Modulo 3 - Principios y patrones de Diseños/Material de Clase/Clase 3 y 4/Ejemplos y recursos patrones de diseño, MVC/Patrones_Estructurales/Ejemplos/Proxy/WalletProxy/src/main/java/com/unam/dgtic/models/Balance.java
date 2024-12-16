package com.unam.dgtic.models;

import java.math.BigDecimal;
import java.time.LocalDate;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class Balance {
    private String id;
    private String user;
    private BigDecimal balance;
    private String userId;
    private LocalDate lastMovement;
    private LocalDate firstMovement;

    public Balance(String user, BigDecimal balance, String userId, LocalDate lastMovement, LocalDate firstMovement) {
        this.user = user;
        this.balance = balance;
        this.userId = userId;
        this.lastMovement = lastMovement;
        this.firstMovement = firstMovement;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setMount(BigDecimal balance) {
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDate getLastMovement() {
        return lastMovement;
    }

    public void setLastMovement(LocalDate lastMovement) {
        this.lastMovement = lastMovement;
    }

    public LocalDate getFirstMovement() {
        return firstMovement;
    }

    public void setFirstMovement(LocalDate firstMovement) {
        this.firstMovement = firstMovement;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "user='" + user + '\'' +
                ", mount='" + balance.toString() + '\'' +
                ", userId='" + userId + '\'' +
                ", lastMovement=" + lastMovement +
                ", firstMovement=" + firstMovement +
                '}';
    }
}
