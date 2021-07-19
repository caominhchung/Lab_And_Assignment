package fa.training.dao;

import fa.training.entities.Warehouse;
import fa.training.entities.WarehouseBook;

import java.util.Set;

public interface WarehouseBookDao {
    WarehouseBook insertWarehouseBook(WarehouseBook warehouseBook);


    Set<WarehouseBook> getAllWarehouseBook();

    boolean updateWarehouseBook(WarehouseBook warehouseBook);

    boolean deleteWarehouseBook(WarehouseBook warehouseBook);
}
