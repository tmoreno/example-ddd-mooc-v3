package com.tmoreno.mooc.backoffice.course.infrastructure.controllers.entities;

import java.time.Instant;
import java.util.List;
import java.util.Set;

public record CreateCourseResponseBody(
    String id,
    String title,
    String imageUrl,
    String description,
    String language,
    Double priceValue,
    String priceCurrency,
    List<CreateModuleResponseBody> modules,
    Set<String> teachers,
    Instant createdOn
) {
}
