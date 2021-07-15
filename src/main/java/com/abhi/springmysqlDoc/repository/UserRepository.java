package com.abhi.springmysqlDoc.repository;

import com.abhi.springmysqlDoc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
