package com.tmoreno.mooc.backoffice.course.infrastructure.controllers.entities;

import java.util.List;

public record CreateModuleRequestBody(
    String title,
    List<CreateLessonRequestBody> lessons
) {
}
