package edu.unam.proyectofinal.service;

import edu.unam.proyectofinal.model.LaptopType;

import java.util.List;

public interface LaptopTypeService {

    LaptopType getLaptopTypeById(Integer id);
    List<LaptopType> getAllContactType();
    Boolean insertLaptopType(LaptopType laptopType);
    Boolean updateLaptopType(LaptopType laptopType);
    Boolean deleteLaptopType(LaptopType laptopType);

}
