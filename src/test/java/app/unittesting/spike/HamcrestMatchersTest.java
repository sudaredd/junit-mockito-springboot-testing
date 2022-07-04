package app.unittesting.spike;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {

    @Test
    public void learning() {
        var numbers = List.of(12, 15, 45);

        assertThat(numbers, hasSize(3));
        assertThat(numbers, hasItems(15, 45));
        assertThat(numbers, everyItem(greaterThan(11)));
        assertThat(numbers, everyItem(lessThan(46)));

        assertThat("", is(emptyString()));
        assertThat("ABCDF", containsString("BCD"));
        assertThat("ABCDF", startsWith("ABCD"));
        assertThat("ABCDF", endsWith("CDF"));
    }
}
