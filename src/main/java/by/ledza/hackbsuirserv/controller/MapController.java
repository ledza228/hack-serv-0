package by.ledza.hackbsuirserv.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/api/v1/map/")
@RestController
public class MapController {

    @GetMapping("/")
    public ResponseEntity<FileSystemResource> downloadMapAPI(){
        FileSystemResource resource = new FileSystemResource("src/main/resources/static/map.svg");

        MediaType mediaType = MediaTypeFactory
                .getMediaType(resource)
                .orElse(MediaType.APPLICATION_OCTET_STREAM);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);

        ContentDisposition disposition = ContentDisposition.inline().filename("map.svg").build();
        headers.setContentDisposition(disposition);
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }

}
