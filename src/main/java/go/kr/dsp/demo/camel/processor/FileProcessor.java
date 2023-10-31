package go.kr.dsp.demo.camel.processor;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.converter.stream.InputStreamCache;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@Component
@Slf4j
public class FileProcessor implements Processor {
  @Override
  public void process(Exchange exchange) throws Exception {

    log.info("headers: {}",exchange.getMessage().getHeaders());
    Map<String, String> map = exchange.getIn().getBody(Map.class);
    String fileData=map.get("file").replaceAll("^\"|\"$", "");
    byte[] bytes=fileData.getBytes(StandardCharsets.ISO_8859_1);
    exchange.getMessage().setBody(bytes);
//    Path path=Paths.get("output/test.pdf");
//    try{
//      Files.write(path,bytes);
//    }catch (IOException e){
//      e.printStackTrace();
//    }
//    File out=new File("output/aa.text");
//    FileOutputStream outputStream=new FileOutputStream(out);
//
//    outputStream.write(bytes);
//    outputStream.close();
//    log.info("header: {}",exchange.getMessage().getHeaders());
//    InputStream inputStream = exchange.getIn().getBody(InputStream.class);
//    // InputStream을 사용하여 데이터 읽기
//    byte[] buffer = new byte[1024]; // 읽을 버퍼 크기 지정
//    int bytesRead;
//    StringBuilder data = new StringBuilder();
//
//    while ((bytesRead = inputStream.read(buffer)) != -1) {
//      // 읽은 데이터를 문자열로 변환 및 처리
//      data.append(new String(buffer, 0, bytesRead));
//    }
//
//    // 읽은 데이터 출력 또는 다른 작업 수행
//    System.out.println("Received data: " + value);
//
//    // 반드시 InputStream을 닫아야 함
//    inputStream.close();
//    byte[] fileContent = exchange.getIn().getBody(byte[].class);
//    Path path = Paths.get("C:/dev/study/demo/output/aa.pdf");
//    Files.write(path, fileContent);
//    for(Map.Entry<String, DataHandler>entry:map.entrySet()){
//      String attachmentName = entry.getKey();
//      DataHandler attachment = entry.getValue();
//      String attachmentFileName = attachment.getName();
//
//      // 확장자 추출
//      String fileExtension = getFileExtension(attachmentFileName);
//
//      // 확장자 확인
//      System.out.println("첨부 파일 이름: " + attachmentFileName);
//      System.out.println("첨부 파일 확장자: " + fileExtension);
//      log.info("파일 key: {}",entry.getKey());
//      log.info("파일 value: {}",entry.getValue().getInputStream());
//    }
//    AttachmentMessage attachmentMessage = exchange.getIn(AttachmentMessage.class);
//    Set<String> attachmentNames = attachmentMessage.getAttachmentNames();
//
//    for (String attachmentName : attachmentNames) {
//      System.out.println("Attachment Name: " + attachmentName);
//    }
//    byte[] fileContent = exchange.getIn().getBody(byte[].class);
//    try (FileOutputStream fos = new FileOutputStream("C:/dev/study/demo/output/aa.pdf")) {
//      fos.write(fileContent);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
  }
}
