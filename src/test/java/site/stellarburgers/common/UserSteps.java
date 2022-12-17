package site.stellarburgers.common;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import site.stellarburgers.user.UserPojo;

public class UserSteps extends BaseTestData {
    @Step("Create user")
    public Response createUser(UserPojo user) {
        return userApi.registerUser(user);
    }

    @Step("Login user")
    public Response loginUser(UserPojo user) {
        return userApi.loginUser(user);
    }

    @Step("Update user")
    public Response updateUser(UserPojo user) {
        return userApi.updateUser(user, userApi.readData());
    }

    @Step("Update user without auth")
    public Response updateUser(){
        return userApi.updateUser(validUser);
    }
}