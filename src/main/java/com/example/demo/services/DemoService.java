package com.example.demo.services;

import com.example.demo.domain.Demo;
import com.example.demo.formobject.UserForm;
import com.example.demo.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by king on 2018/3/9.
 */

@Service
public class DemoService {

    @Autowired
    private DemoRepository demoRepository;

    public List<Demo> getUsers() {
        return demoRepository.findAll();
    }

    public void deleteUserById(long id) {
        demoRepository.deleteById(id);
    }

    public Demo  addUser(UserForm userForm) {
        Demo demo = new Demo();
        demo.setUserName(userForm.getName());
        demo.setPassword(userForm.getPassword());
        return  demoRepository.save(demo);
    }
}
