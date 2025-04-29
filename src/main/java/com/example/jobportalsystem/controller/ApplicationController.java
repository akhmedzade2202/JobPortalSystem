package com.example.jobportalsystem.controller;

import com.example.jobportalsystem.dto.response.ApplicationResponse;
import com.example.jobportalsystem.dto.response.AppliedVacancyDto;
import com.example.jobportalsystem.entity.User;
import com.example.jobportalsystem.service.ApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
@Tag(name = "Applications", description = "Vakansiyalara müraciət və baxış əməliyyatları")
public class ApplicationController {

    private final ApplicationService applicationService;

    @Operation(summary = "Vakansiyaya müraciət et", description = "İstifadəçi vakansiyaya müraciət edir və email alır")
    @PostMapping("/apply/{vacancyId}")
    public ResponseEntity<ApplicationResponse> applyToVacancy(
            @PathVariable Long vacancyId,
            @AuthenticationPrincipal User user) {

        ApplicationResponse response = applicationService.applyToVacancy(vacancyId, user);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Müraciət etdiyim vakansiyalar", description = "İstifadəçi öz apply etdiyi vakansiyaların siyahısını görür")
    @GetMapping("/my")
    public ResponseEntity<List<AppliedVacancyDto>> getMyApplications(
            @AuthenticationPrincipal User user) {

        List<AppliedVacancyDto> applications = applicationService.getMyApplications(user);
        return ResponseEntity.ok(applications);
    }
}
