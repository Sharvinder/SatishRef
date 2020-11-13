package com.springboot.app.dao;

import org.springframework.beans.factory.annotation.Autowired;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
