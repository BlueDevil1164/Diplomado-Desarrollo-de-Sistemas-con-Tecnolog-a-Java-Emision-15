package com.unam.dgtic;

import com.unam.dgtic.proxy.BalanceVerificationProxy;
import com.unam.dgtic.repository.BalanceRepository;
import com.unam.dgtic.service.BalanceVerificationService;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Wallet {
    private BalanceVerificationService balanceVerificationService;

    public Wallet(){
        balanceVerificationService=new BalanceVerificationProxy(new BalanceRepository());
    }
    public void checkBalance(String userId){
        double balance= balanceVerificationService.checkBalance(userId);
        System.out.println("Saldo Actual: "+balance);

        // Resto de logica para mostrar el saldo y enviar transferencias
    }
}