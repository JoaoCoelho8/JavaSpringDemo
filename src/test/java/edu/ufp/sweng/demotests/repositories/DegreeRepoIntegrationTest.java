package edu.ufp.sweng.demotests.repositories;

import edu.ufp.sweng.demotests.models.Degree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DegreeRepoIntegrationTest {

    @Autowired
    private DegreeRepo degreeRepo;

    @Test
    public void crud() {
        Degree degree=new Degree("degree1");

        assertEquals(0,degreeRepo.count());

        degreeRepo.save(degree);
        assertEquals(1,degreeRepo.count());

    }
}