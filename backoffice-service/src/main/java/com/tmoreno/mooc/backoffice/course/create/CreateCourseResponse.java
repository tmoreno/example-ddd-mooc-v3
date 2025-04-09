package com.tmoreno.mooc.backoffice.course.create;

import java.time.Instant;
import java.util.List;

public record CreateCourseResponse(
    String id,
    String title,
    String imageUrl,
    String description,
    String language,
    Double priceValue,
    String priceCurrency,
    List<CreateModuleResponse> modules,
    List<String> teachers,
    Instant createdOn
) {
}
