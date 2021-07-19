package fa.training.dao;

import fa.training.entities.Book;
import fa.training.entities.Warehouse;
import fa.training.entities.WarehouseBook;
import fa.training.utils.HibernateUtil;
import org.junit.jupiter.api.*;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WarehouseBookDaoImplTest {
    static BookDao bookDao;
    static WarehouseDao warehouseDao;
    static  WarehouseBookDao warehouseBookDao;
    @BeforeAll
    public static void setUpClass(){
        bookDao = new BookDaoImpl(HibernateUtil.getSessionFactory());
        warehouseBookDao = new WarehouseBookDaoImpl(HibernateUtil.getSessionFactory());
        warehouseDao = new WarehouseDaoImpl(HibernateUtil.getSessionFactory());
        Book book1 = new Book("BOOK400",2011,"Name Book 201",123123.0);
        Book book2 = new Book("BOOK401",2011,"Name Book 21",123123.0);
        Book book3 = new Book("BOOK402",2011,"Name Book 21",123123.0);
        Book book4 = new Book("BOOK403",2011,"Name Book 21",123123.0);
        Book book5 = new Book("BOOK404",2011,"Name Book 21",123123.0);
        Book book6 = new Book("BOOK405",2011,"Name Book 21",123123.0);
        Book book7 = new Book("BOOK406",2011,"Name Book 21",123123.0);
        Book book8 = new Book("BOOK407",2011,"Name Book 21",123123.0);
        Book book9 = new Book("BOOK408",2011,"Name Book 21",123123.0);
        bookDao.insertBook(book1);
        bookDao.insertBook(book2);
        bookDao.insertBook(book3);
        bookDao.insertBook(book4);
        bookDao.insertBook(book5);
        bookDao.insertBook(book6);
        bookDao.insertBook(book7);
        bookDao.insertBook(book8);
        bookDao.insertBook(book9);
        Warehouse warehouse1 = new Warehouse(400,"0999999999","Street 1");
        Warehouse warehouse2 = new Warehouse(410,"0999999998","Street 2");
        Warehouse warehouse3 = new Warehouse(420,"0999999997","Street 3");
        Warehouse warehouse4 = new Warehouse(430,"0999999996","Street 4");
        warehouseDao.insertWarehouse(warehouse1);
        warehouseDao.insertWarehouse(warehouse2);
        warehouseDao.insertWarehouse(warehouse3);
        warehouseDao.insertWarehouse(warehouse4);
        WarehouseBook warehouseBook1 = new WarehouseBook(book1,warehouse1,44);
        WarehouseBook warehouseBook2 = new WarehouseBook(book2,warehouse1,23);
        WarehouseBook warehouseBook3 = new WarehouseBook(book3,warehouse1,110);
        WarehouseBook warehouseBook4 = new WarehouseBook(book4,warehouse1,20);
        WarehouseBook warehouseBook5 = new WarehouseBook(book5,warehouse1,12);

        WarehouseBook warehouseBook6 = new WarehouseBook(book1,warehouse2,12);
        WarehouseBook warehouseBook7 = new WarehouseBook(book2,warehouse2,121);
        WarehouseBook warehouseBook8 = new WarehouseBook(book5,warehouse4,32);
        WarehouseBook warehouseBook9 = new WarehouseBook(book4,warehouse4,32);
        WarehouseBook warehouseBook10 = new WarehouseBook(book3,warehouse3,12);
        WarehouseBook warehouseBook11 = new WarehouseBook(book6,warehouse3,42);
        WarehouseBook warehouseBook12 = new WarehouseBook(book6,warehouse2,0);
        WarehouseBook warehouseBook13 = new WarehouseBook(book8,warehouse1,0);
        WarehouseBook warehouseBook14 = new WarehouseBook(book9,warehouse2,0);
        WarehouseBook warehouseBook15 = new WarehouseBook(book7,warehouse3,0);

        warehouseBookDao.insertWarehouseBook(warehouseBook1);
        warehouseBookDao.insertWarehouseBook(warehouseBook2);
        warehouseBookDao.insertWarehouseBook(warehouseBook3);
        warehouseBookDao.insertWarehouseBook(warehouseBook4);
        warehouseBookDao.insertWarehouseBook(warehouseBook5);
        warehouseBookDao.insertWarehouseBook(warehouseBook6);
        warehouseBookDao.insertWarehouseBook(warehouseBook7);
        warehouseBookDao.insertWarehouseBook(warehouseBook8);
        warehouseBookDao.insertWarehouseBook(warehouseBook9);
        warehouseBookDao.insertWarehouseBook(warehouseBook11);
        warehouseBookDao.insertWarehouseBook(warehouseBook10);
        warehouseBookDao.insertWarehouseBook(warehouseBook12);
        warehouseBookDao.insertWarehouseBook(warehouseBook13);
        warehouseBookDao.insertWarehouseBook(warehouseBook14);
        warehouseBookDao.insertWarehouseBook(warehouseBook15);
    }
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Order(5)
    void insertWarehouseBook() {
        Book book = new Book("BOOK601",2011,"Name Book 201",123123.0);
        Warehouse warehouse = new Warehouse(601,"0999999998","Street 2");
        bookDao.insertBook(book);
        warehouseDao.insertWarehouse(warehouse);

        WarehouseBook warehouseBook = new WarehouseBook(book,warehouse,300);
        WarehouseBook warehouseBook1 = warehouseBookDao.insertWarehouseBook(warehouseBook);
        assertEquals(300, warehouseBook1.getCount());
    }

    @Test
    @Order(1)
    void getAllWarehouseBook_test1() {
        Set<WarehouseBook>  warehouseBooks = warehouseBookDao.getAllWarehouseBook();
        assertEquals(15,warehouseBooks.size());
    }

    @Test
    @Order(1)
    void getAllWarehouseBook_test2() {
        Book book = new Book("BOOK603",2011,"Name Book 201",123123.0);
        Warehouse warehouse = new Warehouse(603,"0999999998","Street 2");
        bookDao.insertBook(book);
        warehouseDao.insertWarehouse(warehouse);

        WarehouseBook warehouseBook = new WarehouseBook(book,warehouse,400);
        warehouseBookDao.insertWarehouseBook(warehouseBook);

        Set<WarehouseBook>  warehouseBooks = warehouseBookDao.getAllWarehouseBook();
        assertEquals(16,warehouseBooks.size());
    }
    @Test
    void updateWarehouseBook() {
    }

    @Test
    void deleteWarehouseBook() {
    }
}