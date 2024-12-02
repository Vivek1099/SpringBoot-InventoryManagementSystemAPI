package Springboot_InventoryManagementSystemAPI.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name cannot be blank")
    private String name;

    private String description;

    @Positive(message = "Quantity must be a positive number")
    private int quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public @NotBlank(message = "Product name cannot be blank") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Product name cannot be blank") String name) {
        this.name = name;
    }

    @Positive(message = "Quantity must be a positive number")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(@Positive(message = "Quantity must be a positive number") int quantity) {
        this.quantity = quantity;
    }
}
