package com.deverzone.service.user;

import com.deverzone.dto.UserDTO;
import com.deverzone.model.user.Role;
import com.deverzone.model.user.User;
import com.deverzone.repository.UserRepository;
import com.deverzone.service.user.UserService;
import com.deverzone.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by fan.jin on 2016-10-15.
 */

@Service
public class UserServiceImpl implements UserService {
    
    public static final Logger log =  LoggerFactory.getLogger(UserServiceImpl.class);
    
    @Autowired
    private UserRepository userRepository;

    @Override
    @PreAuthorize("hasRole('USER')")
    public User findByUsername( String username ) throws UsernameNotFoundException {
        User u = userRepository.findByUsername( username );
        return u;
    }

    @PreAuthorize("hasRole('ADMIN')")
    public User findById( Long id ) throws AccessDeniedException {
        User u = userRepository.findOne( id );
        return u;
    }

    @PreAuthorize("hasRole('ADMIN')")
    public List<User> findAll() throws AccessDeniedException {
        List<User> result = userRepository.findAll();
        return result;
    }

    @Override
    public boolean createUser(UserDTO userDTO) throws Exception {
        try {
            User user = userDtoToUser(userDTO);
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean usernameCheck(String username) throws Exception {
        try {
            if(ObjectUtils.isEmpty(userRepository.findByUsername(username))){
                return true;
            }
        } catch (UsernameNotFoundException e) {
            log.error(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean emailCheck(String email) throws Exception {
        try {
            if(ObjectUtils.isEmpty(userRepository.findByEmail(email))){
                return true;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean phoneCheck(String phone) throws Exception {
        try {
            if(ObjectUtils.isEmpty(userRepository.findByPhone(phone))){
                return true;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return false;
    }

    @Override
    public void loggedInTimeUpdate(Long id) throws Exception {
        try {
            User user = userRepository.findOne(id);
            user.setLastlogin(new Date());
            userRepository.save(user);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        try {
            userRepository.delete(id);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean changePassword(Long id, String password) throws Exception {
        try {
            User user = findById(id);
            if(!ObjectUtils.isEmpty(user)){
                user.setPassword(new BCryptPasswordEncoder().encode(password));
                userRepository.save(user);
                return true;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(UserDTO userDTO) throws Exception {

        return false;
    }
    private User userDtoToUser(UserDTO userDTO)throws Exception {
        try {
            User user = userDTO.toUser();
            Role userRole = new Role();
            userRole.setName(Constants.ROLE_USER);
            List<Role> userAuthorities = new ArrayList<>();
            userAuthorities.add(userRole);
            user.setAuthorities(userAuthorities);
            return user;
        } catch (Exception e) {
            log.error("toUserRole: "+e);
            throw new Exception(e);
        }
    }

    @Override
    public boolean deleteAll() throws Exception {
        try {
            userRepository.deleteAll();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean createUserDTOList(List<UserDTO> userDTOs) throws Exception {
        List<User> userList = new ArrayList<>();
        try {
            for (UserDTO userDTO: userDTOs) {
                userList.add(userDtoToUser(userDTO));
            }
            userRepository.save(userList);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean createUserList(List<User> users) throws Exception {
        try {
            userRepository.save(users);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
