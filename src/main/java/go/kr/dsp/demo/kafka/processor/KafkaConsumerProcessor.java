package go.kr.dsp.demo.kafka.processor;

import go.kr.dsp.demo.config.KafkaConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;


@Component
@Slf4j
public class KafkaConsumerProcessor implements Processor {

  @Override
  public void process(Exchange exchange) throws Exception {
    log.info("exchange: {}", new String((byte[]) exchange.getMessage().getHeader("why"), StandardCharsets.UTF_8));
    log.info("consumer: {}",exchange.getMessage().getHeaders());
    log.info("consumer: {}",exchange.getMessage().getBody());
  }
}
