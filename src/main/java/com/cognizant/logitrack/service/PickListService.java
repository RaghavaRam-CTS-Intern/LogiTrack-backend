package com.cognizant.logitrack.service;

import com.cognizant.logitrack.exception.ResourceNotFoundException;
import com.cognizant.logitrack.dto.PickListDTO;
import com.cognizant.logitrack.dto.PickListRequestDTO;
import com.cognizant.logitrack.entity.PickList;
import com.cognizant.logitrack.enums.PickListStatus;
import com.cognizant.logitrack.repository.PickListRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PickListService {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PickListService.class);
    private final PickListRepository pickListRepository;

    public PickListService(PickListRepository pickListRepository) {
        this.pickListRepository = pickListRepository;
    }

    public PickListDTO createPickList(PickListRequestDTO dto) {
        PickList pickList = PickList.builder().freightOrderId(dto.getFreightOrderId()).warehouseId(dto.getWarehouseId()).assignedTo(dto.getAssignedTo()).status(PickListStatus.OPEN).build();
        PickList saved = pickListRepository.save(pickList);
        log.info("Pick list created: id={}", saved.getPickListId());
        return toDTO(saved);
    }

    public PickListDTO assignPickList(Integer id, Integer assignedTo) {
        PickList pickList = findEntity(id);
        pickList.setAssignedTo(assignedTo);
        pickList.setStatus(PickListStatus.INPROGRESS);
        log.info("Pick list {} assigned to {}", id, assignedTo);
        return toDTO(pickListRepository.save(pickList));
    }

    public PickListDTO updatePickListStatus(Integer id, PickListStatus status) {
        PickList pickList = findEntity(id);
        pickList.setStatus(status);
        return toDTO(pickListRepository.save(pickList));
    }

    public List<PickListDTO> getByWarehouse(Integer warehouseId) {
        return pickListRepository.findByWarehouseId(warehouseId).stream().map(this::toDTO).collect(Collectors.toList());
    }

    private PickList findEntity(Integer id) {
        return pickListRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pick list not found with id: " + id));
    }

    private PickListDTO toDTO(PickList p) {
        return PickListDTO.builder().pickListId(p.getPickListId()).freightOrderId(p.getFreightOrderId()).warehouseId(p.getWarehouseId()).assignedTo(p.getAssignedTo()).status(p.getStatus()).createdDate(p.getCreatedDate()).build();
    }
}
