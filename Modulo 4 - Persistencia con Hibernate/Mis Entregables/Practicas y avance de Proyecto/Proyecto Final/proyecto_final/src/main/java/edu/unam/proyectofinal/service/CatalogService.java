package edu.unam.proyectofinal.service;


import edu.unam.proyectofinal.model.CatalogLaptops;
import edu.unam.proyectofinal.model.Laptop;
import edu.unam.proyectofinal.model.LaptopType;

import java.util.List;

public interface CatalogService {
    List<LaptopType> getAllLaptopType();

    LaptopType getLaptopTypeById(Integer id);

    List<CatalogLaptops> getAllCatalogLaptops();

    CatalogLaptops getCatalogLaptopsById(Integer id);
}
