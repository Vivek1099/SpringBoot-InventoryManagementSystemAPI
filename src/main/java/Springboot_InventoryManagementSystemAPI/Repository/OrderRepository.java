package Springboot_InventoryManagementSystemAPI.Repository;

import Springboot_InventoryManagementSystemAPI.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
