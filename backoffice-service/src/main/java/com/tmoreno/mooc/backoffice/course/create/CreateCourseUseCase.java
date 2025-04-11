package com.tmoreno.mooc.backoffice.course.create;

import com.tmoreno.mooc.backoffice.course.domain.Course;
import com.tmoreno.mooc.backoffice.course.domain.CourseRepository;
import com.tmoreno.mooc.backoffice.course.domain.CourseTitle;
import com.tmoreno.mooc.backoffice.course.domain.Lesson;
import com.tmoreno.mooc.backoffice.course.domain.Module;
import com.tmoreno.mooc.backoffice.course.domain.exceptions.CourseExistsException;
import com.tmoreno.mooc.backoffice.shared.events.EventBus;
import com.tmoreno.mooc.backoffice.shared.domain.Price;
import com.tmoreno.mooc.backoffice.shared.services.TransactionalService;

import java.util.List;
import java.util.function.Function;

public final class CreateCourseUseCase implements ForCreateCourse {

    private final CourseRepository repository;
    private final TransactionalService transactionalService;
    private final EventBus eventBus;

    public CreateCourseUseCase(CourseRepository repository, TransactionalService transactionalService, EventBus eventBus) {
        this.repository = repository;
        this.transactionalService = transactionalService;
        this.eventBus = eventBus;
    }

    @Override
    public CreateCourseResponse create(CreateCourseParams params) {
        return transactionalService.execute(() -> {
            CourseTitle title = new CourseTitle(params.title());

            if (repository.exists(title)) {
                throw new CourseExistsException(title);
            }

            Course course = createCourse(params);

            repository.save(course);

            eventBus.publish(course.pullEvents());

            return toCreateCourseResponse(course);
        });
    }

    private static Course createCourse(CreateCourseParams params) {
        return Course.create(
            params.title(),
            params.imageUrl(),
            params.description(),
            params.language(),
            params.priceValue(),
            params.priceCurrency(),
            createModules(params.modules()),
            params.teachers()
        );
    }

    private static List<Module> createModules(List<CreateModuleParams> modules) {
        return modules == null
            ? List.of()
            : modules.stream().map(m -> Module.create(m.title(), createLessons(m.lessons()))).toList();
    }

    private static List<Lesson> createLessons(List<CreateLessonParams> lessons) {
        return lessons == null
            ? List.of()
            : lessons.stream().map(l -> Lesson.create(l.title(), l.durationInSeconds())).toList();
    }

    private static CreateCourseResponse toCreateCourseResponse(Course course) {
        return new CreateCourseResponse(
            course.getId(),
            course.getTitle(),
            course.getImageUrl().orElse(null),
            course.getDescription().orElse(null),
            course.getLanguage().orElse(null),
            course.getPrice().map(Price::value).orElse(null),
            course.getPrice().map(p -> p.currency().getCurrencyCode()).orElse(null),
            course.getModules().stream().map(toCreateModuleResponse()).toList(),
            course.getTeachers(),
            course.getCreatedOn()
        );
    }

    private static Function<Module, CreateModuleResponse> toCreateModuleResponse() {
        return module -> new CreateModuleResponse(
            module.getId(),
            module.getTitle(),
            module.getLessons().stream().map(toCreateLessonResponse()).toList()
        );
    }

    private static Function<Lesson, CreateLessonResponse> toCreateLessonResponse() {
        return lesson -> new CreateLessonResponse(
            lesson.getId(),
            lesson.getTitle(),
            lesson.getDuration()
        );
    }
}
