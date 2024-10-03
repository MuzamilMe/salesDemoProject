package com.example.salesdemo.ServiceImpl;

import com.example.salesdemo.Commons.ExceptionHandler.UserException;
import com.example.salesdemo.Commons.utils.ResponseUtil;
import com.example.salesdemo.Commons.utils.StatusDto;
import com.example.salesdemo.Commons.utils.StatusEnum;
import com.example.salesdemo.DTO.UserDTO;
import com.example.salesdemo.Repository.UserRepository;
import com.example.salesdemo.Services.UserService;
import com.example.salesdemo.Transformer.UserTransformer;
import com.example.salesdemo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<Object> Create(UserDTO user) throws UserException {
        User userEntity = new User();
        if (user == null) {
            throw new UserException("Missing params");
        }
         userEntity = UserTransformer.toEntity(user);

        return ResponseUtil.returnResponse(new StatusDto(StatusEnum.SUCCESS,"User successfully added", UserTransformer.toDTO(userRepository.save(userEntity))));
    }

    @Override
    public ResponseEntity<Object> delete(Long id) throws UserException {
        if (id == null) {
            throw new UserException("Missing params");
        }
        User userEntity = userRepository.findById(id).orElseThrow(() -> new UserException("not found"));
        userRepository.delete(userEntity);
        return ResponseUtil.returnResponse(new StatusDto(StatusEnum.SUCCESS,"Delete Success",null));
    }

    @Override
    public ResponseEntity<Object> update(UserDTO dto) throws UserException {
        return null;
    }

    @Override
    public ResponseEntity<Object> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<Object> findById(Long id) throws UserException {
        if (id == null) {
            throw new UserException("Missing params");
        }
        User userEntity = userRepository.findById(id).orElseThrow(() -> new UserException("not found"));
        return ResponseUtil.returnResponse(new StatusDto(StatusEnum.SUCCESS,"success",userEntity));
    }

    @Override
    public ResponseEntity<Object> findByUsernameAndPassword(UserDTO userDTO) throws UserException {
        if (userDTO == null) {
            throw new UserException("Missing params");
        }
        User userEntity = userRepository.findByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword()).orElseThrow(()->new UserException("User does not exist"));
        return ResponseUtil.returnResponse(new StatusDto(StatusEnum.SUCCESS,"success",userEntity));
    }
}
