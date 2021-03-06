package app.unittesting.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class ItemControllerIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void testContextLoads() throws JSONException {
        String template = this.testRestTemplate.getForObject("/all-items", String.class);
        JSONAssert.assertEquals("[{id:1},{id:2},{id:3},{id:4}]", template, false);
    }
}
