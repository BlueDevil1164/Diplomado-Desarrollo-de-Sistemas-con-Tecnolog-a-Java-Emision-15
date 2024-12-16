package edu.unam.proyectofinal.service;

import edu.unam.proyectofinal.model.CatalogLaptops;

import java.util.List;

public interface CatalogLaptopsService {
    List<CatalogLaptops> getAllCatalogLaptops();
    CatalogLaptops getCatalogLaptopsById(Integer id);
    Boolean insertCatalogLaptops(CatalogLaptops catalogLaptops);
    Boolean updateCatalogLaptops(CatalogLaptops catalogLaptops);
    Boolean deleteCatalogLaptops(CatalogLaptops catalogLaptops);
}
