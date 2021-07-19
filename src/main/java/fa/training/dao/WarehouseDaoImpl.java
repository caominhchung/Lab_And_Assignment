package fa.training.dao;

import fa.training.entities.Warehouse;
import fa.training.entities.WarehouseBook;
import fa.training.utils.ValidatorUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import fa.training.entities.Book;
import fa.training.utils.ValidatorUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.Set;
import java.util.stream.Collectors;

public class WarehouseDaoImpl implements WarehouseDao {
    private SessionFactory sessionFactory;
    Logger LOGGER = Logger.getLogger(WarehouseDaoImpl.class);

    public WarehouseDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Warehouse insertWarehouse(Warehouse warehouse) throws IllegalArgumentException{
        if (warehouse != null) {
            try (Session session = sessionFactory.openSession()) {
                if (ValidatorUtil.validate(warehouse)) {
                    session.beginTransaction();
                    session.save(warehouse);
                    session.getTransaction().commit();
                }
            } catch (IllegalArgumentException exception) {
                LOGGER.error(exception);
                throw new IllegalArgumentException();
            } catch (HibernateException exception) {
                LOGGER.error(exception);
            } catch (Exception exception) {
                LOGGER.error(exception);
            }
        }
        return warehouse;
    }

    @Override
    public Warehouse getWarehouseByCode(Integer code) {
        Warehouse warehouse = null;
        try (Session session = sessionFactory.openSession()) {
            warehouse = session.get(Warehouse.class, code);
        } catch (HibernateException exception) {
            LOGGER.error(exception);
        } catch (Exception exception) {
            LOGGER.error(exception);
        }
        return warehouse;
    }

    @Override
    public Set<Warehouse> getAllWarehouse() {
        Set<Warehouse> warehouses = null;
        try (Session session = sessionFactory.openSession()) {
            warehouses = session.createQuery("from Warehouse ", Warehouse.class)
                    .getResultStream()
                    .collect(Collectors.toSet());
        } catch (HibernateException exception) {
            LOGGER.error(exception);
        } catch (Exception exception) {
            LOGGER.error(exception);
        }
        return warehouses;
    }

    @Override
    public boolean updateWarehouse(Warehouse warehouse) throws IllegalArgumentException {
        boolean check = false;
        if (warehouse != null) {
            try (Session session = sessionFactory.openSession()) {
                if (ValidatorUtil.validate(warehouse)) {
                    session.beginTransaction();
                    session.update(warehouse);
                    session.getTransaction().commit();
                    check = true;
                }
            } catch (IllegalArgumentException exception) {
                LOGGER.error(exception);
                throw new IllegalArgumentException();
            } catch (HibernateException exception) {
                LOGGER.error(exception);
            } catch (Exception exception) {
                LOGGER.error(exception);
            }
        }
        return check;
    }

    @Override
    public boolean deleteWarehouseByCode(Integer code) {
        boolean check = false;
        if (code != null) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                Warehouse warehouse = new Warehouse();
                warehouse.setCode(code);
                session.delete(warehouse);
                session.getTransaction().commit();
                check = true;
            } catch (HibernateException exception) {
                LOGGER.error(exception);
            } catch (Exception exception) {
                LOGGER.error(exception);
            }
        }
        return check;
    }

    @Override
    public Set<Warehouse> getWarehouseTopNumberOfBook(int top) {
        Set<Warehouse> warehouses = null;
        try (Session session = sessionFactory.openSession()) {
            warehouses = session.createQuery("SELECT NEW Warehouse(W.code,W.phone,W.address) FROM Warehouse AS W " +
                    "INNER JOIN W.warehouseBooks as WHB " +
                    "GROUP BY W.code,W.phone,W.address " +
                    "ORDER BY SUM (WHB.count) DESC ", Warehouse.class)
                    .setMaxResults(top)
                    .getResultStream()
                    .collect(Collectors.toSet());
        } catch (HibernateException exception) {
            LOGGER.error(exception);
        } catch (Exception exception) {
            LOGGER.error(exception);
        }
        return warehouses;
    }

}
