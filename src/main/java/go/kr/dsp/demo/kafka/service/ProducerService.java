package go.kr.dsp.demo.kafka.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

//@Component
//@RequiredArgsConstructor
@Slf4j
public class ProducerService {
//  private final KafkaTemplate<String,String> kafkaTemplate;

  public void sendMessage(String message){
    try {
      log.info("send message: "+message);
//      kafkaTemplate.send("kafka-test", message);
    }catch (Exception e){
      e.getStackTrace();
    }
  }

}
