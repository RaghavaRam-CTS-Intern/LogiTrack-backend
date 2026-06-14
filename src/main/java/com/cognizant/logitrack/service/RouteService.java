package com.cognizant.logitrack.service;

import com.cognizant.logitrack.exception.ResourceNotFoundException;
import com.cognizant.logitrack.dto.RouteDTO;
import com.cognizant.logitrack.dto.RouteRequestDTO;
import com.cognizant.logitrack.entity.Route;
import com.cognizant.logitrack.enums.RouteMode;
import com.cognizant.logitrack.enums.RouteStatus;
import com.cognizant.logitrack.repository.RouteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteService {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(RouteService.class);
    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public RouteDTO addRoute(RouteRequestDTO dto) {
        Route route = Route.builder().originHubId(dto.getOriginHubId()).destinationHubId(dto.getDestinationHubId()).transitDays(dto.getTransitDays()).mode(dto.getMode()).status(RouteStatus.ACTIVE).build();
        Route saved = routeRepository.save(route);
        log.info("Route added: id={}", saved.getRouteId());
        return toDTO(saved);
    }

    public List<RouteDTO> getAllRoutes() {
        return routeRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<RouteDTO> getByMode(RouteMode mode) {
        return routeRepository.findByMode(mode).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public RouteDTO getById(Integer id) {
        return toDTO(findEntity(id));
    }

    public RouteDTO updateRouteStatus(Integer id, RouteStatus status) {
        Route route = findEntity(id);
        route.setStatus(status);
        return toDTO(routeRepository.save(route));
    }

    public void deleteRoute(Integer id) {
        Route route = findEntity(id);
        route.setStatus(RouteStatus.INACTIVE);
        routeRepository.save(route);
        log.info("Route soft-deleted: id={}", id);
    }

    private Route findEntity(Integer id) {
        return routeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Route not found with id: " + id));
    }

    private RouteDTO toDTO(Route route) {
        return RouteDTO.builder().routeId(route.getRouteId()).originHubId(route.getOriginHubId()).destinationHubId(route.getDestinationHubId()).transitDays(route.getTransitDays()).mode(route.getMode()).status(route.getStatus()).build();
    }
}
