package com.microservice_user.controllers;

import com.microservice_user.business.UserBO;
import com.microservice_user.custom.exceptions.ResourceNotFoundException;
import com.microservice_user.data.transfer.objects.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class Controller {

    @Autowired
    private UserBO bo;

    @PostMapping(value = "/login")
    public UserDTO login(@RequestBody UserDTO user) throws ResourceNotFoundException {
        return bo.findByNameAndPassword(user);
    }

    @PostMapping(value = "/register")
    public void register(@RequestBody UserDTO user){
        bo.save(user);
    }
}
