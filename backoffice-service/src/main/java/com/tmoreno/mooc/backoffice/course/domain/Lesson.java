package com.tmoreno.mooc.backoffice.course.domain;

import com.tmoreno.mooc.backoffice.course.create.CreateLessonParams;
import com.tmoreno.mooc.backoffice.shared.domain.DurationInSeconds;
import com.tmoreno.mooc.backoffice.shared.domain.Entity;

import java.util.Map;

public final class Lesson extends Entity<LessonId> {

    private LessonTitle title;
    private DurationInSeconds duration;

    private Lesson(LessonId id, LessonTitle title, DurationInSeconds duration) {
        super(id);
        this.title = title;
        this.duration = duration;
    }

    public static Lesson create(CreateLessonParams params) {
        return new Lesson(
            new LessonId(),
            new LessonTitle(params.title()),
            new DurationInSeconds(params.durationInSeconds())
        );
    }

    public LessonTitle getTitle() {
        return title;
    }

    public DurationInSeconds getDuration() {
        return duration;
    }
}
