//package com.controller;
//
//
//import com.google.gson.Gson;
//import com.model.MatchModel;
//import com.service.ProducerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/kafkaapp")
//public class KafkaController {
//
//    @Autowired
//    ProducerService producer;
////    @Autowired
////    MatchRepo matchRepo;
//
//    @GetMapping(value = "/postItem")
//    public String postJsonMessage( MatchModel item) {
////        item.setMatchid(12);
////        item.setResult("Akshit wons by 50 rus");
////        item.setScheduledate("10/12/2021");
////        item.setTeam1Description("260");
////        item.setTeam2Description("210");
////        item.setVenue("Delhi");
//
//        producer.publishToTopic(new Gson().toJson( item));
//        return "Message published successfully";
//    }
//}
////    @GetMapping(value="/kafka")
////    public String sendMsg( ) {
////        Optional<MatchModel> match=matchRepo.findById(65);
////
////        return this.producer.publishToTopic(String.valueOf(match));
////    }
////
////    @GetMapping(value="/post/{msg}")
////    public String sendMessage(@RequestParam("msg") String msg) {
////        producer.publishToTopic(msg);
////
////        return "published successfully";
////    }}
//
