package com.in28minutes.springboot.learnspringboot;

public class Course {
    private Integer id;
    private String name;
    private String Author;
     //Constructor


    public Course(Integer id, String name, String author) {
        super();
        this.id = id;
        this.name = name;
        Author = author;
    }

    //Getters
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return Author;
    }

    // toString emthod
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Author='" + Author + '\'' +
                '}';
    }
}
