package dao;

import dao.course.CourseDAO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseDAOTest {

    @Test
    void returnNumberOfCoursesTest(){
        long expected = 49;
        long real = new CourseDAO().returnNumberOfCourses();

        assertEquals(expected,real);
    }

}