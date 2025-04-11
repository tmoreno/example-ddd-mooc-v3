package com.tmoreno.mooc.backoffice.course.domain.exceptions;

import com.tmoreno.mooc.backoffice.course.domain.CourseTitle;
import com.tmoreno.mooc.backoffice.shared.domain.exceptions.BaseDomainException;

public final class CourseExistsException extends BaseDomainException {
    public CourseExistsException(CourseTitle title) {
        super(
            "course-exists",
            "A course with this title: " + title.value() + " already exists"
        );
    }
}
