package com.lti.rfr.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.lti.rfr.domain.Rfr;

public interface RfrService {

    void importRfr(List<Map<String, String>> rows);

    List<Rfr> getAll();

    Optional<Rfr> getById(Long requestId);

    Rfr update(Map<String, String> rfrRawMap);
}
