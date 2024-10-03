package com.example.salesdemo.Controller;

import com.example.salesdemo.Commons.ExceptionHandler.UserException;
import com.example.salesdemo.Commons.utils.ResponseUtil;
import com.example.salesdemo.DTO.UserDTO;
import com.example.salesdemo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping(value = "/create")
    public ResponseEntity<Object> add(@ModelAttribute UserDTO dto) throws UserException {
        return ResponseUtil.returnResponse(service.Create(dto));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) throws UserException {
        return service.delete(id);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Object> update(@ModelAttribute UserDTO dto) throws UserException {
        return service.update(dto);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) throws UserException {
        return service.findById(id);
    }
    @PostMapping("/getByUAP")
    public ResponseEntity<Object> findByUsernameAndPassword(@ModelAttribute UserDTO userDTO) throws UserException {
        return service.findByUsernameAndPassword(userDTO);
    }

}
