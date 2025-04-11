package com.tmoreno.mooc.backoffice.course.create;

import com.tmoreno.mooc.backoffice.course.domain.Course;
import com.tmoreno.mooc.backoffice.course.domain.CourseDescription;
import com.tmoreno.mooc.backoffice.course.domain.CourseImageUrl;
import com.tmoreno.mooc.backoffice.course.domain.CourseRepository;
import com.tmoreno.mooc.backoffice.course.domain.CourseTitle;
import com.tmoreno.mooc.backoffice.course.domain.Lesson;
import com.tmoreno.mooc.backoffice.course.domain.Module;
import com.tmoreno.mooc.backoffice.course.domain.exceptions.CourseExistsException;
import com.tmoreno.mooc.backoffice.shared.events.EventBus;
import com.tmoreno.mooc.backoffice.shared.domain.Identifier;
import com.tmoreno.mooc.backoffice.shared.domain.Language;
import com.tmoreno.mooc.backoffice.shared.domain.Price;

import java.util.function.Function;

public final class CreateCourseUseCase implements ForCreateCourse {

    private final CourseRepository repository;
    private final EventBus eventBus;

    public CreateCourseUseCase(CourseRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    @Override
    public CreateCourseResponse create(CreateCourseParams params) {
        CourseTitle title = new CourseTitle(params.title());

        if (repository.exists(title)) {
            throw new CourseExistsException(title);
        }

        Course course = Course.create(params);

        repository.save(course);

        eventBus.publish(course.pullEvents());

        return toCreateCourseResponse(course);
    }

    private static CreateCourseResponse toCreateCourseResponse(Course course) {
        return new CreateCourseResponse(
            course.getId().toString(),
            course.getTitle().toString(),
            course.getImageUrl().map(CourseImageUrl::value).orElse(null),
            course.getDescription().map(CourseDescription::value).orElse(null),
            course.getLanguage().map(Language::name).orElse(null),
            course.getPrice().map(Price::value).orElse(null),
            course.getPrice().map(p -> p.currency().getCurrencyCode()).orElse(null),
            course.getModules().stream().map(toCreateModuleResponse()).toList(),
            course.getTeachers().stream().map(Identifier::getValue).toList(),
            course.getCreatedOn()
        );
    }

    private static Function<Module, CreateModuleResponse> toCreateModuleResponse() {
        return module -> new CreateModuleResponse(
            module.getId().getValue(),
            module.getTitle().value(),
            module.getLessons().stream().map(toCreateLessonResponse()).toList()
        );
    }

    private static Function<Lesson, CreateLessonResponse> toCreateLessonResponse() {
        return lesson -> new CreateLessonResponse(
            lesson.getId().getValue(),
            lesson.getTitle().value(),
            lesson.getDuration().value()
        );
    }
}
