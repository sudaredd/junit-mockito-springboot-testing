package app.unittesting.spike;

import com.jayway.jsonpath.JsonPath;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class JsonPathTest {

    @Test
    public void testLearning() {

        var response = """
            [
            {"id":1, "name":"Pen", "Quantity" : 15},
            {"id":2, "name":"Pencil", "Quantity" : 50},
            {"id":3, "name":"Eraser", "Quantity" : 10}
            ]
            """;

        var documentContext = JsonPath.parse(response);

        var length = documentContext.read("$.length()");
        assertThat(length).isEqualTo(3);

        List<Integer> ids = documentContext.read("$..id");

        assertThat(ids).containsExactly(1, 2, 3);

        log.info(documentContext.read("$.[1]").toString());
        log.info(documentContext.read("$.[0:1]").toString());
        log.info(documentContext.read("$.[?(@.name == 'Pencil')]").toString());
        log.info(documentContext.read("$.[?(@.Quantity == 10)]").toString());
    }
}
