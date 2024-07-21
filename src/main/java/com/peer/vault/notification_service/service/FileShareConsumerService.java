//package com.peer.vault.notification_service.service;
//
//import com.peer.vault.notification_service.constant.KafkaConstant;
//import com.peer.vault.notification_service.dto.FileShareEvent;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class FileShareConsumerService {
//
//    @KafkaListener(
//            topics = KafkaConstant.FILE_SHARED_TOPIC,
//            groupId = KafkaConstant.FILE_SHARE_GROUP,
//            containerFactory = "kafkaListenerContainerFactory"
//    )
//    public void consumeFileShareEvent(FileShareEvent event) {
//        System.out.println("Consumed event: " + event);
//    }
//}