//package com.peer.vault.notification_service.messaging;
//
//import com.peer.vault.notification_service.constant.KafkaConstant;
//import com.peer.vault.notification_service.dto.FileShareEvent;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
//import org.springframework.kafka.support.serializer.JsonDeserializer;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//@EnableKafka
//public class NotificationRegistrationConsumerConfig {
//
//    @Bean
//    public ConsumerFactory<String, String> notificationRegistrationConsumerFactory() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstant.SERVER_HOST);
//        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConstant.FILE_SHARE_GROUP);
//        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//
//        return new DefaultKafkaConsumerFactory<>(configProps,
//                new ErrorHandlingDeserializer<>(new StringDeserializer()),
//                new ErrorHandlingDeserializer<>(new StringDeserializer()));
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, String> notificationKafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(notificationRegistrationConsumerFactory());
//        return factory;
//    }
//}
