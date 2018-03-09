package com.example.demo.repository;


import com.example.demo.domain.Demo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by king on 2018/3/9.
 */
public interface DemoRepository extends JpaRepository<Demo,Long> {
}
