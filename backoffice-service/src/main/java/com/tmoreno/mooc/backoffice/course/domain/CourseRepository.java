package com.tmoreno.mooc.backoffice.course.domain;

public interface CourseRepository {

    boolean exists(CourseTitle title);
    void save(Course course);

}
