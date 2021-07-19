package fa.training.dao;

import fa.training.entities.Book;
import fa.training.entities.Warehouse;
import fa.training.entities.WarehouseBook;
import fa.training.utils.HibernateUtil;
import org.junit.jupiter.api.*;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WarehouseDaoImplTest {
    static BookDao bookDao;
    static WarehouseDao warehouseDao;
    static  WarehouseBookDao warehouseBookDao;
    @BeforeAll
    public static void setUpClass(){
        bookDao = new BookDaoImpl(HibernateUtil.getSessionFactory());
        warehouseBookDao = new WarehouseBookDaoImpl(HibernateUtil.getSessionFactory());
        warehouseDao = new WarehouseDaoImpl(HibernateUtil.getSessionFactory());
        Book book1 = new Book("BOOK300",2011,"Name Book 201",123123.0);
        Book book2 = new Book("BOOK301",2011,"Name Book 21",123123.0);
        Book book3 = new Book("BOOK302",2011,"Name Book 21",123123.0);
        Book book4 = new Book("BOOK303",2011,"Name Book 21",123123.0);
        Book book5 = new Book("BOOK304",2011,"Name Book 21",123123.0);
        Book book6 = new Book("BOOK305",2011,"Name Book 21",123123.0);
        Book book7 = new Book("BOOK305",2011,"Name Book 21",123123.0);
        Book book8 = new Book("BOOK305",2011,"Name Book 21",123123.0);
        Book book9 = new Book("BOOK305",2011,"Name Book 21",123123.0);
        bookDao.insertBook(book1);
        bookDao.insertBook(book2);
        bookDao.insertBook(book3);
        bookDao.insertBook(book4);
        bookDao.insertBook(book5);
        bookDao.insertBook(book6);
        bookDao.insertBook(book7);
        bookDao.insertBook(book8);
        bookDao.insertBook(book9);
        Warehouse warehouse1 = new Warehouse(310,"0999999999","Street 1");
        Warehouse warehouse2 = new Warehouse(312,"0999999998","Street 2");
        Warehouse warehouse3 = new Warehouse(313,"0999999997","Street 3");
        Warehouse warehouse4 = new Warehouse(314,"0999999996","Street 4");
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
    @Order(1)
    void insertWarehouse_test1_nomal() {
        Warehouse warehouse = new Warehouse(1,"0999999999","Street 1");
        warehouseDao.insertWarehouse(warehouse);
        assertEquals(warehouse,warehouseDao.getWarehouseByCode(1));

    }
    @Test
    @Order(2)
    void insertWarehouse_phone_invalid_exception() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Warehouse warehouse = new Warehouse(2,"00000","Street 1");
            warehouseDao.insertWarehouse(warehouse);
        });
    }

    @Test
    @Order(3)
    void insertWarehouse_phone_null() {
        Warehouse warehouse = null;
        warehouse = warehouseDao.insertWarehouse(warehouse);
        assertEquals(null,warehouse);
    }

    @Test
    @Order(4)
    void getWarehouseByCode() {
        Warehouse warehouse = new Warehouse(3,"0999999999","Street 1");
        warehouseDao.insertWarehouse(warehouse);

        Warehouse warehouse2 = warehouseDao.getWarehouseByCode(3);
        assertEquals(warehouse ,warehouse2);
    }

    @Test
    @Order(5)
    void getAllWarehouse_test1() {
        Set<Warehouse> warehouses = warehouseDao.getAllWarehouse();
        assertEquals(6,warehouses.size());
    }

    @Test
    @Order(5)
    void getAllWarehouse_test2() {
        Warehouse warehouse = new Warehouse(10,"0999999999","Street 1");
        warehouseDao.insertWarehouse(warehouse);

        Set<Warehouse> warehouses = warehouseDao.getAllWarehouse();
        assertEquals(7,warehouses.size());
    }

    @Test
    @Order(6)
    void updateWarehouse() {
        Warehouse warehouse = new Warehouse(4,"0999999999","Street 1");
        warehouseDao.insertWarehouse(warehouse);

        Warehouse warehouse2 = new Warehouse(4,"0888888888","Street 2");
        assertTrue(warehouseDao.updateWarehouse(warehouse2));
    }

    @Test
    @Order(7)
    void delteWarehouse() {
        Warehouse warehouse = new Warehouse(5,"0999999999","Street 1");
        warehouseDao.insertWarehouse(warehouse);

        assertTrue(warehouseDao.deleteWarehouseByCode(5));
    }
    @Test
    @Order(8)
    void getWarehouseTopNumberOfBook_test1(){
        Set<Warehouse> warehouses = warehouseDao.getWarehouseTopNumberOfBook(3);
        warehouses.forEach(System.out::println);
        assertEquals(3,warehouses.size());
    }
}