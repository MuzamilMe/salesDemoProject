package com.example.salesdemo.Repository;

import com.example.salesdemo.DTO.UserDTO;
import com.example.salesdemo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
User findByToken(String token);

Optional<User> findByUsernameAndPassword(String username, String password);

}
