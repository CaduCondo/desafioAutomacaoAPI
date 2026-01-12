
package utils;

import static io.restassured.RestAssured.given;

public class TokenManager {

    private static String token;

    public static String getToken() {
        if (token == null) {
            criarUsuarioAdminELogar();
        }
        return token;
    }

    private static void criarUsuarioAdminELogar() {
        String email = "admin" + System.currentTimeMillis() + "@qa.com";
        String password = "123456";

        String user = "{\"nome\":\"Admin QA\",\"email\":\""+email+"\",\"password\":\""+password+"\",\"administrador\":\"true\"}";

        given().contentType("application/json").body(user).post("/usuarios");

        token = given()
                .contentType("application/json")
                .body("{\"email\":\""+email+"\",\"password\":\""+password+"\"}")
                .post("/login")
                .then()
                .statusCode(200)
                .extract()
                .path("authorization");
    }
}
