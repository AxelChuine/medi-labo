package com.openclassrooms.medilabo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AlreadyExistsException extends RuntimeException {
    private String message;
    private HttpStatus status;

    public AlreadyExistsException(String message) {
        super(message);
        this.message = message;
        this.status = HttpStatus.CONFLICT;
    }
}
