package edu.unam.proyectofinal.service;

import edu.unam.proyectofinal.model.MeansLaptops;

import java.util.List;

public interface MeansLaptopsService {
    MeansLaptops getMeansLaptopsById(Integer id);
    List<MeansLaptops> getAllMeansLaptops();
    Boolean insertMeansLaptops(MeansLaptops laptop);
    Boolean updateMeansLaptops(MeansLaptops laptop);
    Boolean deleteMeansLaptops(MeansLaptops laptop);
    List<MeansLaptops> getMeansLaptopsByLaptop(Integer id);
}