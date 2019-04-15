package com.test.javaspringvue.api.media;

import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/media")
public class UploadController {

    private final String currentDir = System.getProperty("user.dir");
    private final String uploadDir = currentDir + "/src/main/resources/static/assets/img/";


    @PostConstruct
    private void mountUploader(){
        File path = new File(uploadDir);
        if(!path.exists())
            path.mkdirs();
    }

    @PostMapping
    List<String> uploadPicture(@RequestParam("files") MultipartFile[] files){
        ArrayList<String> paths = new ArrayList<>();
        String[] allowedContent = {"image/"};
        for(MultipartFile file : files){
            if(!file.getContentType().matches("^"+String.join("|", allowedContent)+".*$"))
                continue;
            String filename = UUID.randomUUID().toString().
                    concat(file.getOriginalFilename().replaceAll("^.*(\\.[\\w]{3,4})$", "$1"));
            File path = new File(uploadDir+filename);
            try{
                file.transferTo(path);
                paths.add(filename);
            }catch (Exception e){}
        }
        return paths;
    }
}
