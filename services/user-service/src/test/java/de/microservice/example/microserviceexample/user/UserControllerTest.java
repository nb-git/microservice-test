package de.microservice.example.microserviceexample.user;

import de.microservice.example.microserviceexample.util.TestUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyLong;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    UserRepository userRepository;

    @Test
    public void testGetList() throws Exception {
        // given
        List<User> expectedResult = singletonList(createUser());
        given(this.userRepository.findAll()).willReturn(expectedResult);

        // when - then
        mvc.perform(get("/user/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is(expectedResult.get(0).getName())))
                .andExpect(jsonPath("$[0].birthday", is(expectedResult.get(0).getBirthday().toString())));
    }

    @Test
    public void testGetUser() throws Exception {
        // given
        User expectedResult = createUser();
        given(this.userRepository.findOne(anyLong())).willReturn(expectedResult);

        // when - then
        mvc.perform(get("/user/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is(expectedResult.getName())))
                .andExpect(jsonPath("$.birthday", is(expectedResult.getBirthday().toString())));
    }

    @Test
    public void testCreateNewUser() throws Exception {
        // given
        User expectedResult = createUser();
        given(this.userRepository.save(expectedResult)).willReturn(expectedResult);

        // when - then
        mvc.perform(post("/user")
                .contentType(APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(expectedResult)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is(expectedResult.getName())))
                .andExpect(jsonPath("$.birthday", is(expectedResult.getBirthday().toString())));
    }


    private User createUser() {
        return new User(1L, "Testuser", "Test", "Test", "test@test.de", LocalDate.of(1989, 2, 3));
    }
}