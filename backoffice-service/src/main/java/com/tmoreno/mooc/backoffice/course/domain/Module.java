package com.tmoreno.mooc.backoffice.course.domain;

import com.tmoreno.mooc.backoffice.shared.domain.Entity;

import java.util.ArrayList;
import java.util.List;

public final class Module extends Entity<ModuleId> {

    private ModuleTitle title;
    private final List<Lesson> lessons;

    private Module(ModuleId id, ModuleTitle title, List<Lesson> lessons) {
        super(id);
        this.title = title;
        this.lessons = new ArrayList<>(lessons);
    }

    public static Module create(String title, List<Lesson> lessons) {
        return new Module(
            new ModuleId(),
            new ModuleTitle(title),
            lessons
        );
    }

    public String getTitle() {
        return title.value();
    }

    public List<Lesson> getLessons() {
        return lessons;
    }
}
