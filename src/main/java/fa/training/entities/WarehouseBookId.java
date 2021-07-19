package fa.training.entities;

import java.io.Serializable;
import java.util.Objects;

public class WarehouseBookId implements Serializable {
    private Integer warehouse;
    private String book;

    public WarehouseBookId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WarehouseBookId)) return false;
        WarehouseBookId that = (WarehouseBookId) o;
        return Objects.equals(warehouse, that.warehouse) && Objects.equals(book, that.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(warehouse, book);
    }

    public Integer getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Integer warehouse) {
        this.warehouse = warehouse;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public WarehouseBookId(Integer warehouse, String book) {
        this.warehouse = warehouse;
        this.book = book;
    }
}
