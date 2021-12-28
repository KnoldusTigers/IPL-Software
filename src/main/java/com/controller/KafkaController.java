package com.controller;


import com.dao.MatchRepo;
import com.model.MatchModel;
import com.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafkaapp")
public class KafkaController {

    @Autowired
    ProducerService producer;
//    @Autowired
//    MatchRepo matchRepo;




    @PostMapping(value = "/postItem")
    public String postJsonMessage(@RequestBody MatchModel item) {
      producer.publishToTopic(item);
        return "Message published successfully";
    }
}
//    @GetMapping(value="/kafka")
//    public String sendMsg( ) {
//        Optional<MatchModel> match=matchRepo.findById(65);
//
//        return this.producer.publishToTopic(String.valueOf(match));
//    }
//
//    @GetMapping(value="/post/{msg}")
//    public String sendMessage(@RequestParam("msg") String msg) {
//        producer.publishToTopic(msg);
//
//        return "published successfully";
//    }}

