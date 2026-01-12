
package contracts;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Epic("API Serverest")
@Feature("Contrato")
public class UserContractTest extends BaseTest {

    @Test
    @Description("Validação do contrato básico de usuários")
    void deveValidarContrato() {
        String id =
            given().get("/usuarios")
            .then().statusCode(200)
            .extract().path("usuarios[0]._id");

        assertNotNull(id);
    }
}
