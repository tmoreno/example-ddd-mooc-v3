package com.tmoreno.mooc.backoffice.course.infrastructure.repositories;

import com.tmoreno.mooc.backoffice.course.domain.Course;
import com.tmoreno.mooc.backoffice.course.domain.CourseRepository;
import com.tmoreno.mooc.backoffice.course.domain.CourseTitle;
import org.springframework.stereotype.Repository;

@Repository
public class MySqlCourseRepository implements CourseRepository {

    @Override
    public boolean exists(CourseTitle title) {
        return false;
    }

    @Override
    public void save(Course course) {

    }
}
