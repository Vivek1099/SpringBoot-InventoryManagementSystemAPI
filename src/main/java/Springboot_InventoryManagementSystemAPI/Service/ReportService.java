package Springboot_InventoryManagementSystemAPI.Service;

import Springboot_InventoryManagementSystemAPI.Entity.Orders;
import Springboot_InventoryManagementSystemAPI.Entity.Product;
import Springboot_InventoryManagementSystemAPI.Entity.Supplier;
import Springboot_InventoryManagementSystemAPI.Repository.OrderRepository;
import Springboot_InventoryManagementSystemAPI.Repository.ProductRepository;
import Springboot_InventoryManagementSystemAPI.Repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService
{
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final SupplierRepository supplierRepository;

    public ReportService(ProductRepository productRepository, OrderRepository orderRepository, SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.supplierRepository = supplierRepository;
    }

    public List<Product> getInventoryReport() {
        return productRepository.findAll();
    }

    public List<Orders> getSalesReport() {
        return orderRepository.findAll().stream()
                .filter(order -> order.getType() == Orders.OrderType.OUTGOING)
                .collect(Collectors.toList());
    }

    public List<Supplier> getSupplierReport() {
        return supplierRepository.findAll();
    }
}
