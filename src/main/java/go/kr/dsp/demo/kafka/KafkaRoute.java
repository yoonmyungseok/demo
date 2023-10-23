package go.kr.dsp.demo.kafka;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaRoute extends RouteBuilder {
  @Override
  public void configure() throws Exception {
    from("jetty:http://localhost:1235/http")
      .convertBodyTo(String.class)
      .removeHeaders("CamelHttp*","CamelHttpMethod")
      .log("http header: ${headers}").log("http body: ${body}")
      .process("httpProcessor")
      .to("http://localhost:1236/sendMessage?bridgeEndpoint=true");

    from("jetty:http://localhost:1236/sendMessage")
//      .setHeader(Exchange.CONTENT_TYPE,constant("application/json; charset=utf-8"))
      .log("headers: ${headers}")
      .process("kafkaProducerProcessor")
      .log("${headers}");

    from("kafka:kafka-test?brokers=172.30.1.109:9092&groupId=group-id-oing")
      .process("kafkaConsumerProcessor")
      .log("${headers}");
  }
}
