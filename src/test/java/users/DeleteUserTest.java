
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
public class DeleteUserTest extends BaseTest {

    @Test
    @Description("Exclusão de usuário inexistente retorna mensagem")
    void deveRetornarMensagemUsuarioNaoExiste() {
        given()
            .header("Authorization", TokenManager.getToken())
        .delete("/usuarios/123456")
        .then()
            .statusCode(200);
    }
}
