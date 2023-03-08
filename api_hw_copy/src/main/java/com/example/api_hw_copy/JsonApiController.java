package com.example.api_hw_copy;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

@RestController

public class JsonApiController {
    @GetMapping("/api/data")
    public ResponseEntity<Resource> getData() throws IOException {
        URL url = new URL("https://ws.yunlin.gov.tw/001/Upload/539/opendata/15369/1540/1b51d152-0925-4b6d-8e8d-1511c9621e41.json");
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();
        InputStreamResource resource = new InputStreamResource(inputStream);

        return ResponseEntity.ok()
                .contentLength(connection.getContentLength())
                .contentType(MediaType.APPLICATION_JSON)
                .body(resource);
    }
}
