package Springboot_InventoryManagementSystemAPI.Repository;

import Springboot_InventoryManagementSystemAPI.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
