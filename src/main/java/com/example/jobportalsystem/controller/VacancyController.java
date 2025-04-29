package com.example.jobportalsystem.controller;

import com.example.jobportalsystem.dto.request.VacancyRequest;
import com.example.jobportalsystem.dto.response.VacancyResponse;
import com.example.jobportalsystem.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/vacancy")
@RequiredArgsConstructor
public class VacancyController {

    private final VacancyService vacancyService;

    @PostMapping
    public ResponseEntity<VacancyResponse> createVacancy(@RequestBody VacancyRequest request) {
        VacancyResponse vacancyResponse = vacancyService.createVacancy(request);
        return new ResponseEntity<>(vacancyResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VacancyResponse> updateVacancy(@PathVariable Long id, @RequestBody VacancyRequest request) {
        VacancyResponse vacancyResponse = vacancyService.updateVacancy(id, request);
        return new ResponseEntity<>(vacancyResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacancyResponse> getVacancy(@PathVariable Long id) {
        VacancyResponse vacancyResponse = vacancyService.getVacancy(id);
        return new ResponseEntity<>(vacancyResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VacancyResponse>> getAllVacancies() {
        List<VacancyResponse> vacancyResponses = vacancyService.getAllVacancies();
        return new ResponseEntity<>(vacancyResponses, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVacancy(@PathVariable Long id) {
        vacancyService.deleteVacancy(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
