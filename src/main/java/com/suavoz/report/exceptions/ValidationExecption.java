package com.suavoz.report.exceptions;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class ValidationExecption extends RuntimeException{

    @Getter
    private final List<String> validationErrors;

    public ValidationExecption(List<String> validationErrors) {
        super(validationErrors.stream().collect(Collectors.joining(";")));
        this.validationErrors = validationErrors;
    }

    public ValidationExecption(String errorMessage) {
        super(errorMessage);
        validationErrors = List.of(errorMessage);
    }
}
