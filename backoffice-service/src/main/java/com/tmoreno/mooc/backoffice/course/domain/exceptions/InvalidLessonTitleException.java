package com.tmoreno.mooc.backoffice.course.domain.exceptions;

import com.tmoreno.mooc.backoffice.shared.domain.exceptions.InvalidValueException;

public final class InvalidLessonTitleException extends InvalidValueException {
    public InvalidLessonTitleException(String message) {
        super(
            "invalid-lesson-title",
            message
        );
    }
}
