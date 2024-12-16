package edu.unam.proyectofinal.dao;

import edu.unam.proyectofinal.model.CatalogLaptops;

import java.util.List;

public interface CatalogLaptopsDAO extends GenericDAO<CatalogLaptops, Integer> {
    List<CatalogLaptops> getAllCatalogLaptops();

    CatalogLaptops getCatalogLaptopsById(Integer id);

    Boolean insertCatalogLaptops(CatalogLaptops catalogLaptops);

    Boolean updateCatalogLaptops(CatalogLaptops catalogLaptops);

    Boolean deleteCatalogLaptops(CatalogLaptops catalogLaptops);
}
