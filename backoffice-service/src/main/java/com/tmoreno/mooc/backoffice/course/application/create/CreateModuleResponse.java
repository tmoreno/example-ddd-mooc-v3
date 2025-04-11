package com.tmoreno.mooc.backoffice.course.application.create;

import java.util.List;

public record CreateModuleResponse(
    String id,
    String title,
    List<CreateLessonResponse> lessons
) {
}
