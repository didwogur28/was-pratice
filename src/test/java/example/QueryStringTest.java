package example;

import org.example.QueryString;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryStringTest {

    @Test
    void creatTest() {
        QueryString queryString = new QueryString("operand1", "11");


        assertThat(queryString).isNotNull();
    }
}
