package com.deverzone.v02;

import com.deverzone.Application;
import com.deverzone.dto.UserDTO;
import com.deverzone.service.user.UserService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by gs on 2017. 8. 23..
 */
@RunWith( SpringRunner.class )
@SpringBootTest(classes = { Application.class })
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    @Ignore
    public void createUserTest() throws Exception{
        UserDTO userDTO = new UserDTO("gavin2017","Gavin","gavin2017","dreamworld612@gmail.com","010-1234-5678");
        userService.createUser(userDTO);
    }
}
