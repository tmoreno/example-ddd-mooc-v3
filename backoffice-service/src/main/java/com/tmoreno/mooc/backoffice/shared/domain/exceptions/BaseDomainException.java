package com.tmoreno.mooc.backoffice.shared.domain.exceptions;

import java.time.Instant;

public abstract class BaseDomainException extends RuntimeException {

    private final String code;
    private final String message;
    private final Instant timestamp;

    public BaseDomainException(String code, String message) {
        this.code = code;
        this.message = message;
        this.timestamp = Instant.now();
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
