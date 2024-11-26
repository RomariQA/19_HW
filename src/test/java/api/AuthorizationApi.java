package api;

import models.LoginRequestModel;
import models.LoginResponseModel;

import static api.specs.LogSpec.RequestSpec;
import static api.specs.LogSpec.ResponseSpec200;
import static io.restassured.RestAssured.given;

public class AuthorizationApi {

    public static LoginResponseModel getAuthCookie(){
        LoginRequestModel request = new LoginRequestModel("Mayaa", "MayaMaya1!");


        return given(RequestSpec)
                .body(request)
                .when()
                .post("/Account/v1/Login")
                .then()
                .spec(ResponseSpec200)
                .extract().as(LoginResponseModel.class);
    }
}
