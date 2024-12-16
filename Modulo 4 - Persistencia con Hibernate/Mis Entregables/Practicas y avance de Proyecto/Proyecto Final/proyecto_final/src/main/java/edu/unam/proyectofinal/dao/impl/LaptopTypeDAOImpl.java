package edu.unam.proyectofinal.dao.impl;

import edu.unam.proyectofinal.dao.LaptopTypeDAO;
import edu.unam.proyectofinal.model.Laptop;
import edu.unam.proyectofinal.model.LaptopType;

public class LaptopTypeDAOImpl extends GenericDAOImplHibernate<LaptopType, Integer> implements LaptopTypeDAO {
    @Override
    public Laptop getLaptopById(Integer id) {
        return null;
    }
}
