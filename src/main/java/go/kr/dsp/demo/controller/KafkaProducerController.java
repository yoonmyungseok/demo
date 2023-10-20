package go.kr.dsp.demo.controller;

import go.kr.dsp.demo.camel.dto.MemberDto;
import go.kr.dsp.demo.kafka.service.ProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerController {

  private final ProducerService producerService;
//  @PostMapping(value="/sendMessage")
  public void sendMessage(@RequestHeader("name") String name, @RequestBody MemberDto memberDto){
    log.info("헤더 가져옴: {}",name);
    log.info("바디 가져옴: {}", memberDto);
    producerService.sendMessage(name);
  }
}
