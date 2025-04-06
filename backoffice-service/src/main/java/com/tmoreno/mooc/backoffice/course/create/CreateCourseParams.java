package com.tmoreno.mooc.backoffice.course.create;

import com.tmoreno.mooc.backoffice.course.module.create.CreateModuleParams;

import java.util.List;

public record CreateCourseParams(
    String title,
    String imageUrl,
    String description,
    String language,
    Double priceValue,
    String priceCurrency,
    List<CreateModuleParams> modules,
    List<String> teachers
) {
}
