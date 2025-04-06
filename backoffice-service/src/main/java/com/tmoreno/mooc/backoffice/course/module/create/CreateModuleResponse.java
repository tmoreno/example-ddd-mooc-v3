package com.tmoreno.mooc.backoffice.course.module.create;

import com.tmoreno.mooc.backoffice.course.lesson.create.CreateLessonResponse;

import java.util.List;

public record CreateModuleResponse(
    String id,
    String title,
    List<CreateLessonResponse> lessons
) {
}
