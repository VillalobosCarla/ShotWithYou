package com.cmv.co.BE_ShotWithYou.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmv.co.BE_ShotWithYou.Model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
