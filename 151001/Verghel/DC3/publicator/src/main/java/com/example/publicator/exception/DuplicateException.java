package com.example.publicator.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DuplicateException extends RuntimeException {
    private String message;
    private long status;
}
