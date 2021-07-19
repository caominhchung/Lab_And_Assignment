package fa.training.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Warehouse", schema = "dbo")
public class Warehouse {
    @Id
    @Column(name = "warehouse_code")
    private Integer code;
    @Column(name = "warehouse_phone")
    private String phone;
    @Column(name = "warehouse_address")
    private String address;
    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
    private Set<WarehouseBook> warehouseBooks;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Warehouse)) return false;
        Warehouse warehouse = (Warehouse) o;
        return Objects.equals(code, warehouse.code) && Objects.equals(phone, warehouse.phone) && Objects.equals(address, warehouse.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, phone, address);
    }

    public Warehouse(Integer code, String phone, String address) {
        this.code = code;
        this.phone = phone;
        this.address = address;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<WarehouseBook> getWarehouseBooks() {
        return warehouseBooks;
    }

    public void setWarehouseBooks(Set<WarehouseBook> warehouseBooks) {
        this.warehouseBooks = warehouseBooks;
    }

    public Warehouse() {
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Warehouse{");
        sb.append("code=").append(code);
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
