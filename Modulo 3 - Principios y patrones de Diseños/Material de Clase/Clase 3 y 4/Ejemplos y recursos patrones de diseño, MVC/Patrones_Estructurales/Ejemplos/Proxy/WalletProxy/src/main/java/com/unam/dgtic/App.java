package com.unam.dgtic;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class App {
    public static void main(String[] args) {
        startWalletBalance("123");
    }

    private static void startWalletBalance(String userId){
        Wallet app=new Wallet();
        app.checkBalance(userId);
    }
}
