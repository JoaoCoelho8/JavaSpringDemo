package edu.ufp.sweng.demotests.repositories;

import edu.ufp.sweng.demotests.models.Course;
import edu.ufp.sweng.demotests.models.Degree;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class DegreeRepoUnitTest {
    Degree degree=new Degree("degree1");

    @Mock
    private DegreeRepo degreeRepo;

    @Before
    public void setup(){
        when(degreeRepo.findByName("degree1"))
                .thenReturn(Optional.of(degree));
    }

    @Test
    public void findByName(){
        assertEquals(degree,degreeRepo.findByName("degree1").get());
    }
}
