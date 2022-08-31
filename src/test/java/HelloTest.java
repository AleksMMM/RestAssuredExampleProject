import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.TestBase;
import org.junit.jupiter.api.Test;

import static org.example.CoreTest.FEATURE_HELLO;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature(FEATURE_HELLO)
public class HelloTest extends TestBase {

    @Test
    public void getHelloDirty() {
        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/hello")
                .andReturn();

        assertEquals(200, response.statusCode(), "Код ответа не соответствует ожидаемому");
    }
}
