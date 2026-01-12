
package users;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Test;
import utils.TokenManager;

import static io.restassured.RestAssured.given;

@Epic("API Serverest")
@Feature("Usuários")
public class UpdateUserTest extends BaseTest {

    @Test
    @Description("Atualização de usuário inexistente cria novo usuário (upsert)")
    void deveCriarUsuarioAoAtualizarInexistente() {
        String body = "{\"nome\":\"Novo\",\"email\":\"novo"+System.currentTimeMillis()+"@mail.com\",\"password\":\"123456\",\"administrador\":\"true\"}";

        given()
            .header("Authorization", TokenManager.getToken())
            .contentType("application/json")
            .body(body)
        .put("/usuarios/123456")
        .then()
            .statusCode(201);
    }
}
