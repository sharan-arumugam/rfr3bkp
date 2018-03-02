package com.lti.rfr.web.rest;

import static org.springframework.http.HttpStatus.NOT_MODIFIED;
import static org.springframework.http.ResponseEntity.accepted;
import static org.springframework.http.ResponseEntity.status;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lti.rfr.service.UploadService;

@RestController
@RequestMapping("/api/upload")
public class UploadResource {

    private final Logger log = LoggerFactory.getLogger(UploadResource.class);

    private final UploadService uploadService;

    public UploadResource(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @PostMapping("/rfr")
    public ResponseEntity<HttpStatus> uploadRfr(@RequestParam("rfr") MultipartFile rfr) {
        log.info("Controller invoked");

        ResponseEntity<HttpStatus> response;
        boolean isUploaded = false;

        try {
            isUploaded = uploadService.importRfr(rfr.getOriginalFilename(), rfr.getInputStream());

        } catch (IOException e) {
            log.error(e.getMessage(), e);

        } finally {
            response = isUploaded ? accepted().build() : status(NOT_MODIFIED).build();
        }
        return response;
    }

}
