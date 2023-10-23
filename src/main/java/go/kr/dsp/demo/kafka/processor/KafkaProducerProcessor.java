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
//      String name=exchange.getMessage().getHeader("name",String.class);
//      String age=exchange.getMessage().getHeader("age",String.class);
//      String city=exchange.getMessage().getHeader("city",String.class);
//      Map<String, Object> map=new HashMap<>();
//      map.put("name",exchange.getMessage().getHeader("name",String.class));
//      map.put("age",exchange.getMessage().getHeader("age",String.class));
//      map.put("city",exchange.getMessage().getHeader("city",String.class));
//      exchange.getMessage().setHeaders(map);
      log.info("send message: "+exchange.getMessage().getHeaders());
      ProducerRecord<String, Object> record=new ProducerRecord<>("kafka-test","Test string");
      record.headers().add("why",exchange.getMessage().getHeader("name",String.class).getBytes(StandardCharsets.UTF_8));
      kafkaTemplate.send(record);
    }catch (Exception e){
      e.getStackTrace();
    }
  }
}
