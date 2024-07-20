//package com.peer.vault.notification_service.service;
//
//import com.peer.vault.notification_service.constant.KafkaConstant;
//import com.peer.vault.notification_service.dto.FileShareEvent;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class NotificationRegistrationService {
//
//    @KafkaListener(topics = KafkaConstant.USER_REGISTRATION, groupId = KafkaConstant.USER_REGISTRATION_GROUP)
//    public void listen(String event) {
//        System.out.println("User Email: " + event);
//    }
//}
