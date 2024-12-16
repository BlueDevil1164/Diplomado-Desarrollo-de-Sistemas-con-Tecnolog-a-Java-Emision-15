package edu.unam.proyectofinal.service.impl;

import edu.unam.proyectofinal.dao.CatalogLaptopsDAO;
import edu.unam.proyectofinal.dao.LaptopTypeDAO;
import edu.unam.proyectofinal.dao.impl.CatalogLaptopsDAOImpl;
import edu.unam.proyectofinal.dao.impl.LaptopTypeDAOImpl;
import edu.unam.proyectofinal.model.CatalogLaptops;
import edu.unam.proyectofinal.model.LaptopType;
import edu.unam.proyectofinal.service.CatalogService;

import java.util.List;

public class CatalogServiceImpl implements CatalogService {

    private static CatalogServiceImpl instance;

    private CatalogServiceImpl() {
    }

    public static CatalogServiceImpl getInstance() {
        if (instance == null) {
            instance = new CatalogServiceImpl();
        }
        return instance;
    }

    @Override
    public LaptopType getLaptopTypeById(Integer id) {
        LaptopTypeDAO dao = new LaptopTypeDAOImpl();
        return dao.get(id);
    }

    @Override
    public List<LaptopType> getAllLaptopType() {
        LaptopTypeDAO dao = new LaptopTypeDAOImpl();
        return dao.findAll();
    }

    @Override
    public List<CatalogLaptops> getAllCatalogLaptops() {
        CatalogLaptopsDAO dao = new CatalogLaptopsDAOImpl();
        return dao.findAll();
    }

    @Override
    public CatalogLaptops getCatalogLaptopsById(Integer id) {
        CatalogLaptopsDAO dao = new CatalogLaptopsDAOImpl();
        return dao.get(id);
    }

}