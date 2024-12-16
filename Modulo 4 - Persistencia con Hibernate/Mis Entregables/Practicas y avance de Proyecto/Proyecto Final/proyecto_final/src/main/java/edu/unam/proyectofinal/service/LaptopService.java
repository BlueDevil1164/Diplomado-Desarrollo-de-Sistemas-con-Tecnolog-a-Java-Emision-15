package edu.unam.proyectofinal.service;

import edu.unam.proyectofinal.model.Laptop;

import edu.unam.proyectofinal.model.MeansLaptops;
import edu.unam.proyectofinal.model.CatalogLaptops;

import java.util.List;

public interface LaptopService {
    Laptop getLaptopById(Integer id);
    List<Laptop> getAllLaptops();
    Boolean insertLaptop(Laptop laptop);
    Boolean updateLaptop(Laptop laptop);
    Boolean deleteLaptop(Laptop laptop);
    List<MeansLaptops> getCatalogLaptops(CatalogLaptops catalogLaptops);
}

