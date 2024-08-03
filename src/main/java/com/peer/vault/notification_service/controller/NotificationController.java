package com.peer.vault.notification_service.controller;

import com.peer.vault.notification_service.dto.EmailRequest;
import com.peer.vault.notification_service.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/sendEmail")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
        notificationService.sendEmail(emailRequest);
        return ResponseEntity.ok("Email sent successfully");
    }

}