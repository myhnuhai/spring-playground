package playground.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Object upload(
            @RequestParam("file") MultipartFile[] files
    ) {
        for (MultipartFile file : files) {
            // DO SOMETHING HERE.
        }
        return "OK";
    }
}
