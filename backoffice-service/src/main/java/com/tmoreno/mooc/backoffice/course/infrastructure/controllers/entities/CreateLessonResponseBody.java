package com.tmoreno.mooc.backoffice.course.infrastructure.controllers.entities;

public record CreateLessonResponseBody(
    String id,
    String title,
    double durationInSeconds
) {
}
