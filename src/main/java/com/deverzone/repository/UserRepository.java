package com.deverzone.repository;

import com.deverzone.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fan.jin on 2016-10-15.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername( String username );
    User findByEmail( String email);
    User findByPhone( String phone);
}

