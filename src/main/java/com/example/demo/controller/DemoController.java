package com.example.demo.controller;

import com.example.demo.formobject.UserForm;
import com.example.demo.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by king on 2018/3/9.
 */

@RestController
@RequestMapping("/api/users")
public class DemoController {
    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getUsers() {
        return ResponseEntity.ok(demoService.getUsers());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable long id) {
        demoService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody UserForm userForm) {
        return ResponseEntity.ok(demoService.addUser(userForm));
    }

}
