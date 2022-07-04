package app.unittesting.spike;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AssertJTest {

  @Test
  public void learning() {
    var numbers = List.of(12, 15, 45);

    assertThat(numbers)
        .hasSize(3)
        .contains(15, 45)
        .allMatch(x -> x > 11)
        .allMatch(x -> x < 46)
        .noneMatch(x -> x < 11);

    assertThat("").isEmpty();
    assertThat("ABCDE").startsWith("ABC").endsWith("DE").contains("BC");
    assertThat("gfg").isEqualTo("gfg");
    assertThat("ABC".equalsIgnoreCase("aBc")).isTrue();

    /*assertThat(numbers, hasSize(3));
    assertThat(numbers, hasItems(15, 45));
    assertThat(numbers, everyItem(greaterThan(11)));
    assertThat(numbers, everyItem(lessThan(46)));

    assertThat("", is(emptyString()));
    assertThat("ABCDF", containsString("BCD"));
    assertThat("ABCDF", startsWith("ABCD"));
    assertThat("ABCDF", endsWith("CDF"));*/
  }
}
