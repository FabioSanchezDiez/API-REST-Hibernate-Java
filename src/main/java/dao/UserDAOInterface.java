package dao;

import dto.UserDTO;
import models.User;

public interface UserDAOInterface {
    User searchByEmail(String email);
    User confirmAccount(String token);

    User createUser(User user);
    User returnAuthenticatedUser(UserDTO userDTO);
}
