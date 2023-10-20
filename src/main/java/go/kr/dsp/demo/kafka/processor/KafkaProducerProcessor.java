package go.kr.dsp.demo.kafka.processor;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaProducerProcessor implements Processor {

  private final KafkaTemplate<String,String> kafkaTemplate;

  public KafkaProducerProcessor(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  @Override
  public void process(Exchange exchange) throws Exception {
    try {
      String message=exchange.getMessage().getHeader("name",String.class);
      log.info("send message: "+message);
      kafkaTemplate.send("kafka-test", message);
    }catch (Exception e){
      e.getStackTrace();
    }
  }
}
