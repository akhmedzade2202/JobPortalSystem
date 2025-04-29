package com.example.jobportalsystem.repository;

import com.example.jobportalsystem.entity.Application;
import com.example.jobportalsystem.entity.User;
import com.example.jobportalsystem.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    boolean existsByUserAndVacancy(User user, Vacancy vacancy);
    List<Application> findAllByUser(User user);
}
