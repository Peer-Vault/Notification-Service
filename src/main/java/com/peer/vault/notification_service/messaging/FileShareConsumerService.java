//package com.peer.vault.notification_service.messaging;
//
//import com.peer.vault.notification_service.constant.KafkaConstant;
//import com.peer.vault.notification_service.dto.FileShareEvent;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class FileShareConsumerService {
//
//    @KafkaListener(topics = KafkaConstant.TOPIC_FILE_SHARED, groupId = "file-share-group")
//    public void consumeFileShareEvent(FileShareEvent event) {
//        // Process the event
//        System.out.println("Consumed event: " + event);
//    }
//}