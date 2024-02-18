package dao;

import models.User;

public interface UserDAOInterface {
    User searchById(Long id);
    User createUser(User user);
}
