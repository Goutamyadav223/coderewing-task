package org.example.controller;

import org.example.dto.InventoryResponseDto;
import org.example.entity.Inventory;
import org.example.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {


    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/add-item")
    public ResponseEntity<?> addInventory(@RequestBody Inventory inventory){
        inventoryService.addInventory(inventory);
        return ResponseEntity.status(HttpStatus.CREATED).body(inventory);
    }

    @GetMapping("/getAll-item")
    public ResponseEntity<List<InventoryResponseDto>> getAllInventory(){
        return inventoryService.getAllInventory();
    }

    @PutMapping("/update-item-quantity")
    public ResponseEntity<String> updateItemQuantity(@RequestBody Inventory inventory){
         inventoryService.updateItemQuantity(inventory); //need to give id also
        return ResponseEntity.status(HttpStatus.OK).body("Item updated successfully");
    }

    @DeleteMapping("/detele-item")
    public ResponseEntity<String> deleteInventory(@RequestBody Inventory inventory){
        inventoryService.deleteItem(inventory);
        return ResponseEntity.status(HttpStatus.OK).body("Item deleted successfully");
    }

}
