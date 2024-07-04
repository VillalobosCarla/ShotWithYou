package com.cmv.co.BE_ShotWithYou.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmv.co.BE_ShotWithYou.Model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    Optional<Role> findByName(String name);
}
