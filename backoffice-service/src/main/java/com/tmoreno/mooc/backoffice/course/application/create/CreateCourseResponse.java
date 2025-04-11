package com.tmoreno.mooc.backoffice.course.application.create;

import java.time.Instant;
import java.util.List;
import java.util.Set;

public record CreateCourseResponse(
    String id,
    String title,
    String imageUrl,
    String description,
    String language,
    Double priceValue,
    String priceCurrency,
    List<CreateModuleResponse> modules,
    Set<String> teachers,
    Instant createdOn
) {
}
