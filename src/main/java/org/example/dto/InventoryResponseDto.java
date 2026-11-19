package org.example.dto;


public class InventoryResponseDto {

    private Long id;

    private String itemName;

    private Long itemQuantity;

    public InventoryResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public Long getItemQuantity() {
        return itemQuantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemQuantity(Long itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
}
