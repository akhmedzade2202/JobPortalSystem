package com.example.jobportalsystem.controller;

import com.example.jobportalsystem.dto.request.EmployerRequest;
import com.example.jobportalsystem.dto.response.EmployerResponse;
import com.example.jobportalsystem.service.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/employer")
@RequiredArgsConstructor
public class EmployerController {

    private final EmployerService employerService;

    @PostMapping
    public ResponseEntity<EmployerResponse> create(@RequestBody EmployerRequest request) {
        return ResponseEntity.ok(employerService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployerResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(employerService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<EmployerResponse>> getAll() {
        return ResponseEntity.ok(employerService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployerResponse> update(@PathVariable Long id, @RequestBody EmployerRequest request) {
        return ResponseEntity.ok(employerService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}