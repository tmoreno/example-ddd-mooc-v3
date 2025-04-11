package com.tmoreno.mooc.backoffice.course.create;

import java.util.List;
import java.util.Set;

public record CreateCourseParams(
    String title,
    String imageUrl,
    String description,
    String language,
    Double priceValue,
    String priceCurrency,
    List<CreateModuleParams> modules,
    Set<String> teachers
) {
}
