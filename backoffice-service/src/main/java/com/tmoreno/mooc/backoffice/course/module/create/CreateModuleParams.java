package com.tmoreno.mooc.backoffice.course.module.create;

import com.tmoreno.mooc.backoffice.course.lesson.create.CreateLessonParams;

import java.util.List;

public record CreateModuleParams(
    String title,
    List<CreateLessonParams> lessons
) {
}
