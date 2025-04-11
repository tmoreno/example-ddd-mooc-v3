package com.tmoreno.mooc.backoffice.course.domain.exceptions;

import com.tmoreno.mooc.backoffice.shared.domain.exceptions.InvalidValueException;

public final class InvalidCourseImageUrlException extends InvalidValueException {
    public InvalidCourseImageUrlException(String message) {
        super(
            "invalid-course-image-url",
            message
        );
    }
}
