package cat.itacademy.barcelonactiva.allegue.andres.s04.t01.n01.S04T01N01AllegueZabala.Controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void greet() throws Exception {
        mockMvc.perform(get("/HelloWorld"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, UNKNOWN. You are running a Maven project."));

        mockMvc.perform(get("/HelloWorld?nom=Test"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, Test. You are running a Maven project."));
    }

    @Test
    void greet2() throws Exception {
        mockMvc.perform(get("/HelloWorld2"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, user. You are running a Maven project."));

        mockMvc.perform(get("/HelloWorld2/Test"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, Test. You are running a Maven project."));
    }
}