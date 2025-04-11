package com.tmoreno.mooc.backoffice.course.infrastructure.controllers.entities;

import java.util.List;
import java.util.Set;

public record CreateCourseRequestBody(
    String title,
    String imageUrl,
    String description,
    String language,
    Double priceValue,
    String priceCurrency,
    List<CreateModuleRequestBody> modules,
    Set<String> teachers
) {
}
