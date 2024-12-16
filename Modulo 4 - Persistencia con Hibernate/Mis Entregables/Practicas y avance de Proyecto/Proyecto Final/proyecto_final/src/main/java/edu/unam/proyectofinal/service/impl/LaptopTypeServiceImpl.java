package edu.unam.proyectofinal.service.impl;

import edu.unam.proyectofinal.model.LaptopType;
import edu.unam.proyectofinal.service.LaptopTypeService;

import java.util.List;

public class LaptopTypeServiceImpl implements LaptopTypeService {
    private static LaptopTypeServiceImpl instance;


    private LaptopTypeServiceImpl() {
    }

    public static LaptopTypeService getInstance() {
        if (instance == null)
            instance = new LaptopTypeServiceImpl();
        return instance;
    }

    @Override
    public List<LaptopType> getAllContactType() {
        return null;
    }
    @Override
    public LaptopType getLaptopTypeById(Integer id) {

        return null;
    }

    @Override
    public Boolean insertLaptopType(LaptopType laptopType) {
        return null;
    }

    @Override
    public Boolean updateLaptopType(LaptopType laptopType) {
        return null;
    }

    @Override
    public Boolean deleteLaptopType(LaptopType laptopType) {
        return null;
    }
}