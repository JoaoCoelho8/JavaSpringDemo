package edu.ufp.sweng.demotests.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ufp.sweng.demotests.DemoTestsApplication;
import edu.ufp.sweng.demotests.models.Course;
import edu.ufp.sweng.demotests.models.Degree;
import edu.ufp.sweng.demotests.services.CourseService;
import edu.ufp.sweng.demotests.services.CourseServiceI;
import edu.ufp.sweng.demotests.services.DegreeServiceI;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class DegreeControllerUnitTest {

    private MockMvc mockMvc;

    @Mock
    private DegreeServiceI createClientServiceMock;

    @InjectMocks
    private DegreeController degreeController;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(degreeController).build();
    }

    @Test
    public void testCreateClientSuccessfully() throws Exception {

        Degree degree = new Degree("degree1");
        Degree expectedDegree = new Degree("degree1");
        expectedDegree.addCourse(new Course("course1"));
        //??given(createClientServiceMock.save(degree).willReturn(Optional.of(expectedDegree)));

        mockMvc.perform(post("/degree/course1")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsBytes(degree)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("degree1"))
                .andExpect(jsonPath("$.courseName").value("course1"));
    }
}
