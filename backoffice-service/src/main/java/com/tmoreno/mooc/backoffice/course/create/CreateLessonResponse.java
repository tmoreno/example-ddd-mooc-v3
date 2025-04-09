package com.tmoreno.mooc.backoffice.course.create;

public record CreateLessonResponse(
    String id,
    String title,
    double durationInSeconds
) {
}
