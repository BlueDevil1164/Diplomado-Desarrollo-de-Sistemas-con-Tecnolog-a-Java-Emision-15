package edu.unam.proyectofinal.service.impl;

import edu.unam.proyectofinal.dao.MeansLaptopsDAO;
import edu.unam.proyectofinal.dao.impl.MeansLaptopsDAOImpl;
import edu.unam.proyectofinal.model.MeansLaptops;
import edu.unam.proyectofinal.service.MeansLaptopsService;
import edu.unam.proyectofinal.service.impl.MeansLaptopsServiceImpl;


import java.util.List;

public class MeansLaptopsServiceImpl implements MeansLaptopsService {

    private static MeansLaptopsServiceImpl instance;
    private static MeansLaptopsDAO laptopDAO = MeansLaptopsDAOImpl.getInstance();

    private MeansLaptopsServiceImpl() {}

    public static MeansLaptopsServiceImpl getInstance() {
        if (instance == null) {
            instance = new MeansLaptopsServiceImpl();
        }
        return instance;
    }

    @Override
    public MeansLaptops getMeansLaptopsById(Integer id) {
        return laptopDAO.getMeansLaptopsById(id);
    }

    @Override
    public List<MeansLaptops> getAllMeansLaptops() {
        return laptopDAO.getAllMeansLaptops();
    }

    @Override
    public Boolean insertMeansLaptops(MeansLaptops laptop) {
        return laptopDAO.insertMeansLaptops(laptop);
    }

    @Override
    public Boolean updateMeansLaptops(MeansLaptops laptop) {
        return laptopDAO.updateMeansLaptops(laptop);
    }

    @Override
    public Boolean deleteMeansLaptops(MeansLaptops laptop) {
        return laptopDAO.deleteMeansLaptops(laptop);
    }

    @Override
    public List<MeansLaptops> getMeansLaptopsByLaptop(Integer id) {
        return laptopDAO.getMeansLaptopsByLaptop(id);
    }
}