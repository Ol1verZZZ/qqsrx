package qqsrx.spring.boot.minidouban;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import qqsrx.spring.boot.minidouban.controller.HelloWorldController;

@SpringBootTest
public class HelloWorldControllerTest {
    private MockMvc mvc;

//    @Before
//    public void setup() {
//        mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
//    }

    @Test
    public void testHello() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();

        mvc.perform(MockMvcRequestBuilders
                    .get("/hello")
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .param("name", "Oliver"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("Hello Oliver!"))
                    .andDo(MockMvcResultHandlers.print());
    }


//    public void setUp() throws Exception {
//        mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
//    }
//
//    @Test
//    public void getHello() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
//    }
}