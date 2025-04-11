package com.tmoreno.mooc.backoffice.course.infrastructure.controllers.entities;

public record CreateLessonRequestBody(
    String title,
    int durationInSeconds
) {
}
