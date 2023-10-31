package go.kr.dsp.demo;

import okio.ByteString;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Service
public class FileService {


  public File multipartToFile(MultipartFile file) throws IOException {
    File f=new File(file.getOriginalFilename());
    file.transferTo(f);
    return f;
  }
}
