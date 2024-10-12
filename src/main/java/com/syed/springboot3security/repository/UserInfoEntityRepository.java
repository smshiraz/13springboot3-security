package com.syed.springboot3security.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.syed.springboot3security.entity.UserInfoEntity;

import java.util.Optional;

public interface UserInfoEntityRepository extends JpaRepository<UserInfoEntity, Integer> {
    Optional<UserInfoEntity> findByName(String username);

}