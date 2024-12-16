package edu.unam.proyectofinal.dao.impl;


import edu.unam.proyectofinal.dao.CatalogLaptopsDAO;
import edu.unam.proyectofinal.hibernate.HibernateUtil;
import edu.unam.proyectofinal.model.CatalogLaptops;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


import java.util.List;

public class CatalogLaptopsDAOImpl extends GenericDAOImplHibernate<CatalogLaptops, Integer> implements CatalogLaptopsDAO {
    private static CatalogLaptopsDAOImpl instance;

    public CatalogLaptopsDAOImpl() {
    }

    public static CatalogLaptopsDAOImpl getInstance() {
        if (instance == null)
            instance = new CatalogLaptopsDAOImpl();
        return instance;
    }

    @Override
    public CatalogLaptops getCatalogLaptopsById(Integer id) {
        CatalogLaptops catalogLaptops = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // se inicia una transaccion
            session.beginTransaction();
            catalogLaptops = session.get(CatalogLaptops.class, id);
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
        return catalogLaptops;
    }

    @Override
    public List<CatalogLaptops> getAllCatalogLaptops() {
        List<CatalogLaptops> CatalogLaptopsList = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // se inicia una transaccion
            session.beginTransaction();
            //listPhoneType = session.createQuery("SELECT t FROM PhoneType t WHERE t.estatus = 'ACTIVO' ").list();
            CatalogLaptopsList = session.createQuery("SELECT t FROM CatalogLaptops t WHERE t.status = 'DISPONIBLE' ", CatalogLaptops.class).getResultList();
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
        return CatalogLaptopsList;
    }

    @Override
    public Boolean insertCatalogLaptops(CatalogLaptops catalogLaptops) {
        Boolean save = Boolean.FALSE;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // se inicia una transaccion
            session.beginTransaction();
            session.persist(catalogLaptops);
            save = catalogLaptops.getId() != null ? Boolean.TRUE : Boolean.FALSE;
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
    public Boolean updateCatalogLaptops(CatalogLaptops catalogLaptops) {
        Boolean update = Boolean.FALSE;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // se inicia una transaccion
            session.beginTransaction();
            session.merge(catalogLaptops);
            update = catalogLaptops.getId() != null ? Boolean.TRUE : Boolean.FALSE;
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
    public Boolean deleteCatalogLaptops(CatalogLaptops catalogLaptops) {
        Boolean delete = Boolean.FALSE;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // se inicia una transaccion
            session.beginTransaction();
            session.remove(catalogLaptops);
            delete = catalogLaptops.getId() != null ? Boolean.TRUE : Boolean.FALSE;
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