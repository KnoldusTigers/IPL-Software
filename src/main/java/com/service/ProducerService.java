package com.service;
import com.google.gson.Gson;
import com.model.JsonModel;
import com.model.MatchModel;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class ProducerService {
    public static final String topic = "mytopic";

    @Autowired
        KafkaTemplate<String, String> Kafkatemplate;


    public String publishToTopic (MatchModel item){
        JsonModel model=new JsonModel();
        model.setId((long) item.getMatchid());
        model.setScheduledate(item.getScheduledate());
        model.setVenue(item.getVenue());
        model.setResult(item.getResult());

        Kafkatemplate.send(topic, new Gson().toJson( model));
        return topic;
    }
    }
