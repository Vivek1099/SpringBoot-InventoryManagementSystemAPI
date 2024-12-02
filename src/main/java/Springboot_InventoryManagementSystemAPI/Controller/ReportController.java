package Springboot_InventoryManagementSystemAPI.Controller;

import Springboot_InventoryManagementSystemAPI.Entity.Orders;
import Springboot_InventoryManagementSystemAPI.Entity.Product;
import Springboot_InventoryManagementSystemAPI.Entity.Supplier;
import Springboot_InventoryManagementSystemAPI.Service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/inventory")
    public ResponseEntity<List<Product>> getInventoryReport() {
        return ResponseEntity.ok(reportService.getInventoryReport());
    }

    @GetMapping("/sales")
    public ResponseEntity<List<Orders>> getSalesReport() {
        return ResponseEntity.ok(reportService.getSalesReport());
    }

    @GetMapping("/suppliers")
    public ResponseEntity<List<Supplier>> getSupplierReport() {
        return ResponseEntity.ok(reportService.getSupplierReport());
    }
}
