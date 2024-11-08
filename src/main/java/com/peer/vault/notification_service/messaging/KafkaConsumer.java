package com.peer.vault.notification_service.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peer.vault.notification_service.dto.UserCredential;
import com.peer.vault.notification_service.service.EmailService;
import com.peer.vault.notification_service.utils.KafkaConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaConsumer {

    @Autowired
    private EmailService emailService;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = KafkaConstants.USER_REGISTRATION, groupId = KafkaConstants.GROUP_EMAIL)
    public void consumerForUserRegistration(String message) {
        try {
            UserCredential credential = objectMapper.readValue(message, UserCredential.class);
            emailService.sendRegistrationSuccessEmail(credential);
            System.out.println("Registration email sent to: "  +  credential.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
