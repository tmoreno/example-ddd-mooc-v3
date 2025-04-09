package com.tmoreno.mooc.backoffice.course.create;

public record CreateLessonResponse(
    String title,
    double durationInSeconds
) {
}
