package org.example.service;

import org.example.dto.InventoryResponseDto;
import org.example.entity.Inventory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventoryService {

    void addInventory(Inventory inventory);

    ResponseEntity<List<InventoryResponseDto>> getAllInventory();

    void updateItemQuantity(Inventory inventory);

    void deleteItem(Inventory inventory);
}
