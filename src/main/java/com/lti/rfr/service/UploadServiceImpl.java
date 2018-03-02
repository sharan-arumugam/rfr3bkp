package com.lti.rfr.service;

import static com.lti.rfr.util.ExcelUtil.parseAny;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UploadServiceImpl implements UploadService {

    private final Logger log = LoggerFactory.getLogger(UploadServiceImpl.class);

    private final RfrService rfrService;

    public UploadServiceImpl(RfrService rfrService) {
        this.rfrService = rfrService;
    }

    @Override
    public boolean importRfr(String fileName, InputStream inputStream) {
        log.info("UploadService Invoked:::");

        try {
            rfrService.importRfr(parseAny(fileName, inputStream));
            return TRUE;

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return FALSE;
        }
    }

}
