package com.unam.dgtic.repository;

import com.unam.dgtic.models.Balance;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class BalanceRepository implements Repository<Balance>{
    private List<Balance> balances;

    public BalanceRepository() {
        balances=new ArrayList<>();
        balances.add(new Balance("Admin", BigDecimal.valueOf(123),"123", LocalDate.now(),LocalDate.now()));
    }

    @Override
    public List<Balance> findAll() {
        return balances;
    }

    @Override
    public Balance findById(String id) {
        return balances.stream().filter(balance->balance.getId().equals(id)).findFirst().orElseThrow(NullPointerException::new);
    }

    @Override
    public Balance findByUserId(String userId) {
        return balances.stream().filter(balance->balance.getUserId().equals(userId)).findFirst().orElseThrow(NullPointerException::new);
    }

    @Override
    public void create(Balance balance) {
        balances.add(balance);
    }

    @Override
    public void update(String id,Balance balance) {
        balances.set(balances.indexOf(findById(id)),balance);

    }

    @Override
    public void delete(Balance balance) {
        balances.remove(balance);
    }
}
