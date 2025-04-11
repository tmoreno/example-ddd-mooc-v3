package com.tmoreno.mooc.backoffice.course.domain;

import com.tmoreno.mooc.backoffice.course.create.CreateModuleParams;
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

    public static Module create(CreateModuleParams params) {
        List<Lesson> lessons = params.lessons().stream().map(Lesson::create).toList();

        return new Module(
            new ModuleId(),
            new ModuleTitle(params.title()),
            lessons
        );
    }

    public ModuleTitle getTitle() {
        return title;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }
}
