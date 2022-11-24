package com.librarySystem.Integrations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    @Autowired

    KafkaTemplate<String, BookDTO> kafkaTemplate;
    @Value("updateBook")
    String topic1;

    public void send(BookDTO bookDto){
        kafkaTemplate.send(topic1, bookDto);
    }

}
