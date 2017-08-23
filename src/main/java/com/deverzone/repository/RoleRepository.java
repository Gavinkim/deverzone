package com.deverzone.repository;

import com.deverzone.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by GavinKim on 2017. 8. 23..
 */
public interface RoleRepository extends JpaRepository<Role,Long>{
}
