package com.unam.dgtic.service;

import com.unam.dgtic.models.Balance;
import com.unam.dgtic.repository.Repository;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class BalanceVerificationServiceImpl implements BalanceVerificationService{

    // Repositorio para acceder a base de datos
    Repository<Balance> repository;

    public BalanceVerificationServiceImpl(Repository<Balance> repository) {
        this.repository = repository;
    }

    @Override
    public double checkBalance(String userId) {
        // Obtener el balance de la base de datos
        return repository.findByUserId(userId).getBalance().doubleValue();
    }
}
