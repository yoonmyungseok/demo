package go.kr.dsp.demo.camel.processor;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class HttpProcessor implements Processor {
  @Override
  public void process(Exchange exchange) throws Exception {
    String name=exchange.getMessage().getHeader("name", String.class);
    String age=exchange.getMessage().getHeader("age", String.class);
    String city=exchange.getMessage().getHeader("city", String.class);
    log.info("type: {}",exchange.getMessage().getHeaders().getClass());
    log.info("name: {}, age: {}, city: {}",name,age,city);
//    Map<String, Object> map=new HashMap<>();
//    map.put("name","name["+name+"]");
//    map.put("age","age["+age+"]");
//    map.put("city","city["+city+"]");
//    exchange.getMessage().setHeaders(map);
    exchange.getMessage().setHeader("name",name);
    exchange.getMessage().setHeader("age",age);
    exchange.getMessage().setHeader("city",city);
  }
}
