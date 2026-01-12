
package auth;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Test;
import utils.TokenManager;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Epic("API Serverest")
@Feature("Autenticação")
public class LoginTest extends BaseTest {

    @Test
    @Description("Login com credenciais válidas gera token JWT")
    void deveGerarTokenComSucesso() {
        assertNotNull(TokenManager.getToken());
    }

    @Test
    @Description("Login com credenciais inválidas retorna erro")
    void deveFalharLoginInvalido() {
        String body = "{\"email\":\"invalido@mail.com\",\"password\":\"123456\"}";

        io.restassured.RestAssured.given()
            .contentType("application/json")
            .body(body)
        .post("/login")
        .then()
            .statusCode(401);
    }
}
