package com.unam.dgtic.repository;

import com.unam.dgtic.models.Balance;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/

public class BalanceRepositoryTest  {
    Repository<Balance> balanceRepository;

    @Before
    public void setUp() throws Exception {
        balanceRepository=new BalanceRepository();
        balanceRepository.create(new Balance("Alfonso",new BigDecimal(20000), UUID.randomUUID().toString(), LocalDate.now().minusYears(1),LocalDate.now().minusYears(1)));
        balanceRepository.create(new Balance("Yessica",new BigDecimal(22000), UUID.randomUUID().toString(), LocalDate.now().minusDays(1),LocalDate.now().minusYears(1)));
    }

    @Test
    public void testFindAllBalancesListWhenListIsNotEmpty() {
        // Given
        var balances=balanceRepository.findAll();
        // When

        // Then
        assertNotNull(balances);
        assertNotNull(balances.get(0));
    }

    @Test
    public void testFindAllBalancesListWhenListIsEmpty() {
        // Given
        var balances=balanceRepository.findAll();
        var emptyBalances=new ArrayList<Balance>();

        // When
        balances.clear();
        // Then
        assertArrayEquals(balances.toArray(),emptyBalances.toArray());
    }

    public void testFindById() {
    }

    public void testFindByUserId() {
    }
}