package com.tmoreno.mooc.backoffice.course.domain;

import com.tmoreno.mooc.backoffice.shared.domain.DurationInSeconds;
import com.tmoreno.mooc.backoffice.shared.domain.Entity;

public final class Lesson extends Entity<LessonId> {

    private LessonTitle title;
    private DurationInSeconds duration;

    private Lesson(LessonId id, LessonTitle title, DurationInSeconds duration) {
        super(id);
        this.title = title;
        this.duration = duration;
    }

    public static Lesson create(String title, int durationInSeconds) {
        return new Lesson(
            new LessonId(),
            new LessonTitle(title),
            new DurationInSeconds(durationInSeconds)
        );
    }

    public String getTitle() {
        return title.value();
    }

    public int getDuration() {
        return duration.value();
    }
}
