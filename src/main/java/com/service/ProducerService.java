package com.service;

import com.model.MatchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    public static final String topic = "mytopic";

    @Autowired
     KafkaTemplate<String, MatchModel> Kafkatemplate;
      public String publishToTopic(MatchModel item) {
        Kafkatemplate.send(topic, item);

          return topic;
    }
}
