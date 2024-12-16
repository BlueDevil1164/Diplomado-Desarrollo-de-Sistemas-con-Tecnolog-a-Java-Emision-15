package edu.unam.proyectofinal.service.impl;

import edu.unam.proyectofinal.service.CatalogLaptopsService;
import edu.unam.proyectofinal.model.CatalogLaptops;
import edu.unam.proyectofinal.service.CatalogLaptopsService;

import java.util.List;

public class CatalogLaptopsServiceImpl implements CatalogLaptopsService {
    private static CatalogLaptopsServiceImpl instance;
    //private static final PhoneTypeDAO phoneTypeDAO = PhoneTypeDAOImpl.getInstance();

    private CatalogLaptopsServiceImpl() {
    }

    public static CatalogLaptopsServiceImpl getInstance() {
        if (instance == null)
            instance = new CatalogLaptopsServiceImpl();
        return instance;
    }

    @Override
    public List<CatalogLaptops> getAllCatalogLaptops() {
        //return phoneTypeDAO.getAllPhoneTypes();
        return null;
    }

    @Override
    public CatalogLaptops getCatalogLaptopsById(Integer id) {
        //return phoneTypeDAO.getPhoneTypeById(id);
        return null;
    }

    @Override
    public Boolean insertCatalogLaptops(CatalogLaptops catalogLaptop) {
        //return phoneTypeDAO.insertPhoneType(phoneType);
        return null;
    }

    @Override
    public Boolean updateCatalogLaptops(CatalogLaptops catalogLaptop) {
        //return phoneTypeDAO.updatePhoneType(phoneType);
        return null;
    }

    @Override
    public Boolean deleteCatalogLaptops(CatalogLaptops catalogLaptop) {
        //return phoneTypeDAO.deletePhoneType(phoneType);
        return null;
    }
}
