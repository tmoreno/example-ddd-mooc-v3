package com.tmoreno.mooc.backoffice.course.application.create;

public record CreateLessonResponse(
    String id,
    String title,
    double durationInSeconds
) {
}
