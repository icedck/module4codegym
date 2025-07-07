package com.codegym.repository;

import com.codegym.model.Role;
import com.codegym.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
