package com.tmoreno.mooc.backoffice.course.domain;

import com.tmoreno.mooc.backoffice.course.create.CreateCourseParams;
import com.tmoreno.mooc.backoffice.shared.domain.AggregateRoot;
import com.tmoreno.mooc.backoffice.shared.domain.Language;
import com.tmoreno.mooc.backoffice.shared.domain.Price;
import com.tmoreno.mooc.backoffice.teacher.domain.TeacherId;

import java.time.Instant;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public final class Course extends AggregateRoot<CourseId> {

    private CourseTitle title;
    private CourseImageUrl imageUrl;
    private CourseDescription description;
    private CourseState state;
    private Language language;
    private Price price;
    private final Map<ModuleId, Module> modules;
    private final Set<TeacherId> teachers;
    private final Instant createdOn;
    private Instant updatedOn;

    private Course(
        CourseId id,
        CourseTitle title,
        CourseImageUrl imageUrl,
        CourseDescription description,
        CourseState state,
        Language language,
        Price price,
        Map<ModuleId, Module> modules,
        Set<TeacherId> teachers,
        Instant createdOn,
        Instant updatedOn
    ) {
        super(id);
        this.title = title;
        this.imageUrl = imageUrl;
        this.description = description;
        this.state = state;
        this.language = language;
        this.price = price;
        this.modules = new HashMap<>(modules);
        this.teachers = new HashSet<>(teachers);
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public static Course create(CreateCourseParams params) {
        Instant now = Instant.now();

        Map<ModuleId, Module> modules = params.modules() == null
            ? Map.of()
            : params.modules().stream().map(Module::create).collect(Collectors.toMap(Module::getId, module -> module));

        Set<TeacherId> teachers = params.teachers() == null
            ? Set.of()
            : params.teachers().stream().map(TeacherId::new).collect(Collectors.toSet());

        return new Course(
            new CourseId(),
            new CourseTitle(params.title()),
            params.imageUrl() == null ? null : new CourseImageUrl(params.imageUrl()),
            params.description() == null ? null : new CourseDescription(params.description()),
            CourseState.DRAFT,
            params.language() == null ? null : Language.valueOf(params.language()),
            params.priceValue() == null || params.priceCurrency() == null ? null : new Price(params.priceValue(), Currency.getInstance(params.priceCurrency())),
            modules,
            teachers,
            now,
            now
        );
    }

    public CourseTitle getTitle() {
        return title;
    }

    public Optional<CourseImageUrl> getImageUrl() {
        return Optional.ofNullable(imageUrl);
    }

    public Optional<CourseDescription> getDescription() {
        return Optional.ofNullable(description);
    }

    public CourseState getState() {
        return state;
    }

    public Optional<Language> getLanguage() {
        return Optional.ofNullable(language);
    }

    public Optional<Price> getPrice() {
        return Optional.ofNullable(price);
    }

    public List<Module> getModules() {
        return List.copyOf(modules.values());
    }

    public Set<TeacherId> getTeachers() {
        return Set.copyOf(teachers);
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public Instant getUpdatedOn() {
        return updatedOn;
    }
}
