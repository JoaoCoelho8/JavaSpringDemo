package edu.ufp.sweng.demotests.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DegreeTest {
    @Before
    public void setUp(){

    }

    @Test
    public void testAddStudent(){

        Degree degree1=new Degree("degree3");
        Degree degree2=new Degree("degree4");

        Student s1=new Student("12345",degree1);
        Student s2=new Student("33787",degree2);


        assertEquals(1,degree1.getStudents().size());
        degree1.addStudent(s2);
        assertEquals(2,degree1.getStudents().size());
        degree1.addStudent(s1);
        assertEquals(2,degree1.getStudents().size());

    }

    @Test
    public void testAddCourse(){

        Degree degree1=new Degree("degree6");
        Degree degree2=new Degree("degree7");

        Course course1=new Course("c1");
        Course course2=new Course("c2");

        assertEquals(0,degree1.getCourses().size());
        degree1.addCourse(course1);
        assertEquals(1,degree1.getCourses().size());
        degree1.addCourse(course2);
        assertEquals(2,degree1.getCourses().size());
    }
}