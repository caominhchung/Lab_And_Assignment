package fa.training.dao;

import fa.training.entities.Warehouse;

import java.util.Set;

public interface WarehouseDao {
    Warehouse insertWarehouse(Warehouse warehouse) throws IllegalArgumentException;

    Warehouse getWarehouseByCode(Integer code);

    Set<Warehouse> getAllWarehouse();

    boolean updateWarehouse(Warehouse warehouse) throws IllegalArgumentException;

    boolean deleteWarehouseByCode(Integer code);

    Set<Warehouse> getWarehouseTopNumberOfBook(int top);
}
