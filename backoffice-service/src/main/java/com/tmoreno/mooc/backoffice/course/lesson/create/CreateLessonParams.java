package com.tmoreno.mooc.backoffice.course.lesson.create;

public record CreateLessonParams(
    String title,
    double durationInSeconds
) {
}
