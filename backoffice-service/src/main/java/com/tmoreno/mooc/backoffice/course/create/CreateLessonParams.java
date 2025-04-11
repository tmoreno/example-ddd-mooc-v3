package com.tmoreno.mooc.backoffice.course.create;

public record CreateLessonParams(
    String title,
    int durationInSeconds
) {
}
