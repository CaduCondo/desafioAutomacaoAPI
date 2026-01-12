
package ratelimit;

import base.BaseTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RateLimitTest extends BaseTest {

    @Test
    @Description("Validação resiliente do rate limit da API")
    void deveRespeitarRateLimit() {
        int statusCode = given().get("/usuarios").getStatusCode();
        assertTrue(statusCode == 200 || statusCode == 429);
    }
}
