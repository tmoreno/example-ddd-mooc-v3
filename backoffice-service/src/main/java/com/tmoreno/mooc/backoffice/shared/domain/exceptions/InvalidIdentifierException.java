package com.tmoreno.mooc.backoffice.shared.domain.exceptions;

public final class InvalidIdentifierException extends InvalidValueException {
    public InvalidIdentifierException(String invalidIdentifierValue) {
        super(
            "invalid-identifier",
            "Invalid identifier value: " + invalidIdentifierValue
        );
    }
}
