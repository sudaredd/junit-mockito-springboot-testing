package app.unittesting.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = HelloController.class)
//@SpringBootTest //loads all beans
@AutoConfigureMockMvc
class HelloControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  void sayHello() throws Exception {

    var requestBuilder =
        get("/helloWorld").accept(MediaType.APPLICATION_JSON);

    MvcResult mvcResult = mockMvc.perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().string("hello"))
        .andReturn();
//    assertEquals("hello", mvcResult.getResponse().getContentAsString());
  }
}
