package com.tmoreno.mooc.backoffice.course.domain;

import com.tmoreno.mooc.backoffice.shared.domain.AggregateRoot;
import com.tmoreno.mooc.backoffice.shared.domain.Identifier;
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

    public static Course create(
        String title,
        String imageUrl,
        String description,
        String language,
        Double priceValue,
        String priceCurrency,
        List<Module> modules,
        Set<String> teachers
    ) {
        Instant now = Instant.now();

        return new Course(
            new CourseId(),
            new CourseTitle(title),
            imageUrl == null ? null : new CourseImageUrl(imageUrl),
            description == null ? null : new CourseDescription(description),
            CourseState.DRAFT,
            language == null ? null : Language.valueOf(language),
            priceValue == null || priceCurrency == null ? null : new Price(priceValue, Currency.getInstance(priceCurrency)),
            modules == null ? Map.of() : modules.stream().collect(Collectors.toMap(module -> new ModuleId(module.getId()), module -> module)),
            teachers == null ? Set.of() : teachers.stream().map(TeacherId::new).collect(Collectors.toSet()),
            now,
            now
        );
    }

    public String getTitle() {
        return title.value();
    }

    public Optional<String> getImageUrl() {
        return Optional.ofNullable(imageUrl).map(CourseImageUrl::value);
    }

    public Optional<String> getDescription() {
        return Optional.ofNullable(description).map(CourseDescription::value);
    }

    public String getState() {
        return state.name();
    }

    public Optional<String> getLanguage() {
        return Optional.ofNullable(language).map(Enum::name);
    }

    public Optional<Price> getPrice() {
        return Optional.ofNullable(price);
    }

    public List<Module> getModules() {
        return List.copyOf(modules.values());
    }

    public Set<String> getTeachers() {
        return teachers.stream().map(Identifier::getValue).collect(Collectors.toSet());
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public Instant getUpdatedOn() {
        return updatedOn;
    }
}
