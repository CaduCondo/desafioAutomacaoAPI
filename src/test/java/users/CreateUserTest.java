
package users;

import base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import utils.TokenManager;

import static io.restassured.RestAssured.given;

@Epic("API Serverest")
@Feature("Usuários")
public class CreateUserTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Criação de usuário com dados válidos")
    void deveCriarUsuarioComSucesso() {
        String body = "{\"nome\":\"User QA\",\"email\":\"user"+System.currentTimeMillis()+"@mail.com\",\"password\":\"123456\",\"administrador\":\"false\"}";

        given()
            .header("Authorization", TokenManager.getToken())
            .contentType("application/json")
            .body(body)
        .post("/usuarios")
        .then()
            .statusCode(201);
    }

    @Test
    @Description("Criação de usuário sem campo obrigatório")
    void naoDeveCriarUsuarioSemNome() {
        String body = "{\"email\":\"semnome@mail.com\",\"password\":\"123456\",\"administrador\":\"false\"}";

        given()
            .header("Authorization", TokenManager.getToken())
            .contentType("application/json")
            .body(body)
        .post("/usuarios")
        .then()
            .statusCode(400);
    }
}
