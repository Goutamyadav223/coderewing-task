package org.example.service.serviceimpl;

import org.example.dto.InventoryResponseDto;
import org.example.entity.Inventory;
import org.example.exception.ItemNotFoundException;
import org.example.repository.InventoryRepository;
import org.example.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public void addInventory(Inventory inventory) {
        inventoryRepository.save(inventory);
    }

    @Override
    public ResponseEntity<List<InventoryResponseDto>> getAllInventory() {
        List<Inventory> inventoryList = inventoryRepository.findAll();

        List<InventoryResponseDto> inventoryResponseDtoList = new ArrayList<>();

        for(Inventory inventory : inventoryList){

            InventoryResponseDto inventoryResponseDto = new InventoryResponseDto();
            inventoryResponseDto.setId(inventory.getId());
            inventoryResponseDto.setItemName(inventory.getItemName());
            inventoryResponseDto.setItemQuantity(inventory.getItemQuantity());
            inventoryResponseDtoList.add(inventoryResponseDto);
        }
        return ResponseEntity.ok(inventoryResponseDtoList);
    }

    @Override
    public void updateItemQuantity(Inventory inventory) {
        inventoryRepository.findById(inventory.getId()).orElseThrow( ()-> new ItemNotFoundException("Item not found"));
        inventoryRepository.save(inventory);
    }

    @Override
    public void deleteItem(Inventory inventory) {
        inventoryRepository.findById(inventory.getId()).orElseThrow( ()-> new ItemNotFoundException("Item not found"));
        inventoryRepository.deleteById(inventory.getId());
    }

}
