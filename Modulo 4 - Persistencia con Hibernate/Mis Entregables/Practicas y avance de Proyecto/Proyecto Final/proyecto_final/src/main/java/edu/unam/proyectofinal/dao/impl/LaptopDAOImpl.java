package edu.unam.proyectofinal.dao.impl;

import edu.unam.proyectofinal.dao.LaptopDAO;
import edu.unam.proyectofinal.model.CatalogLaptops;
import edu.unam.proyectofinal.model.Laptop;
import edu.unam.proyectofinal.model.MeansLaptops;
import edu.unam.proyectofinal.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class LaptopDAOImpl implements LaptopDAO {
    private static LaptopDAOImpl instance;

    private LaptopDAOImpl() {
    }

    public static LaptopDAOImpl getInstance() {
        if (instance == null) {
            instance = new LaptopDAOImpl();
        }
        return instance;
    }

    @Override
    public Laptop getLaptopById(Integer id) {
        Laptop laptop = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // se inicia una transaccion
            session.beginTransaction();
            laptop = session.get(Laptop.class, id);
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
        return laptop;
    }

    @Override
    public List<Laptop> getAllLaptops() {
        List<Laptop> laptopList = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // se inicia una transaccion
            session.beginTransaction();
            //catalogo = session.createQuery("FROM laptop").list();
            laptopList = session.createQuery("FROM Laptop", Laptop.class).getResultList();
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
        return laptopList;
    }

    @Override
    public Boolean insertLaptops(Laptop laptop) {
        Boolean save = Boolean.FALSE;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // se inicia una transaccion
            session.beginTransaction();
            //session.save(laptopList);
            session.persist(laptop);
            save = laptop.getId() != null ? Boolean.TRUE : Boolean.FALSE;
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
        return save;
    }

    @Override
    public Boolean updateLaptops(Laptop laptop) {
        Boolean update = Boolean.FALSE;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // se inicia una transaccion
            session.beginTransaction();
            //session.update(laptop);
            session.merge(laptop);
            update = laptop.getId() != null ? Boolean.TRUE : Boolean.FALSE;
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
        return update;
    }

    @Override
    public Boolean deleteLaptops(Laptop laptop) {
        Boolean delete = Boolean.FALSE;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();
            session.remove(laptop);
            delete = laptop.getId() != null ? Boolean.TRUE : Boolean.FALSE;
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
        return delete;
    }


    @Override
    public List<MeansLaptops> getCatalogLaptops(CatalogLaptops medioLaptop) {
        List<MeansLaptops> meansLaptopsList = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            meansLaptopsList = session.createQuery("SELECT cm FROM MeansLaptops cm WHERE cm.catalogLaptops.id =:idMedioLaptop",
                    MeansLaptops.class).setParameter("idMedioLaptop", medioLaptop.getId()).getResultList();
            session.getTransaction().commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
        return meansLaptopsList;
    }

}
