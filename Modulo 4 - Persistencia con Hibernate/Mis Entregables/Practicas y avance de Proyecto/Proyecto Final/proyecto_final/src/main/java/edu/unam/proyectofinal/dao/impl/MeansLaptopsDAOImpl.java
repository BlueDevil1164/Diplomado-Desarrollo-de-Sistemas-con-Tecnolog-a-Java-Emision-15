package edu.unam.proyectofinal.dao.impl;


import edu.unam.proyectofinal.dao.MeansLaptopsDAO;
import edu.unam.proyectofinal.hibernate.HibernateUtil;
import edu.unam.proyectofinal.model.MeansLaptops;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class MeansLaptopsDAOImpl implements MeansLaptopsDAO {
    private static MeansLaptopsDAOImpl instance;

    private MeansLaptopsDAOImpl() {
    }

    public static MeansLaptopsDAOImpl getInstance() {
        if (instance == null)
            instance = new MeansLaptopsDAOImpl();
        return instance;
    }

    @Override
    public MeansLaptops getMeansLaptopsById(Integer id) {
        MeansLaptops meansLaptops = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // se inicia una transaccion
            session.beginTransaction();
            meansLaptops = session.get(MeansLaptops.class, id);
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
        return meansLaptops;
    }

    @Override
    public List<MeansLaptops> getAllMeansLaptops() {
        List<MeansLaptops> meansContactsList = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // se inicia una transaccion
            session.beginTransaction();
            //catalogo = session.createQuery("FROM Contact").list();
            meansContactsList = session.createQuery("FROM MeansLaptops", MeansLaptops.class).getResultList();
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
        return meansContactsList;
    }

    @Override
    public List<MeansLaptops> getMeansLaptopsByLaptop(Integer id) {
        List<MeansLaptops> meansLaptopsList = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // se inicia una transaccion
            session.beginTransaction();
            meansLaptopsList = session.createQuery("SELECT e FROM MeansLaptops WHERE e.id=4", MeansLaptops.class)
                    //.setParameter("id", id)
                    .getResultList();
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
        return meansLaptopsList;
    }

    @Override
    public Boolean insertMeansLaptops(MeansLaptops laptop) {
        Boolean save = Boolean.FALSE;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // se inicia una transaccion
            session.beginTransaction();
            //session.save(laptop);
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
    public Boolean updateMeansLaptops(MeansLaptops laptop) {
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
    public Boolean deleteMeansLaptops(MeansLaptops laptop) {
        Boolean delete = Boolean.FALSE;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // se inicia una transaccion
            session.beginTransaction();
            session.remove(laptop);
            delete = laptop.getId() != null ? Boolean.TRUE : Boolean.FALSE;
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
        return delete;
    }
}