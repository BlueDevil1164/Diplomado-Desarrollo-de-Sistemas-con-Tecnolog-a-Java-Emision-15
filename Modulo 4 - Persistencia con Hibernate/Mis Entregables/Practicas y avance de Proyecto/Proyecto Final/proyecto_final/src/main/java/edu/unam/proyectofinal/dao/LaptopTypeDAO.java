package edu.unam.proyectofinal.dao;

import edu.unam.proyectofinal.model.Laptop;
import edu.unam.proyectofinal.model.LaptopType;

public interface LaptopTypeDAO extends GenericDAO<LaptopType, Integer> {
    Laptop getLaptopById(Integer id);
}
