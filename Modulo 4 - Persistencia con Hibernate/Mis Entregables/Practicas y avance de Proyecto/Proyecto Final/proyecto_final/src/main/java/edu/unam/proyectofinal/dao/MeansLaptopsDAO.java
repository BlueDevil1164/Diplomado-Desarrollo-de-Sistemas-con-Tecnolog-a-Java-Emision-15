package edu.unam.proyectofinal.dao;

import edu.unam.proyectofinal.model.MeansLaptops;

import java.util.List;

public interface MeansLaptopsDAO {
    MeansLaptops getMeansLaptopsById(Integer id);

    List<MeansLaptops> getAllMeansLaptops();

    Boolean insertMeansLaptops(MeansLaptops laptop);

    Boolean updateMeansLaptops(MeansLaptops laptop);

    Boolean deleteMeansLaptops(MeansLaptops laptop);

    List<MeansLaptops> getMeansLaptopsByLaptop(Integer id);
}


