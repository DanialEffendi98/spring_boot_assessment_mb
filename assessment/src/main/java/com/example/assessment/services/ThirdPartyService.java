package com.example.assessment.services;

import java.util.List;

import com.example.assessment.dto.response.ThirdPartyResponse;

public interface ThirdPartyService {
    public List<ThirdPartyResponse> getCatFacts();
}
