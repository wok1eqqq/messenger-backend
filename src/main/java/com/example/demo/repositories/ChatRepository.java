
package com.example.demo.repositories;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Chat;
 
public interface ChatRepository extends  JpaRepository<Chat, Integer> {
    
}