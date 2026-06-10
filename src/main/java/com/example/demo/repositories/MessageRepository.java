
package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.example.demo.models.Chat;
import com.example.demo.models.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}