package fa.training.entities;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Book",schema = "dbo")
public class Book {

    @Id
    @Column(name = "book_idbn",length = 255)
    private String isbn;
    @Column(name = "book_year")
    private Integer year;
    @Column(name = "book_title",length = 255)
    private String title;
    @Column(name = "book_price")
    private Double price;
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private Set<WarehouseBook> warehouseBooks;
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<WarehouseBook> getWarehouseBooks() {
        return warehouseBooks;
    }

    public void setWarehouseBooks(Set<WarehouseBook> warehouseBooks) {
        this.warehouseBooks = warehouseBooks;
    }

    public Book() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn) && Objects.equals(year, book.year) && Objects.equals(title, book.title) && Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, year, title, price);
    }

    public Book(String isbn, Integer year, String title, Double price) {
        this.isbn = isbn;
        this.year = year;
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Book{");
        sb.append("isbn='").append(isbn).append('\'');
        sb.append(", year=").append(year);
        sb.append(", title='").append(title).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
