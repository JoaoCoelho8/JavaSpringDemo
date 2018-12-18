package edu.ufp.sweng.demotests.services;

import edu.ufp.sweng.demotests.models.Course;
import edu.ufp.sweng.demotests.models.Degree;
import edu.ufp.sweng.demotests.repositories.CourseRepo;
import edu.ufp.sweng.demotests.repositories.DegreeRepo;
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
public class DegreeServiceTest {

    @InjectMocks
    private DegreeService degreeService;

    @Mock
    private DegreeRepo degreeRepo;


    private Set<Degree> degrees1=new HashSet<>();
    private Set<Degree> degrees2=new HashSet<>();

    @Before
    public void setUp() {
        degrees1.add(new Degree("degree1"));
        degrees1.add(new Degree("degree2"));
        degrees1.add(new Degree("degree3"));

        degrees2.add(new Degree("degree3"));
        when(degreeRepo.findAll())
                .thenReturn(degrees1);
    }

    @Test
    public void crud() {
        assertEquals(3,degreeService.getDegrees().size());
        Mockito.verify(degreeRepo, Mockito.times(1)).findAll();
        assertEquals(3, degreeService.getRepoDegrees().size()); //não ha filtered como em course
        Mockito.verify(degreeRepo,Mockito.times(0)).findByName(Mockito.anyString());
        Mockito.verify(degreeRepo,Mockito.times(2)).findAll();
    }
}