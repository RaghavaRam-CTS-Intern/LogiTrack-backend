package com.cognizant.logitrack.service;

import com.cognizant.logitrack.exception.BadRequestException;
import com.cognizant.logitrack.exception.ResourceNotFoundException;
import com.cognizant.logitrack.dto.InventoryDTO;
import com.cognizant.logitrack.entity.WarehouseInventory;
import com.cognizant.logitrack.repository.WarehouseInventoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(InventoryService.class);
    private final WarehouseInventoryRepository inventoryRepository;

    public InventoryService(WarehouseInventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<InventoryDTO> getInventoryByWarehouse(Integer warehouseId) {
        return inventoryRepository.findByWarehouseId(warehouseId).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public InventoryDTO getById(Integer id) {
        return toDTO(findEntity(id));
    }

    public InventoryDTO updateQuantity(Integer id, Integer quantity) {
        WarehouseInventory inv = findEntity(id);
        inv.setQuantityOnHand(quantity);
        return toDTO(inventoryRepository.save(inv));
    }

    public InventoryDTO reserveStock(Integer id, Integer quantity) {
        WarehouseInventory inv = findEntity(id);
        if (inv.getQuantityOnHand() == null || inv.getQuantityOnHand() < quantity) {
            throw new BadRequestException("Insufficient stock");
        }
        inv.setQuantityOnHand(inv.getQuantityOnHand() - quantity);
        inv.setQuantityReserved((inv.getQuantityReserved() == null ? 0 : inv.getQuantityReserved()) + quantity);
        log.info("Reserved {} units of inventory {}", quantity, id);
        return toDTO(inventoryRepository.save(inv));
    }

    public InventoryDTO releaseStock(Integer id, Integer quantity) {
        WarehouseInventory inv = findEntity(id);
        inv.setQuantityReserved((inv.getQuantityReserved() == null ? 0 : inv.getQuantityReserved()) - quantity);
        inv.setQuantityOnHand((inv.getQuantityOnHand() == null ? 0 : inv.getQuantityOnHand()) + quantity);
        log.info("Released {} units of inventory {}", quantity, id);
        return toDTO(inventoryRepository.save(inv));
    }

    private WarehouseInventory findEntity(Integer id) {
        return inventoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Inventory not found with id: " + id));
    }

    private InventoryDTO toDTO(WarehouseInventory inv) {
        return InventoryDTO.builder().inventoryId(inv.getInventoryId()).sku(inv.getSku()).productName(inv.getProductName()).warehouseId(inv.getWarehouseId()).binLocation(inv.getBinLocation()).quantityOnHand(inv.getQuantityOnHand()).quantityReserved(inv.getQuantityReserved()).lastUpdated(inv.getLastUpdated()).build();
    }
}
