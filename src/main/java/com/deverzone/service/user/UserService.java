package com.deverzone.service.user;

import com.deverzone.webmodel.UserDTO;
import com.deverzone.domain.user.User;

import java.util.List;

/**
 * Created by fan.jin on 2016-10-15.
 */
public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll ();
    boolean createUser(UserDTO userDTO) throws Exception;
    boolean usernameCheck(String username) throws Exception;
    boolean emailCheck(String email) throws Exception;
    boolean phoneCheck(String phone) throws Exception;
    void loggedInTimeUpdate(Long id) throws Exception;
    boolean delete(Long id) throws Exception;
    boolean changePassword(Long id, String password) throws Exception;
    boolean update(UserDTO userDTO) throws Exception;

    boolean deleteAll() throws Exception;

    boolean createUserDTOList(List<UserDTO> userDTOs) throws Exception;

    boolean createUserList(List<User> users) throws Exception;
}
