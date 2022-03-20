package com.suavoz.report.usecases.validators;

import com.suavoz.report.domain.Report;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateReportValidator {

    public List<String> validate(Report report) {
        List<String> validationErrors = new ArrayList<>();

        if (report == null) {
            validationErrors.add("Denúncia não pode ser nula");
        }

        if (!StringUtils.hasText(report.getDescription())) {
            validationErrors.add("Relato não pode ser vazio");
        }

        if (report.getAgeGroup() == null) {
            validationErrors.add("Faixa etaria não pode ser nula");
        }

        if (report.getGenre() == null) {
            validationErrors.add("Genero não pode ser nula");
        }

        if (report.getViolenceType() == null) {
            validationErrors.add("Tipo de violencia não pode ser nula");
        }

        if (report.getZone() == null) {
            validationErrors.add("Região não pode ser nula");
        }

        return validationErrors;
    }
}
