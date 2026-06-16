package com.cognizant.logitrack.serviceImplementation;

import com.cognizant.logitrack.service.NotificationService;
import com.cognizant.logitrack.exception.ResourceNotFoundException;
import com.cognizant.logitrack.dto.NotificationDTO;
import com.cognizant.logitrack.dto.NotificationRequestDTO;
import com.cognizant.logitrack.entity.Notification;
import com.cognizant.logitrack.enums.NotificationStatus;
import com.cognizant.logitrack.repository.NotificationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NotificationServiceImpl.class);
    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public NotificationDTO sendNotification(NotificationRequestDTO dto) {
        Notification notification = Notification.builder().userId(dto.getUserId()).message(dto.getMessage()).category(dto.getCategory()).status(NotificationStatus.UNREAD).build();
        Notification saved = notificationRepository.save(notification);
        log.info("Notification sent to user {}: {}", dto.getUserId(), dto.getCategory());
        return toDTO(saved);
    }

    @Override
    public List<NotificationDTO> getByUser(Integer userId) {
        return notificationRepository.findByUserId(userId).stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<NotificationDTO> getUnreadByUser(Integer userId) {
        return notificationRepository.findByUserIdAndStatus(userId, NotificationStatus.UNREAD).stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public NotificationDTO markAsRead(Integer id) {
        Notification notification = notificationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Notification not found with id: " + id));
        notification.setStatus(NotificationStatus.READ);
        return toDTO(notificationRepository.save(notification));
    }

    @Override
    @Transactional
    public void markAllAsRead(Integer userId) {
        List<Notification> unread = notificationRepository.findByUserIdAndStatus(userId, NotificationStatus.UNREAD);
        for (Notification n : unread) {
            n.setStatus(NotificationStatus.READ);
        }
        notificationRepository.saveAll(unread);
        log.info("Marked {} notifications as read for user {}", unread.size(), userId);
    }

    @Override
    public long getUnreadCount(Integer userId) {
        return notificationRepository.countByUserIdAndStatus(userId, NotificationStatus.UNREAD);
    }

    private NotificationDTO toDTO(Notification n) {
        return NotificationDTO.builder().notificationId(n.getNotificationId()).userId(n.getUserId()).message(n.getMessage()).category(n.getCategory()).status(n.getStatus()).createdDate(n.getCreatedDate()).build();
    }
}
