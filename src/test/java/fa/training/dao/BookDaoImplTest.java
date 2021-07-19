package fa.training.dao;

import fa.training.entities.Book;
import fa.training.entities.Warehouse;
import fa.training.entities.WarehouseBook;
import fa.training.utils.HibernateUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookDaoImplTest {
    static BookDao bookDao;
    static WarehouseDao warehouseDao;
    static  WarehouseBookDao warehouseBookDao;
    @BeforeAll
    public static void setUpClass(){
        bookDao = new BookDaoImpl(HibernateUtil.getSessionFactory());
        warehouseBookDao = new WarehouseBookDaoImpl(HibernateUtil.getSessionFactory());
        warehouseDao = new WarehouseDaoImpl(HibernateUtil.getSessionFactory());
        Book book1 = new Book("BOOK200",2011,"Name Book 201",123123.0);
        Book book2 = new Book("BOOK201",2011,"Name Book 21",123123.0);
        Book book3 = new Book("BOOK202",2011,"Name Book 21",123123.0);
        Book book4 = new Book("BOOK203",2011,"Name Book 21",123123.0);
        Book book5 = new Book("BOOK204",2011,"Name Book 21",123123.0);
        Book book6 = new Book("BOOK205",2011,"Name Book 21",123123.0);
        Book book7 = new Book("BOOK206",2011,"Name Book 21",123123.0);
        Book book8 = new Book("BOOK207",2011,"Name Book 21",123123.0);
        Book book9 = new Book("BOOK208",2011,"Name Book 21",123123.0);
        bookDao.insertBook(book1);
        bookDao.insertBook(book2);
        bookDao.insertBook(book3);
        bookDao.insertBook(book4);
        bookDao.insertBook(book5);
        bookDao.insertBook(book6);
        bookDao.insertBook(book7);
        bookDao.insertBook(book8);
        bookDao.insertBook(book9);
        Warehouse warehouse1 = new Warehouse(200,"0999999999","Street 1");
        Warehouse warehouse2 = new Warehouse(210,"0999999998","Street 2");
        Warehouse warehouse3 = new Warehouse(230,"0999999997","Street 3");
        Warehouse warehouse4 = new Warehouse(240,"0999999996","Street 4");
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
    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Order(1)
    void insertBook_test1_nomal() {
        Book book = new Book("BOOK1",1999,"Name Book 1",123213.0);
        Book book2 =bookDao.insertBook(book);
        assertEquals(book,book2);
    }

    @Test
    @Order(2)
    void insertBook_test2_nomal() {
        Book book = new Book("BOOK2",1968,"Name Book 1",123213.0);
        Book book2 = bookDao.insertBook(book);
        assertEquals(book,book2);
    }

    @Test
    @Order(3)
    void insertBook_test3_book_null() {
        Book book = null;
        assertNull(bookDao.insertBook(book));
    }

    @Test
    @Order(4)
    void insertBook_test4_invalid_year_exception() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
                 Book book = new Book("BOOK3",1900,"Name Book 1",123213.0);
            bookDao.insertBook(book);
        });
    }

    @Test
    @Order(5)
    void insertBook_test5_invalid_year_exception() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Book book = new Book("BOOK4",2030,"Name Book 1",123213.0);
            bookDao.insertBook(book);
        });
    }

    @Test
    @Order(6)
    void getBookByISBN_test1_nomal() {
        Book book = new Book("BOOK5",1999,"Name Book 1",123213.0);
        bookDao.insertBook(book);

        Book book1 = bookDao.getBookByISBN("BOOK5");
        assertEquals(book,book1);
    }

    @Test
    @Order(7)
    void getBookByISBN_test2_nomal() {
        Book book = new Book("BOOK6",1999,"Name Book 1",123213.0);
        bookDao.insertBook(book);

        Book book1 = bookDao.getBookByISBN("BOOK6");
        assertEquals(book,book1);
    }

    @Test
    @Order(8)
    void getBookByISBN_test3_book_notvalid() {

        Book book1 = bookDao.getBookByISBN("BOOKkk6");
        assertEquals(null,book1);
    }
    @Test
    @Order(9)
    void getAllBook_test1_nomal() {
        Set<Book> bookSet = bookDao.getAllBook();
        assertEquals(11, bookSet.size());
    }

    @Test
    @Order(10)
    void getAllBook_test2_nomal() {
        Book book = new Book("BOOK9",1999,"Name Book 1",123213.0);
        bookDao.insertBook(book);

        Set<Book> bookSet = bookDao.getAllBook();
        assertEquals(14, bookSet.size());
    }

    @Test
    @Order(11)
    void updateBook_test1_nomal() {
        Book book = new Book("BOOK10",1999,"Name Book 1",123213.0);
        bookDao.insertBook(book);

        Book book2 = new Book("BOOK10",2011,"Name Book 2",123213.0);
        assertTrue(bookDao.updateBook(book2));
        assertEquals(book2,bookDao.getBookByISBN("BOOK10"));
    }

    @Test
    @Order(12)
    void updateBook_test2_nomal() {
        Book book = new Book("BOOK11",1999,"Name Book 1",123213.0);
        bookDao.insertBook(book);

        Book book2 = new Book("BOOK11",2011,"Name Book 3342",123213.0);
        assertTrue(bookDao.updateBook(book2));
        assertEquals(book2,bookDao.getBookByISBN("BOOK11"));
    }

    @Test
    @Order(13)
    void updateBook_test3_exception() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Book book = new Book("BOOK12",1999,"Name Book 1",123213.0);
            bookDao.insertBook(book);

            Book book2 = new Book("BOOK11",1800,"Name Book 3342",123213.0);
            bookDao.updateBook(book2);
        });
    }

    @Test
    @Order(14)
    void deleteBookById_test1() {
        Book book = new Book("BOOK13",1999,"Name Book 1",123213.0);
        bookDao.insertBook(book);

        assertTrue(bookDao.deleteBookById("BOOK13"));
    }
    @Test
    @Order(15)
    void deleteBookById_test2() {
        Book book = new Book("BOOK14",1999,"Name Book 1",123213.0);
        bookDao.insertBook(book);

        assertTrue(bookDao.deleteBookById("BOOK14"));
    }
    @Test
    @Order(16)
    void getBookTopNumberInWarehouse(){


        Set<Book>  books = bookDao.getBookTopNumberInWarehouse(3);
        assertEquals(3,books.size());

    }
    @Test
    @Order(17)
    void getBookNotAvailable(){
        Set<Book> books = bookDao.getBookNotAvailable();
        assertEquals(3,books.size());
    }
}