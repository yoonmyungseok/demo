package go.kr.dsp.demo.camel.fileService;

import org.apache.camel.builder.RouteBuilder;

public class FileTest extends RouteBuilder {
  @Override
  public void configure() throws Exception {
    from("file:C:/dev/study/demo/input")
      .log("Received file ${body}")
//      .to("log:info");
      .to("file:C:/dev/study/demo/output");
  }
}
