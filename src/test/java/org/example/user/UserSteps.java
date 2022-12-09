package org.example.user;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

public class UserSteps {
    private UserApi client;
    private UserPojo user;

    @Before
    public void setup(){
        user = new UserPojo("example@example.org", "password", "JohnDoe");
        client = new UserApi();
    }

    @Step("Create user, remove user")
    public void userTest(){
        String accessToken = client.registerUser(user)
                .then()
                .extract()
                .body()
                .path("accessToken").toString();

        System.out.println(accessToken);

        client.deleteUser(user, accessToken)
                .then()
                .assertThat()
                .statusCode(202);
    }

    @Test
    public void test(){
        userTest();
    }
}
