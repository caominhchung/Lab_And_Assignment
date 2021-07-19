package fa.training.dao;

import fa.training.entities.Book;
import fa.training.utils.ValidatorUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Set;
import java.util.stream.Collectors;

public class BookDaoImpl implements BookDao {
    private SessionFactory sessionFactory;
    Logger LOGGER = Logger.getLogger(BookDaoImpl.class);

    public BookDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Book insertBook(Book book)  throws IllegalArgumentException{
        if (book != null) {
            try (Session session = sessionFactory.openSession()) {
                if (ValidatorUtil.validate(book)) {
                    session.beginTransaction();
                    session.save(book);
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
        return book;
    }

    @Override
    public Book getBookByISBN(String isbn) {
        Book book = null;
        if (isbn != null) {
            try (Session session = sessionFactory.openSession()) {
                book = session.get(Book.class, isbn);
            } catch (HibernateException exception) {
                LOGGER.error(exception);
            } catch (Exception exception) {
                LOGGER.error(exception);
            }
        }
        return book;
    }

    @Override
    public Set<Book> getAllBook() {
        Set<Book> books = null;
        try (Session session = sessionFactory.openSession()) {
            books = session.createQuery("FROM Book ", Book.class)
                    .getResultStream()
                    .collect(Collectors.toSet());
        } catch (HibernateException exception) {
            LOGGER.error(exception);
        } catch (Exception exception) {
            LOGGER.error(exception);
        }
        return books;
    }

    @Override
    public boolean updateBook(Book book) throws IllegalArgumentException {
        boolean check = false;
        if (book != null) {
            try (Session session = sessionFactory.openSession()) {
                if (ValidatorUtil.validate(book)) {
                    session.beginTransaction();
                    session.update(book);
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
    public boolean deleteBookById(String isbn) {
        boolean check = false;
        if (isbn != null) {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                Book book = new Book();
                book.setIsbn(isbn);
                session.delete(book);
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
    public Set<Book> getBookNotAvailable() {
        Set<Book> books = null;
        try (Session session = sessionFactory.openSession()) {
            books = session.createQuery("SELECT NEW Book (B.isbn,B.year,B.title,B.price) FROM Book AS B " +
                    "INNER JOIN B.warehouseBooks as WB " +
                    "GROUP BY B.isbn,B.year,B.title,B.price " +
                    "HAVING sum (WB.count) = 0", Book.class)
                    .getResultStream()
                    .collect(Collectors.toSet());
        } catch (HibernateException exception) {
            LOGGER.error(exception);
        } catch (Exception exception) {
            LOGGER.error(exception);
        }
        return books;
    }

    @Override
    public Set<Book> getBookTopNumberInWarehouse(int top) {
        Set<Book> books = null;
        try (Session session = sessionFactory.openSession()) {
            books = session.createQuery("SELECT NEW Book (B.isbn,B.year,B.title,B.price) FROM Book AS B " +
                    "INNER JOIN B.warehouseBooks as WB " +
                    "GROUP BY B.isbn,B.year,B.title,B.price " +
                    "ORDER BY count (WB.count) desc ", Book.class)
                    .setFirstResult(0)
                    .setMaxResults(top)
                    .getResultStream()
                    .collect(Collectors.toSet());
        } catch (HibernateException exception) {
            LOGGER.error(exception);
        } catch (Exception exception) {
            LOGGER.error(exception);
        }
        return books;
    }
}
