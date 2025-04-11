package com.tmoreno.mooc.backoffice.course.domain.exceptions;

import com.tmoreno.mooc.backoffice.shared.domain.exceptions.InvalidValueException;

public final class InvalidCourseDescriptionException extends InvalidValueException {
    public InvalidCourseDescriptionException(String message) {
        super(
            "invalid-course-description",
            message
        );
    }
}
