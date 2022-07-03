package app.unittesting;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JSONAssertTest {

    String actual = """
        {
           "id":10,
           "name":"ball",
           "price":10.0,
           "quantity":100
        }
        """;

    @Test
    public void testWithStrictTrue() throws JSONException {
        String expected = """
        {
           "id":10,
       "name":"ball",
                    "price":10.0,
                "quantity": 100
        }
        """;

        JSONAssert.assertEquals(expected, actual,true);
    }

    @Test
    public void testWithStrictFalse() throws JSONException {
        String expected = """
        {
       "id":10,
       "name":"ball"
        }
        """;

        JSONAssert.assertEquals(expected, actual, false);
    }
}
