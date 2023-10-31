package go.kr.dsp.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import go.kr.dsp.demo.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okio.ByteString;
import org.apache.camel.FluentProducerTemplate;
import org.apache.camel.ProducerTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Slf4j
@RequiredArgsConstructor
public class FileController {

  private final FileService fileService;
  private final FluentProducerTemplate fluentProducerTemplate;
  private final ProducerTemplate producerTemplate;

  @PostMapping("/fileTest")
  public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
//    byte[] bytes= Objects.requireNonNull(multipartFile.getOriginalFilename()).getBytes();
    byte[] bytes=multipartFile.getBytes();

    String byteToString=new String(bytes, StandardCharsets.ISO_8859_1);
    Map<String, String> map=new HashMap<>();
    map.put("file",byteToString);
    ObjectMapper objectMapper = new ObjectMapper();
    String data=objectMapper.writeValueAsString(map);
//      return ResponseEntity.ok(json);
//    producerTemplate.sendBody("http://localhost:9999/file?bridgeEndpoint=true",map);
//    return ResponseEntity.ok(fluentProducerTemplate.withBody(map)
//      .to("http://localhost:9999/file?bridgeEndpoint=true").request(String.class)
//    String s = producerTemplate.requestBody("http://localhost:9999/file?bridgeEndpoint=true", map, String.class);
    log.info("data:");
    fluentProducerTemplate.withProcessor(exchange -> {
      exchange.getMessage().setHeader("fileName",multipartFile.getOriginalFilename());
      exchange.getMessage().setBody(data);
    }).to("http://localhost:9999/file").request();
//    producerTemplate.sendBody("http://localhost:9999/file",data);
    log.info("data:");
    return ResponseEntity.ok("s");
  }
}
