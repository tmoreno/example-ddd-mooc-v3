package com.tmoreno.mooc.backoffice.course.create;

import java.util.List;

public record CreateModuleResponse(
    String title,
    List<CreateLessonResponse> lessons
) {
}
