package edu.ufp.sweng.demotests.services;

import edu.ufp.sweng.demotests.models.Course;
import edu.ufp.sweng.demotests.models.Degree;
import edu.ufp.sweng.demotests.models.Student;
import edu.ufp.sweng.demotests.repositories.CourseRepo;
import edu.ufp.sweng.demotests.repositories.DegreeRepo;
import edu.ufp.sweng.demotests.repositories.StudentRepo;
import edu.ufp.sweng.demotests.services.filters.coursefilter.CourseFilterService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepo studentRepo;


    @Mock
    private DegreeRepo degreeRepo;

    private Set<Student> students1=new HashSet<>();
    private Set<Student> students2=new HashSet<>();

    @Before
    public void setUp() {
        students1.add(new Student("111", new Degree("degree1")));
        students1.add(new Student("222", new Degree("degree1")));
        students1.add(new Student("333", new Degree("degree1")));

        students2.add(new Student("333", new Degree("degree1")));
        when(studentRepo.findAll())
                .thenReturn(students1);
    }

    @Test
    public void crud() {
        assertEquals(3,studentService.findAll().size());
        Mockito.verify(studentRepo, Mockito.times(1)).findAll();
        assertEquals(3, studentService.findAll().size()); //não ha filtered como em course
        Mockito.verify(studentRepo,Mockito.times(0)).findByStudentNumber(Mockito.anyString());
        Mockito.verify(studentRepo,Mockito.times(2)).findAll();
    }
}