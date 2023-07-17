package com.in28minutes.springboot.learnjpaandhibernate.course.jpa;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
// transactional : jpa 실행할때 필요한 트랜잭션.
@Transactional
public class CourseJpaRepository {

    @PersistenceContext
    // EntityManeger :: JPA ㅇㅔ서 데이터베이스연결하는 방법
    private EntityManager entityManager;

    public void insert(Course course){
        // entitymager 에서  행을 삽입하는 메서드: merge
        entityManager.merge(course);
    }

    public Course findById(long id){
        return entityManager.find(Course.class, id);
    }

    public void deleteById(long id){
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}
