package edu.unam.proyectofinal.dao;

import edu.unam.proyectofinal.model.CatalogLaptops;
import edu.unam.proyectofinal.model.Laptop;
import edu.unam.proyectofinal.model.LaptopType;
import edu.unam.proyectofinal.model.MeansLaptops;

import java.util.List;

public interface LaptopDAO {

    Laptop getLaptopById(Integer id);

    List<Laptop> getAllLaptops();

    Boolean insertLaptops(Laptop laptop);

    Boolean updateLaptops(Laptop laptop);

    Boolean deleteLaptops(Laptop laptop);

    List<MeansLaptops> getCatalogLaptops(CatalogLaptops catalogLaptops);
}
