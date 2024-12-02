package Springboot_InventoryManagementSystemAPI.Service;

import Springboot_InventoryManagementSystemAPI.Entity.Orders;
import Springboot_InventoryManagementSystemAPI.Entity.OrderType;
import Springboot_InventoryManagementSystemAPI.Entity.Product;
import Springboot_InventoryManagementSystemAPI.Exception.BusinessException;
import Springboot_InventoryManagementSystemAPI.Exception.ResourceNotFoundException;
import Springboot_InventoryManagementSystemAPI.Repository.OrderRepository;
import Springboot_InventoryManagementSystemAPI.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService
{
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Orders saveOrder(Orders orders) {
        Product product = productRepository.findById(orders.getProduct().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        if (orders.getType() == OrderType.OUTGOING && product.getQuantity() < orders.getQuantity()) {
            throw new BusinessException("Insufficient stock for the product");
        }

        if (orders.getType() == OrderType.OUTGOING) {
            product.setQuantity(product.getQuantity() - orders.getQuantity());
        } else {
            product.setQuantity(product.getQuantity() + orders.getQuantity());
        }

        productRepository.save(product);
        orders.setOrderDate(LocalDateTime.now());
        return orderRepository.save(orders);
    }

    public List<Orders> findAll() {
        return orderRepository.findAll();
    }
}
