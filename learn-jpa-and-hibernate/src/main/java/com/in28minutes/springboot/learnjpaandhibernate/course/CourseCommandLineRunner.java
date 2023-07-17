package com.in28minutes.springboot.learnjpaandhibernate.course;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import com.in28minutes.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// 시작할때 INSERT_QUERY  시작하게
@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn insert JPA!", "chris"));
        repository.save(new Course(2, "Learn Azure JPA!", "chris2"));
        repository.save(new Course(3, "Learn DevOps JPA!", "chris3"));

        repository.deleteById(3l);
        System.out.println(repository.findById(2l));
        System.out.println(repository.findById(1l));
        System.out.println(repository.findAll());

        repository.count();

        System.out.println(repository.findByAuthor("chris"));
        System.out.println(repository.findByAuthor(""));
        System.out.println(repository.findByName("Learn insert JPA!"));
        System.out.println(repository.findByName("Learn Azure JPA!"));
    }
}
