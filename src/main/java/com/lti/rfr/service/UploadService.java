package com.lti.rfr.service;

import java.io.InputStream;

public interface UploadService {

    public boolean importRfr(String fileName, InputStream inputStream);

}
