package fa.training.dao;

import fa.training.entities.Warehouse;
import fa.training.entities.WarehouseBook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Set;
import java.util.stream.Collectors;

public class WarehouseBookDaoImpl implements WarehouseBookDao {
    private SessionFactory sessionFactory;
    Logger LOGGER = Logger.getLogger(WarehouseBook.class);
    public WarehouseBookDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public WarehouseBook insertWarehouseBook(WarehouseBook warehouseBook) {
        if (warehouseBook != null) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                session.save(warehouseBook);
                session.getTransaction().commit();
            } catch (HibernateException exception) {
                LOGGER.error(exception);
            } catch (Exception exception) {
                LOGGER.error(exception);
            }
        }
        return warehouseBook;
    }

    @Override
    public Set<WarehouseBook> getAllWarehouseBook() {
        Set<WarehouseBook> warehouseBooks = null;
            try(Session session = sessionFactory.openSession()){
                warehouseBooks = session.createQuery("FROM WarehouseBook ",WarehouseBook.class)
                        .getResultStream()
                        .collect(Collectors.toSet());
            }
        return warehouseBooks;
    }

    @Override
    public boolean updateWarehouseBook(WarehouseBook warehouseBook) {
        boolean check = false;
        if (warehouseBook != null) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                session.update(warehouseBook);
                session.getTransaction().commit();
                check =true;
            } catch (HibernateException exception) {
                LOGGER.error(exception);
            } catch (Exception exception) {
                LOGGER.error(exception);
            }
        }
        return check;
    }

    @Override
    public boolean deleteWarehouseBook(WarehouseBook warehouseBook) {
        boolean check = false;
        if (warehouseBook != null) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                session.delete(warehouseBook);
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
}
