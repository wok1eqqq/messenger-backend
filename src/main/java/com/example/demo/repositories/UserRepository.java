
package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Message;
import com.example.demo.models.User;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByUserName(String userName);
}