package com.nsergey.generator.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class IdGenerationException extends RuntimeException {
    public IdGenerationException() {
        super();
    }

    public IdGenerationException(String message, Throwable cause) {
        super(message, cause);
    }

    public IdGenerationException(String message) {
        super(message);
    }

    public IdGenerationException(Throwable cause) {
        super(cause);
    }
}