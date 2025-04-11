package com.tmoreno.mooc.backoffice.course.domain.exceptions;

import com.tmoreno.mooc.backoffice.shared.domain.exceptions.InvalidValueException;

public final class InvalidModuleTitleException extends InvalidValueException {
    public InvalidModuleTitleException(String message) {
        super(
            "invalid-module-title",
            message
        );
    }
}
