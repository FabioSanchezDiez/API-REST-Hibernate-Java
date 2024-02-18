package dao;

import models.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AssociationsDAOTest {
    private AssociationsDAOInterface instance = new AssociationsDAO();
    private CourseDAOInterface coursesDAO = new CourseDAO();

    @Test
    void returnUsersWithCourse() {
        List<User> expected = new ArrayList<>(List.of(new User(1L, "John Doe", "john.doe@example.com", "password123", false, true, "token123"), new User(2L, "Admin User", "admin@example.com", "adminpassword", true, true, "admintoken456")));
        List<User> real = instance.returnUsersWithCourse(coursesDAO.searchById(10L));
        assertEquals(expected, real);
    }
}