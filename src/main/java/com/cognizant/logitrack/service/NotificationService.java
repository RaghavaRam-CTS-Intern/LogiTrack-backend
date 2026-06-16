package com.cognizant.logitrack.service;

import com.cognizant.logitrack.dto.NotificationDTO;
import com.cognizant.logitrack.dto.NotificationRequestDTO;
import java.util.List;

public interface NotificationService {
    NotificationDTO sendNotification(NotificationRequestDTO dto);
    List<NotificationDTO> getByUser(Integer userId);
    List<NotificationDTO> getUnreadByUser(Integer userId);
    NotificationDTO markAsRead(Integer id);
    void markAllAsRead(Integer userId);
    long getUnreadCount(Integer userId);
}
