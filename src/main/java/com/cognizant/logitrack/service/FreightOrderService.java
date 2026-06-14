package com.cognizant.logitrack.service;

import com.cognizant.logitrack.exception.BadRequestException;
import com.cognizant.logitrack.exception.ResourceNotFoundException;
import com.cognizant.logitrack.dto.FreightOrderDTO;
import com.cognizant.logitrack.dto.FreightOrderRequestDTO;
import com.cognizant.logitrack.entity.FreightOrder;
import com.cognizant.logitrack.enums.FreightOrderStatus;
import com.cognizant.logitrack.repository.FreightOrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FreightOrderService {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(FreightOrderService.class);
    private final FreightOrderRepository freightOrderRepository;

    public FreightOrderService(FreightOrderRepository freightOrderRepository) {
        this.freightOrderRepository = freightOrderRepository;
    }

    public FreightOrderDTO createFreightOrder(FreightOrderRequestDTO dto) {
        FreightOrder order = FreightOrder.builder().shipperId(dto.getShipperId()).originLocationId(dto.getOriginLocationId()).destinationLocationId(dto.getDestinationLocationId()).cargoDescription(dto.getCargoDescription()).weight(dto.getWeight()).volume(dto.getVolume()).requiredDeliveryDate(dto.getRequiredDeliveryDate()).status(FreightOrderStatus.DRAFT).build();
        FreightOrder saved = freightOrderRepository.save(order);
        log.info("Freight order created: id={}", saved.getFreightOrderId());
        return toDTO(saved);
    }

    public FreightOrderDTO getById(Integer id) {
        return toDTO(findEntity(id));
    }

    public List<FreightOrderDTO> getAllOrders() {
        return freightOrderRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<FreightOrderDTO> getByShipper(Integer shipperId) {
        return freightOrderRepository.findByShipperId(shipperId).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public FreightOrderDTO updateStatus(Integer id, FreightOrderStatus status) {
        FreightOrder order = findEntity(id);
        order.setStatus(status);
        FreightOrder saved = freightOrderRepository.save(order);
        log.info("Freight order {} status updated to {}", id, status);
        return toDTO(saved);
    }

    public FreightOrderDTO cancelOrder(Integer id) {
        FreightOrder order = findEntity(id);
        if (order.getStatus() == FreightOrderStatus.DELIVERED) {
            throw new BadRequestException("Cannot cancel a delivered order");
        }
        order.setStatus(FreightOrderStatus.CANCELLED);
        FreightOrder saved = freightOrderRepository.save(order);
        log.info("Freight order {} cancelled", id);
        return toDTO(saved);
    }

    private FreightOrder findEntity(Integer id) {
        return freightOrderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Freight order not found with id: " + id));
    }

    private FreightOrderDTO toDTO(FreightOrder order) {
        return FreightOrderDTO.builder().freightOrderId(order.getFreightOrderId()).shipperId(order.getShipperId()).originLocationId(order.getOriginLocationId()).destinationLocationId(order.getDestinationLocationId()).cargoDescription(order.getCargoDescription()).weight(order.getWeight()).volume(order.getVolume()).requiredDeliveryDate(order.getRequiredDeliveryDate()).status(order.getStatus()).build();
    }
}
