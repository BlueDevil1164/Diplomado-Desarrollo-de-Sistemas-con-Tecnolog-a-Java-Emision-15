package edu.unam.proyectofinal.service.impl;


import edu.unam.proyectofinal.dao.LaptopDAO;
import edu.unam.proyectofinal.dao.impl.LaptopDAOImpl;
import edu.unam.proyectofinal.model.CatalogLaptops;
import edu.unam.proyectofinal.model.Laptop;
import edu.unam.proyectofinal.model.MeansLaptops;
import edu.unam.proyectofinal.service.LaptopService;

import java.util.List;

public class LaptopServiceImpl implements LaptopService {

    private static LaptopServiceImpl instance;
    private static final LaptopDAO laptopDAO = LaptopDAOImpl.getInstance();

    private LaptopServiceImpl() {}

    public static LaptopServiceImpl getInstance() {
        if (instance == null) {
            instance = new LaptopServiceImpl();
        }
        return instance;
    }

    @Override
    public Laptop getLaptopById(Integer id) {
        return laptopDAO.getLaptopById(id);
    }

    @Override
    public List<Laptop> getAllLaptops() {
        return laptopDAO.getAllLaptops();
    }

    @Override
    public Boolean insertLaptop(Laptop laptop) {
        return laptopDAO.insertLaptops(laptop);
    }

    @Override
    public Boolean updateLaptop(Laptop laptop) {
        return laptopDAO.updateLaptops(laptop);
    }

    @Override
    public Boolean deleteLaptop(Laptop laptop) {
        return laptopDAO.deleteLaptops(laptop);
    }

    @Override
    public List<MeansLaptops> getCatalogLaptops(CatalogLaptops catalogLaptops) {
        return laptopDAO.getCatalogLaptops(catalogLaptops);
    }

}