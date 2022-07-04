package app.unittesting.controller;

import app.unittesting.model.Item;
import app.unittesting.service.ItemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = ItemController.class)
// @SpringBootTest //loads all beans
@AutoConfigureMockMvc
class ItemControllerTest {

  @Autowired MockMvc mockMvc;

  @MockBean
  private ItemService itemService;

  @Test
  void testGetItem() throws Exception {

    var requestBuilder = get("/item").accept(MediaType.APPLICATION_JSON);


    var expected = """
        {
           "id":10,
           "name":"Cricket ball",
           "price":55.0,
           "quantity":1000
        }
        """;

    when(itemService.getItem()).thenReturn(new Item(10, "Cricket ball", 55.0, 1000));

    MvcResult mvcResult =
        mockMvc
            .perform(requestBuilder)
            .andExpect(status().isOk())
            .andExpect(content().json(expected))
            .andReturn();

    JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);
  }

  @Test
  void testFindAllItems() throws Exception {

    var requestBuilder = get("/all-items").accept(MediaType.APPLICATION_JSON);


    var expected = """
        [
        {
           "id":10,
           "name":"Ball",
           "price":10,
           "quantity":2
        },
        {
           "id":11,
           "name":"Tennis ball",
           "price":9,
           "quantity":6
        }
        ]
        """;

    when(itemService.finalAllItems()).thenReturn(
        List.of(new Item(10, "Ball", 10, 2),
        new Item(11, "Tennis ball", 9, 6))
    );

    MvcResult mvcResult =
        mockMvc
            .perform(requestBuilder)
            .andExpect(status().isOk())
            .andExpect(content().json(expected))
            .andReturn();

   JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);
  }
}
