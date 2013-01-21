package org.codestory.controller;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.setup.ContextMockMvcBuilder;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;


public class WelcomeControllerTest {

    protected static MockMvc mockMvc;
    private static AnnotationConfigWebApplicationContext context;


    @BeforeClass
    public static void setup() {
        context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("org.codestory");

        mockMvc = new ContextMockMvcBuilder(context).configureWebAppRootDir("/", false).build();

    }

    @Test
    public void should_answer_first_question() throws Exception {
        mockMvc.perform(get("/").param("q", HomeController.FIRST_QUESTION))
                .andExpect(status().is(HttpStatus.OK.value()));
    }

    @Test
    public void should_answer_bad_request_to_others_questions() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
    }

}
