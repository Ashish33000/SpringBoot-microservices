package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.User;

public interface UserRepoaitory extends JpaRepository<User, String> {

}
