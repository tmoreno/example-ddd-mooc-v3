package com.tmoreno.mooc.backoffice.shared.domain.exceptions;

public abstract class InvalidValueException extends BaseDomainException {
    public InvalidValueException(String code, String message) {
        super(code, message);
    }
}
