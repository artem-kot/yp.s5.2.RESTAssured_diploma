package org.example.user;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.user.common.UserSteps;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;

@DisplayName("Test cases for user creation")
public class CreateUserTest extends UserSteps {

    @Test
    @DisplayName("Test user account creation")
    @Description("Creating user account with a random email address. Validating the status code and name of the user.")
    public void createNewUserTest() {
        createUser(validUser).then().statusCode(200).assertThat()
                .body("user.name", equalTo(userName));
    }

    @Test
    @DisplayName("Test duplicate user account creation")
    @Description("Creating user account with a random email address. Validating that it's impossible to create user account with the same credentials.")
    public void createDuplicateUserTest() {
        createUser(validUser);
        createUser(validUser).then().statusCode(403).assertThat()
                .body("message", equalTo(userAlreadyExistsError));
    }

    @Test
    @DisplayName("Test user account creation for incorrect user object")
    @Description("Creating user account without a mandatory field (name). Validating the status code and the error message.")
    public void createInvalidUserTest() {
        createUser(invalidUser).then().statusCode(403).assertThat()
                .body("message", equalTo(missingMandatoryFieldError));
    }

}
