package go.kr.dsp.demo.kafka.processor;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class KafkaProducerProcessor implements Processor {

  private final KafkaTemplate<String,Object> kafkaTemplate;

  public KafkaProducerProcessor(KafkaTemplate<String, Object> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }


  @Override
  public void process(Exchange exchange) throws Exception {
    try {
      log.info("send message: "+exchange.getMessage().getHeaders());
      ProducerRecord<String, Object> record=new ProducerRecord<>("kafka-test","Test string");
//      record.headers().add("why",exchange.getMessage().getHeader("name",String.class).getBytes(StandardCharsets.UTF_8));
      log.info("record: {}", record);
      kafkaTemplate.send(record);
    }catch (Exception e){
      e.getStackTrace();
    }
  }
}
