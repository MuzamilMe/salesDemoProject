package com.example.salesdemo.Transformer;

import com.example.salesdemo.DTO.UserDTO;
import com.example.salesdemo.entities.User;
import lombok.SneakyThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserTransformer {

    @SneakyThrows
    public static User toEntity(UserDTO dto) {
        User User = new User();
        if (dto.getId() != null) {
            User.setId(Long.valueOf(dto.getId()));
        }
        if(dto.getUsername()!=null){
            User.setUsername(dto.getUsername());
        }
        if(dto.getPassword()!=null) {
            User.setPassword(dto.getPassword());
        }
        if(dto.getToken()!=null) {
            User.setToken(dto.getToken());
        }
        return User;
    }

    public static List<User> toEntity(List<UserDTO> list) {
        List<User> list1 = new ArrayList<>();
        for (UserDTO dto : list) {
            list1.add(UserTransformer.toEntity(dto));
        }
        return list1;
    }

    public static UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        if (user.getId() != null) {
            dto.setId(String.valueOf(user.getId()));
        }
        if(user.getPassword()!=null){
            dto.setPassword(user.getPassword());
        }
        if(user.getUsername()!=null) {
            dto.setUsername(user.getUsername());
        }
         if(user.getToken()!=null) {
            dto.setToken(user.getToken());
        }

        return dto;
    }

    public static List<UserDTO> toDTO(List<User> list) {
        List<UserDTO> list1 = new ArrayList<>();
        for (User User : list) {
            list1.add(UserTransformer.toDTO(User));
        }
        return list1;
    }
}
