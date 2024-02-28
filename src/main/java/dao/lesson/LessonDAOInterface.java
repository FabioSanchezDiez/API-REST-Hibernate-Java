package dao.lesson;

import models.Lesson;

public interface LessonDAOInterface {
    Lesson searchById(Long id);
}
