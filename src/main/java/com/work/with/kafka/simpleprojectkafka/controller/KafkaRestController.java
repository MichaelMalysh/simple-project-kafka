package com.work.with.kafka.simpleprojectkafka.controller;

import com.work.with.kafka.simpleprojectkafka.model.SimpleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Misha Malysh
 */
@RestController
@RequestMapping("/api/kafka/")
public class KafkaRestController {

    private KafkaTemplate<String, SimpleModel> kafkaTemplate;

    @Autowired
    public KafkaRestController(KafkaTemplate<String, SimpleModel> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void post(@RequestBody SimpleModel simpleModel){
        kafkaTemplate.send("myTopic", simpleModel);
    }

    @KafkaListener(topics = "myTopic")
    public void consumeMessage(String message){
        System.out.println("Sended message from request: " + message);
    }
}
