package com.cognizant.logitrack.serviceImplementation;

import com.cognizant.logitrack.service.AuditLogService;
import com.cognizant.logitrack.dto.AuditLogDTO;
import com.cognizant.logitrack.entity.AuditLog;
import com.cognizant.logitrack.repository.AuditLogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuditLogServiceImpl implements AuditLogService {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AuditLogServiceImpl.class);
    private final AuditLogRepository auditLogRepository;

    public AuditLogServiceImpl(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    @Override
    public AuditLogDTO logAction(Integer userId, String action, String entityType, Integer entityId) {
        AuditLog auditLog = AuditLog.builder().userId(userId).action(action).entityType(entityType).entityId(entityId).build();
        AuditLog saved = auditLogRepository.save(auditLog);
        log.debug("Audit log recorded: userId={}, action={}, entityType={}", userId, action, entityType);
        return toDTO(saved);
    }

    @Override
    public Page<AuditLogDTO> getAllLogs(Pageable pageable) {
        return auditLogRepository.findAll(pageable).map(this::toDTO);
    }

    @Override
    public List<AuditLogDTO> getByUserId(Integer userId) {
        return auditLogRepository.findByUserId(userId).stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<AuditLogDTO> getByAction(String action) {
        return auditLogRepository.findByAction(action).stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<AuditLogDTO> getByDateRange(LocalDateTime from, LocalDateTime to) {
        return auditLogRepository.findByTimestampBetween(from, to).stream().map(this::toDTO).collect(Collectors.toList());
    }

    private AuditLogDTO toDTO(AuditLog log) {
        return AuditLogDTO.builder().auditId(log.getAuditId()).userId(log.getUserId()).action(log.getAction()).entityType(log.getEntityType()).entityId(log.getEntityId()).timestamp(log.getTimestamp()).build();
    }
}
