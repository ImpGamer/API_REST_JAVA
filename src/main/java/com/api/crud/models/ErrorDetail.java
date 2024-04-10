package com.api.crud.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ErrorDetail {
    private String title;
    private int status;
    private String detail;
    private long timeStamp;
    private String developerMessage;
}
