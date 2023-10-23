package go.kr.dsp.demo.camel.processor;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.FluentProducerTemplate;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class FileWriteProcessor implements Processor {
  private final FluentProducerTemplate producerTemplate;

  public FileWriteProcessor(FluentProducerTemplate producerTemplate) {
    this.producerTemplate = producerTemplate;
  }

  @Override
  public void process(Exchange exchange) throws Exception {
    Map<String, Object> map=new HashMap<>();

    log.info("=====FileWriteProcessor=====");
    log.info("FileWriteProcessor: {}",exchange.getMessage().getHeaders());
    map.put("message",exchange.getMessage().getBody());

    exchange.getMessage().setBody(map);
    exchange.getMessage().setHeader("name","yoonmyungseok");
//    log.info("FileWriteProcessor: {}",exchange.getMessage().getHeader("Name"));
//    exchange.getMessage().setHeaders(map);
  }
}
