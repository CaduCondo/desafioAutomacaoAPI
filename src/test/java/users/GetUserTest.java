
package users;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Epic("API Serverest")
@Feature("Usuários")
public class GetUserTest extends BaseTest {

    @Test
    @Description("Listagem de usuários")
    void deveListarUsuarios() {
        given().get("/usuarios").then().statusCode(200);
    }

    @Test
    @Description("Busca de usuário inexistente")
    void deveRetornarErroUsuarioInexistente() {
        given().get("/usuarios/0000").then().statusCode(400);
    }
}
