package com.jevin.eirlsmmapi.repository;


import com.jevin.eirlsmmapi.model.Role;
import com.jevin.eirlsmmapi.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(RoleName name);
}
