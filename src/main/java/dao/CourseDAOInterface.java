package dao;

import models.Course;

import java.util.List;

public interface CourseDAOInterface {
    public List<Course> returnAllCourses();
    public List<Course> returnAllCourses(int page, int objects);
    public long returnNumberOfCourses();

}
