package io.motolola.mvctest.controller;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Akinjide Motolola.
 * email: motolola@icloud.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class GreetingControllerTest
{

    private MockMvc mockMvc;

    @InjectMocks
    private GreetingController greetingController;

    @Before
    public void setUp() throws Exception
    {
        mockMvc = MockMvcBuilders.standaloneSetup(greetingController)
                .build();
    }

    @Test
    public void hello() throws Exception
    {
        mockMvc.perform(get("/api/hello"))
        .andExpect(status().isOk())
        .andExpect(content().string("Hello World"));
    }

    @Test
    public void getPerson() throws Exception
    {
        mockMvc.perform(get("/api/person").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",Matchers.is("Mike")));

    }
}