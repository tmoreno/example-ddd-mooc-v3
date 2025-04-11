package com.tmoreno.mooc.backoffice.course.infrastructure.controllers;

import com.tmoreno.mooc.backoffice.course.application.create.CreateCourseParams;
import com.tmoreno.mooc.backoffice.course.application.create.CreateCourseResponse;
import com.tmoreno.mooc.backoffice.course.application.create.ForCreateCourse;
import com.tmoreno.mooc.backoffice.course.infrastructure.controllers.entities.CreateCourseRequestBody;
import com.tmoreno.mooc.backoffice.course.infrastructure.controllers.entities.CreateCourseResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostCourseController {

    private final ForCreateCourse forCreateCourse;
    private final CourseMapper courseMapper;

    public PostCourseController(ForCreateCourse forCreateCourse, CourseMapper courseMapper) {
        this.forCreateCourse = forCreateCourse;
        this.courseMapper = courseMapper;
    }

    @PostMapping(value = "/courses")
    public ResponseEntity<CreateCourseResponseBody> handle(@RequestBody CreateCourseRequestBody requestBody) {
        CreateCourseParams createCourseParams = courseMapper.toCreateCourseParams(requestBody);

        CreateCourseResponse createCourseResponse = forCreateCourse.create(createCourseParams);

        CreateCourseResponseBody createCourseResponseBody = courseMapper.toCreateCourseResponseBody(createCourseResponse);

        return new ResponseEntity<>(createCourseResponseBody, HttpStatus.CREATED);
    }
}
