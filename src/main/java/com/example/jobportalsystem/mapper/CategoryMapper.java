package com.example.jobportalsystem.mapper;

import com.example.jobportalsystem.dto.request.CategoryRequest;
import com.example.jobportalsystem.dto.response.CategoryResponse;
import com.example.jobportalsystem.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "vacancies", ignore = true)
    Category toEntity(CategoryRequest request);

    CategoryResponse toResponse(Category category);
}