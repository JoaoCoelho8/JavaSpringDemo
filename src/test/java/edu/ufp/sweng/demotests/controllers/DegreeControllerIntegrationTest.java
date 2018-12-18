package edu.ufp.sweng.demotests.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ufp.sweng.demotests.DemoTestsApplication;
import edu.ufp.sweng.demotests.models.Course;
import edu.ufp.sweng.demotests.models.Degree;
import edu.ufp.sweng.demotests.services.CourseServiceI;
import edu.ufp.sweng.demotests.services.DegreeServiceI;
import edu.ufp.sweng.demotests.services.filters.FilterObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;

import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoTestsApplication.class)
@AutoConfigureMockMvc
@Transactional
public class DegreeControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private DegreeServiceI degreeServiceI;


    @Autowired
    ObjectMapper mapper;

    @Before
    public void setUp() {

        Degree degree = new Degree("degree1");
        degreeServiceI.save(degree);
    }

    @Test
    public void getDegrees() throws Exception {
        Set<Degree> degrees = degreeServiceI.getRepoDegrees();
        mvc.perform(get("/degree").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.content().json(mapper.writeValueAsString(degrees)))
                .andReturn();
    }


    @Test
    public void getDegreeByName() throws Exception {
        Degree degree = degreeServiceI.getDegreeByName("degree1").get();
        mvc.perform(get("/degree/degree1").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(degree.getName()))
                .andReturn();
    }
}

