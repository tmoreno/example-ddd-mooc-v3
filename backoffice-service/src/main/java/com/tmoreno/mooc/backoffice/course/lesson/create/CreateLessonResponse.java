package com.tmoreno.mooc.backoffice.course.lesson.create;

public record CreateLessonResponse(
    String id,
    String title,
    double durationInSeconds
) {
}
