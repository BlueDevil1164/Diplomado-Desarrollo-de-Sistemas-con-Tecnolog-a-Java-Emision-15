package com.unam.dgtic.proxy;

import com.unam.dgtic.models.Balance;
import com.unam.dgtic.repository.BalanceRepository;
import com.unam.dgtic.repository.Repository;
import com.unam.dgtic.service.BalanceVerificationService;
import com.unam.dgtic.service.BalanceVerificationServiceImpl;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public class BalanceVerificationProxy implements BalanceVerificationService {
    private BalanceVerificationService realService;
    private Repository<Balance> repository;
    public BalanceVerificationProxy(Repository<Balance> repository) {
        this.repository = repository;
    }

    @Override
    public double checkBalance(String userId) {
        if(validateAccess(userId)){
            return getRealService().checkBalance(userId);
        }else{
            throw new RuntimeException("Acceso no autorizado");
        }
    }


    private boolean validateAccess(String userId){
        boolean valid=repository.findByUserId(userId).getBalance().doubleValue()>1;
        return valid;
    }

    private BalanceVerificationService getRealService(){
        if(realService==null)
            realService=new BalanceVerificationServiceImpl(new BalanceRepository());

        return realService;
    }
}
