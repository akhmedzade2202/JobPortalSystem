package com.example.jobportalsystem.repository;

import com.example.jobportalsystem.entity.User;
import com.example.jobportalsystem.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    List<Vacancy> findByEmployer(User employer);

    List<Vacancy> findByTitleContainingIgnoreCase(String title);

    List<Vacancy> findByLocationContainingIgnoreCase(String location);

    @Query("SELECT v FROM Vacancy v WHERE " +
            "(:title IS NULL OR LOWER(v.title) LIKE LOWER(CONCAT('%', :title, '%'))) AND " +
            "(:location IS NULL OR LOWER(v.location) LIKE LOWER(CONCAT('%', :location, '%')))")
    List<Vacancy> findByFilters(@Param("title") String title, @Param("location") String location);
}
