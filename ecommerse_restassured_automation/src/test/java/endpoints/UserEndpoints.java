package endpoints;

import entity.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import routes.UserRoutes;

public class UserEndpoints {

    public static Response register(User user) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(user)
                .when()
                .post(UserRoutes.POST_REGISTER_URL);
    }

    public static Response login(String email, String password) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("{\"email\":\"" + email + "\",\"password\":\"" + password + "\"}")
                .when()
                .post(UserRoutes.POST_LOGIN_URL);
    }
}
