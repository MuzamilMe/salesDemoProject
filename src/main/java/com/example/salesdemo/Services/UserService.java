package com.example.salesdemo.Services;

import com.example.salesdemo.Commons.ExceptionHandler.UserException;
import com.example.salesdemo.DTO.UserDTO;
import com.example.salesdemo.entities.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<Object> Create(UserDTO user) throws UserException;

    ResponseEntity<Object> delete(Long id) throws UserException;

    ResponseEntity<Object> update(UserDTO dto) throws UserException;

    ResponseEntity<Object> findAll();
    ResponseEntity<Object> findById(Long id) throws UserException;

    ResponseEntity<Object> findByUsernameAndPassword(UserDTO userDTO) throws UserException;

}
