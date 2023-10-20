package go.kr.dsp.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import go.kr.dsp.demo.camel.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.FluentProducerTemplate;
import org.apache.camel.ProducerTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@CrossOrigin(origins = "*", maxAge = 6000)
public class HttpController {

  private final FluentProducerTemplate fluentProducerTemplate;
  Gson gson=new Gson();

  public HttpController(FluentProducerTemplate fluentProducerTemplate) {
    this.fluentProducerTemplate = fluentProducerTemplate;
  }

  @GetMapping("/http")
  public ResponseEntity<String> http(){
    log.info("hello");
    return ResponseEntity.ok().body("hi");
  }

  @GetMapping("/http1")
  public ResponseEntity<String> http(@RequestParam String name){
    log.info("hello: {}",name);
    return ResponseEntity.ok().body(name);
  }

  @PostMapping("/http2")
  public ResponseEntity<MemberDto> http(@RequestBody MemberDto memberDto){
    log.info("hello: {}",memberDto);
    return ResponseEntity.ok().body(memberDto);
  }

  @PostMapping("/http-service")
  public ResponseEntity<String> httpService(@RequestBody MemberDto memberDto){
    log.info("{}",memberDto);
    ObjectMapper mapper = new ObjectMapper();
    Map<String, String> body = new HashMap<>();
    body.put("name",memberDto.getName());
    try {
      log.info("###################테스트 성공!!!########################");
      return ResponseEntity.ok(fluentProducerTemplate
        .withBody(mapper.writeValueAsString(body))
        .to("rest:post:http-test?host=localhost:1235/camel&bridgeEndpoint=true")
        .request(String.class));
    }catch (Exception e){
      log.info("###################테스트 실패!!!########################");
      return ResponseEntity.ok().body(null);
    }
  }

}
