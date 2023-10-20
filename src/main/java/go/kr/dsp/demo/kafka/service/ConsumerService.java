package go.kr.dsp.demo.kafka.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class ConsumerService {

  private final ObjectMapper objectMapper;
  @KafkaListener(topics = "kafka-test", groupId = "group-id-oing")
  public void consume(String message) throws IOException {
    String result=message.concat("이를ㄹㄹ");

    log.info("receive message: "+result);
  }
}
