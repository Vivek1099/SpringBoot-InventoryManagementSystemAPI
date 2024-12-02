package Springboot_InventoryManagementSystemAPI.Repository;

import Springboot_InventoryManagementSystemAPI.Entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
