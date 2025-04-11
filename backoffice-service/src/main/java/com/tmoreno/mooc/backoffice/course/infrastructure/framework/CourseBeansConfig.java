package com.tmoreno.mooc.backoffice.course.infrastructure.framework;

import com.tmoreno.mooc.backoffice.course.application.create.CreateCourseUseCase;
import com.tmoreno.mooc.backoffice.course.application.create.ForCreateCourse;
import com.tmoreno.mooc.backoffice.course.domain.CourseRepository;
import com.tmoreno.mooc.backoffice.shared.EventBus;
import com.tmoreno.mooc.backoffice.shared.TransactionalService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourseBeansConfig {

    @Bean
    public ForCreateCourse forCreateCourse(CourseRepository repository, TransactionalService transactionalService, EventBus eventBus) {
        return new CreateCourseUseCase(repository, transactionalService, eventBus);
    }
}
