package com.tmoreno.mooc.backoffice.course.infrastructure.controllers;

import com.tmoreno.mooc.backoffice.course.application.create.CreateCourseParams;
import com.tmoreno.mooc.backoffice.course.application.create.CreateCourseResponse;
import com.tmoreno.mooc.backoffice.course.application.create.CreateLessonParams;
import com.tmoreno.mooc.backoffice.course.application.create.CreateLessonResponse;
import com.tmoreno.mooc.backoffice.course.application.create.CreateModuleParams;
import com.tmoreno.mooc.backoffice.course.application.create.CreateModuleResponse;
import com.tmoreno.mooc.backoffice.course.infrastructure.controllers.entities.CreateCourseRequestBody;
import com.tmoreno.mooc.backoffice.course.infrastructure.controllers.entities.CreateCourseResponseBody;
import com.tmoreno.mooc.backoffice.course.infrastructure.controllers.entities.CreateLessonRequestBody;
import com.tmoreno.mooc.backoffice.course.infrastructure.controllers.entities.CreateLessonResponseBody;
import com.tmoreno.mooc.backoffice.course.infrastructure.controllers.entities.CreateModuleRequestBody;
import com.tmoreno.mooc.backoffice.course.infrastructure.controllers.entities.CreateModuleResponseBody;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CourseMapper {

    CreateCourseParams toCreateCourseParams(CreateCourseRequestBody requestBody);
    CreateModuleParams toCreateModuleParams(CreateModuleRequestBody requestBody);
    CreateLessonParams toCreateLessonParams(CreateLessonRequestBody requestBody);

    CreateCourseResponseBody toCreateCourseResponseBody(CreateCourseResponse response);
    CreateModuleResponseBody toCreateModuleResponseBody(CreateModuleResponse response);
    CreateLessonResponseBody toCreateLessonResponseBody(CreateLessonResponse response);

}
