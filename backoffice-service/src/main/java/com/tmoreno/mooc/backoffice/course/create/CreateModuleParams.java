package com.tmoreno.mooc.backoffice.course.create;

import java.util.List;

public record CreateModuleParams(
    String title,
    List<CreateLessonParams> lessons
) {
}
