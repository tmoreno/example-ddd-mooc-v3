package com.tmoreno.mooc.backoffice.shared.domain.exceptions;

public final class InvalidDurationException extends InvalidValueException {
    public InvalidDurationException(long value) {
        super(
            "invalid-duration",
            "Duration value have to be more than 0: " + value
        );
    }
}
