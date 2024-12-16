package com.unam.dgtic.repository;

import java.util.List;

/***
 ** Unidad 3 - Principios y Patrones de Diseño
 **
 **  @author: hxa.dev
 ***/
public interface Repository <T extends Object> {
        List<T> findAll();
        T findById(String id);

        T findByUserId(String userId);

        void create(T t);

        void update(String id, T t);

        void delete(T t);
}
