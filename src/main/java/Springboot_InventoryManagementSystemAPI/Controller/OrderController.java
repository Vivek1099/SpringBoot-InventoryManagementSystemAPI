package Springboot_InventoryManagementSystemAPI.Controller;

import Springboot_InventoryManagementSystemAPI.Entity.Orders;
import Springboot_InventoryManagementSystemAPI.Service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Orders> create(@Valid @RequestBody Orders order) {
        return ResponseEntity.ok(orderService.saveOrder(order));
    }

    @GetMapping
    public ResponseEntity<List<Orders>> getAll() {
        return ResponseEntity.ok(orderService.findAll());
    }
}
