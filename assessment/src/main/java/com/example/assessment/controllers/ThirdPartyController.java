package com.example.assessment.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assessment.dto.response.ThirdPartyResponse;
import com.example.assessment.services.ThirdPartyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/third-party")
public class ThirdPartyController {

    @Autowired
    ThirdPartyService thirdPartyService;

    @GetMapping("/cat-facts")
    public ResponseEntity<List<ThirdPartyResponse>> getCatFacts() {
        List<ThirdPartyResponse> response = thirdPartyService.getCatFacts();
        return ResponseEntity.ok(response);
    }
}
