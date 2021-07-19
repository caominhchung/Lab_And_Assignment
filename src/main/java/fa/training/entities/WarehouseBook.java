package fa.training.entities;

import javax.persistence.*;

@Entity
@Table(name = "Warehouse_Book",schema = "dbo")
@IdClass(WarehouseBookId.class)
public class WarehouseBook {
    @Id
    @ManyToOne
    @JoinColumn(name = "book_isbn",nullable = false)
    private Book book;
    @Id
    @ManyToOne
    @JoinColumn(name = "warehouse_code",nullable = false)
    private Warehouse warehouse;

    private Integer count;

    public WarehouseBook() {
    }

    public WarehouseBook(Book book, Warehouse warehouse, Integer count) {
        this.book = book;
        this.warehouse = warehouse;
        this.count = count;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
