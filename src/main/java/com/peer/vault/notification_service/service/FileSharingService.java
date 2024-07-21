package com.peer.vault.notification_service.service;

import com.peer.vault.notification_service.dto.FileShareEvent;
import com.peer.vault.notification_service.constant.KafkaConstant;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class FileSharingService {

    @KafkaListener(topics = KafkaConstant.FILE_SHARED_TOPIC, groupId = KafkaConstant.FILE_SHARE_GROUP)
    public void listen(FileShareEvent event) {
        System.out.println("Received File URL: " + event.getFileUrl());
        System.out.println("Recipient Email: " + event.getEmail());
    }
}

