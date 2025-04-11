package com.tmoreno.mooc.backoffice.course.domain.exceptions;

import com.tmoreno.mooc.backoffice.shared.domain.exceptions.InvalidValueException;

public final class InvalidCourseTitleException extends InvalidValueException {
    public InvalidCourseTitleException(String message) {
        super(
            "invalid-course-title",
            message
        );
    }
}
