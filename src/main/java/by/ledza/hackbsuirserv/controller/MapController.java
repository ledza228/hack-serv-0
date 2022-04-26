package by.ledza.hackbsuirserv.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

@RequestMapping("/api/v1/map/")
@RestController
public class MapController {

    @GetMapping("")
    public ResponseEntity<FileSystemResource> downloadMapAPI(){

        if (!Files.exists(Path.of("map.png"))){
            return null;
        }

        FileSystemResource resource = new FileSystemResource("map.png");
        MediaType mediaType = MediaTypeFactory
                .getMediaType(resource)
                .orElse(MediaType.APPLICATION_OCTET_STREAM);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);

        ContentDisposition disposition = ContentDisposition.inline().filename("map.png").build();
        headers.setContentDisposition(disposition);
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }

     @PostMapping(value = "{fileName}", headers = {"content-type=multipart/form-data"})
    public ResponseEntity<String> uploadMapAPI(@RequestParam("file") MultipartFile file) throws IOException {
        File descr = new File("map.png");

        try (FileOutputStream outputStream = new FileOutputStream(descr)){
            outputStream.write(file.getBytes());
        }
        catch (Exception e){
            return new ResponseEntity<String>("Error while saving!",HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>("Saved!", HttpStatus.OK);
    }

}
