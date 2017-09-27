package com.deverzone.repository;

import com.deverzone.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by gavin on 2017. 8. 23..
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername( String username );
    User findByEmail( String email);
    User findByPhone( String phone);
}

