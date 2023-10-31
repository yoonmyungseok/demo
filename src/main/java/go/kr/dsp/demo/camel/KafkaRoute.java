package go.kr.dsp.demo.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Expression;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.InputStream;

@Component
public class KafkaRoute extends RouteBuilder {
  @Override
  public void configure() throws Exception {
    from("jetty:http://localhost:9999/file")
      .unmarshal().json()
      .process("fileProcessor")
      .to("file:output?fileName=${header.fileName}")
      ;



//    from("jetty:http://localhost:1002/http")
//      .removeHeaders("CamelHttp*","CamelHttpMethod")
//      .log("http header: ${headers}").log("http body: ${body}")
//      .process("httpProcessor")
//      .to("http://localhost:1236/sendMessage?bridgeEndpoint=true");
//
//    from("jetty:http://localhost:1102/sendMessage")
////      .setHeader(Exchange.CONTENT_TYPE,constant("application/json; charset=utf-8"))
//      .log("headers: ${headers}")
//      .process("kafkaProducerProcessor")
//      .log("${headers}");
//
//    from("kafka:kafka-test?brokers=172.30.1.109:9092&groupId=group-id-oing")
//      .process("kafkaConsumerProcessor")
//      .log("${headers}");
  }
}
