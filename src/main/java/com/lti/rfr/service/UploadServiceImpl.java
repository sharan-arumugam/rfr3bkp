package com.lti.rfr.service;

import static com.lti.rfr.util.ExcelUtil.parseAny;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UploadServiceImpl implements UploadService {

    private final Logger log = LoggerFactory.getLogger(UploadServiceImpl.class);

    private final RfrService rfrService;
    private final FunctionalGroupService groupService;

    public UploadServiceImpl(RfrService rfrService, FunctionalGroupService groupService) {
        this.rfrService = rfrService;
        this.groupService = groupService;
    }

    @Override
    public boolean importRfr(String fileName, InputStream inputStream) {
        log.info("UploadService Invoked:::");

        try {
            List<Map<String, String>> rows = parseAny(fileName, inputStream);
            groupService.importGroup(rows);
            rfrService.importRfr(rows);
            return TRUE;

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return FALSE;
        }
    }

}
