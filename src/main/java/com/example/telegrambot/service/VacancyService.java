package com.example.telegrambot.service;

import com.example.telegrambot.dto.VacancyDto;
import jakarta.annotation.PostConstruct;
import org.jvnet.hk2.annotations.Service;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component // @Service
public class VacancyService {
    private final Map<String, VacancyDto> vacancies = new HashMap<>();

    @PostConstruct
    public void init() {
        VacancyDto juniorMaDeveloper = new VacancyDto();
        juniorMaDeveloper.setId("1");
        juniorMaDeveloper.setTitle("Junior Dev at MA");
        juniorMaDeveloper.setShortDescription("Java Core is required!");
        vacancies.put("1", juniorMaDeveloper);

        VacancyDto middle = new VacancyDto();
        middle.setId("2");
        middle.setTitle("Middle Java dev");
        middle.setShortDescription("Join our awesome company!");
        vacancies.put("2", middle);
    }

    public List<VacancyDto> getJuniorVacancies() {
        return vacancies.values().stream().filter(v -> v.getTitle().toLowerCase().contains("junior")).toList();
    }

}
