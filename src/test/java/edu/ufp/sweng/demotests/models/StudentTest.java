package edu.ufp.sweng.demotests.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentTest {
    @Before
    public void setUp(){

    }

    @Test
    public void testAddCourse(){

        Degree degree1=new Degree("degree3");
        Degree degree2=new Degree("degree4");

        Course course1=new Course();
        Course course2=new Course();
        degree1.addCourse(course1);
        degree2.addCourse(course2);

        Student s1=new Student("12345",degree1);
        Student s2=new Student("33787",degree2);


        assertEquals(0,s1.getCourses().size());
        s1.addCourse(course1);
        assertEquals(1,s1.getCourses().size());
        s2.addCourse(course1);
        assertEquals(1,s1.getCourses().size());
    }
}