package com.tmoreno.mooc.backoffice.course.application.create;

public record CreateLessonParams(
    String title,
    int durationInSeconds
) {
}
