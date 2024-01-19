package dao;

import dto.CourseDTO;
import models.Course;

import java.util.List;
import java.util.Map;

public interface CourseDAOInterface {
    List<Course> returnAllCourses();
    List<Course> returnAllCourses(int page, int objects);
    List<Course> returnCoursesLike(String search);
    List<Course> returnCoursesIn(List<String> categories);
    List<Map<String, Double>> returnUsersAverage();
    List<CourseDTO> returnSummaryPopularCourses(Integer condition);
    Course searchById(Long id);
    Course createCourse(Course course);
    Course updateCourse(Course course);
    Course deleteById(Long id);
    long returnNumberOfCourses();

}
