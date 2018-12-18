package edu.ufp.sweng.demotests.repositories;

import edu.ufp.sweng.demotests.models.Course;
import edu.ufp.sweng.demotests.models.Degree;
import edu.ufp.sweng.demotests.models.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class StudentRepoUnitTest {
    Student student=new Student("12345", new Degree("degree1"));

    @Mock
    private StudentRepo studentRepo;


    @Before
    public void setup(){
        when(studentRepo.findByStudentNumber("12345"))
                .thenReturn(Optional.of(student));
    }

    @Test
    public void findByName(){
        assertEquals(student,studentRepo.findByStudentNumber("12345").get());
    }
}
