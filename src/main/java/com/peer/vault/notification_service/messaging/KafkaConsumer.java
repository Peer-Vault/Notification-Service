package com.peer.vault.notification_service.messaging;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.peer.vault.notification_service.dto.UserCredential;
import com.peer.vault.notification_service.service.EmailService;
import com.peer.vault.notification_service.utils.KafkaConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class KafkaConsumer {

    @Autowired
    private EmailService emailService;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = KafkaConstants.USER_REGISTRATION, groupId = KafkaConstants.GROUP_EMAIL)
    public void consumerForUserRegistration(String message) {
        try {
            Map<String, String> userRegistration = objectMapper.readValue(message, new TypeReference<Map<String, String>>() {});
            String email = userRegistration.get("email");
            String firstName = userRegistration.get("first");
            String lastName = userRegistration.get("last");
            emailService.sendRegistrationSuccessEmail(email, firstName, lastName);
            System.out.println("Registration email sent to: "  +  email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(topics = KafkaConstants.File_SHARED, groupId = KafkaConstants.GROUP_EMAIL)
    public void consumerForFileSharing(String message) {
        try {
            Map<String, String> fileData = objectMapper.readValue(message, new TypeReference<Map<String, String>>() {});
            String email = fileData.get("email");
            String fileUrl = fileData.get("fileUrl");
            emailService.sendFileSharedEmail(email, fileUrl);
            System.out.println("File email sent to: "  +  email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
