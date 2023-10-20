package go.kr.dsp.demo.kafka;

import go.kr.dsp.demo.kafka.processor.KafkaProducerProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaRoute extends RouteBuilder {
  @Override
  public void configure() throws Exception {
    from("jetty:http://localhost:9999/sendMessage")
      .setHeader(Exchange.CONTENT_TYPE,constant("application/json; charset=utf-8"))
      .process("kafkaProducerProcessor")
      .log("${headers}");
  }
}
