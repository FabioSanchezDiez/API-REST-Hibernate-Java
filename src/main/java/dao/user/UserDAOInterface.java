package dao.user;

import dto.UserDTO;
import models.User;

public interface UserDAOInterface {
    User searchById(Long id);
    User searchByEmail(String email);
    User confirmAccount(String token);
    User createUser(User user);
    User updateUser(User user);
    User deleteById(Long id);
    User returnAuthenticatedUser(UserDTO userDTO);
}
