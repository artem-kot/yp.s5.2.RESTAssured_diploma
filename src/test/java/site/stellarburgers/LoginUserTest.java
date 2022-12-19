package site.stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.stellarburgers.common.UserSteps;

import static org.hamcrest.CoreMatchers.equalTo;

@DisplayName("Test cases for user login")
public class LoginUserTest extends UserSteps {

    @Test
    @DisplayName("Test for successful user login")
    @Description("Creating new user and logging in with new credentials.")
    public void logInRegisteredUserTest() {
        createUser(validUser);
        loginUser(validUser).then().statusCode(200).assertThat()
                .body("success", equalTo(true));
    }

    @Test
    @DisplayName("Test for unsuccessful user login")
    @Description("Trying to log in user without registration.")
    public void logInUnregisteredUserTest() {
        loginUser(validUser).then().statusCode(401).assertThat()
                .body("message", equalTo(failedLoginAttemptError));
    }
}
