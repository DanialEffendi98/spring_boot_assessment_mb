package com.example.assessment.services.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.assessment.dto.response.ThirdPartyResponse;
import com.example.assessment.services.ThirdPartyService;

@Service
public class ThirdPartyServiceImpl implements ThirdPartyService{
    
    private static final Logger log = LoggerFactory.getLogger(UsersServiceImpl.class);

    private final String API_URL = "https://cat-fact.herokuapp.com/facts/";
    private final RestTemplate restTemplate;

    public ThirdPartyServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ThirdPartyResponse> getCatFacts() {
        try {
            ResponseEntity<List<ThirdPartyResponse>> response = restTemplate.exchange(
                API_URL, 
                HttpMethod.GET, 
                null, 
                new ParameterizedTypeReference<List<ThirdPartyResponse>>() {}
            );
            log.info("Cat Facts API Response {} ", response.toString());

            if (response.getStatusCode() == HttpStatus.OK) {
                List<ThirdPartyResponse> catFactsList = response.getBody();
                return catFactsList != null ? catFactsList : Collections.emptyList();
            } else {
                log.error("Failed to fetch cat facts. Status code: {} ", response.getStatusCode());
                return Collections.emptyList();
            }
        } catch (RestClientException e) {
            log.error("Error fetching cat facts: {} ", e.getMessage());
            return Collections.emptyList();
        }
    }
}
