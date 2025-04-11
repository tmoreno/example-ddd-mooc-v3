package com.tmoreno.mooc.backoffice.course.domain.events;

import com.tmoreno.mooc.backoffice.course.domain.Course;
import com.tmoreno.mooc.backoffice.shared.domain.events.DomainEvent;

public final class CourseCreatedDomainEvent extends DomainEvent {

    private final Course course;

    public CourseCreatedDomainEvent(Course course) {
        super(course.getId(), 1);

        this.course = course;
    }

    public Course getCourse() {
        return course;
    }
}
