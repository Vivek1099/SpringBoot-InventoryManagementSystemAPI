package Springboot_InventoryManagementSystemAPI.Service;

import Springboot_InventoryManagementSystemAPI.Entity.Supplier;
import Springboot_InventoryManagementSystemAPI.Exception.ResourceNotFoundException;
import Springboot_InventoryManagementSystemAPI.Repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService
{
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    public Supplier findById(Long id) {
        return supplierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));
    }

    public Supplier update(Long id, Supplier updatedSupplier) {
        Supplier existingSupplier = findById(id);
        existingSupplier.setName(updatedSupplier.getName());
        existingSupplier.setContactDetails(updatedSupplier.getContactDetails());
        return supplierRepository.save(existingSupplier);
    }

    public void delete(Long id) {
        supplierRepository.deleteById(id);
    }
}
