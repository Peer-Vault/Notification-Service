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
            System.out.println("--------------------------");
            Map<String, String> userRegistration = objectMapper.readValue(message, new TypeReference<Map<String, String>>() {});
            String email = userRegistration.get("email");
            String firstName = userRegistration.get("first");
            String lastName = userRegistration.get("last");
            System.out.println("--------------------------");
            emailService.sendRegistrationSuccessEmail(email, firstName, lastName);
            System.out.println("--------------------------");
            System.out.println("Registration email sent to: "  +  email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
