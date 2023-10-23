package go.kr.dsp.demo.camel.processor;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RenameProcessor implements Processor {
  @Override
  public void process(Exchange exchange) throws Exception {
    log.info(exchange.getMessage().getHeaders().toString());
  }
}
