package edu.ufp.sweng.demotests.repositories;

import edu.ufp.sweng.demotests.models.Degree;
import edu.ufp.sweng.demotests.models.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepoIntegrationTest {

    @Autowired
    private StudentRepo studentRepo;

    @Test
    public void crud() {
        Student student=new Student("12345", new Degree("degree"));

        assertEquals(0,studentRepo.count());
        studentRepo.save(student);
       // assertEquals(1,studentRepo.count()); ??

    }
}