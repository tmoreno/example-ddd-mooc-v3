package com.tmoreno.mooc.backoffice.course.infrastructure.controllers.entities;

import java.util.List;

public record CreateModuleResponseBody(
    String id,
    String title,
    List<CreateLessonResponseBody> lessons
) {
}
