package com.example.jobportalsystem.mapper;

import com.example.jobportalsystem.dto.request.EmployerRequest;
import com.example.jobportalsystem.dto.response.EmployerResponse;
import com.example.jobportalsystem.entity.Employer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "vacancies", ignore = true)
    Employer toEntity(EmployerRequest request);

    EmployerResponse toResponse(Employer employer);
}