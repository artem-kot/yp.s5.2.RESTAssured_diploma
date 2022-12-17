package site.stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import site.stellarburgers.common.UserSteps;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

@DisplayName("Test cases for user info update")
public class UpdateUserTest extends UserSteps {

    @Test
    @DisplayName("Test successful update of user password")
    @Description("Registering user and then updating credentials.")
    public void updateUserPasswordTest() {
        createUser(validUser);
        validUser.setPassword("changed_" + validUser.getPassword());
        updateUser(validUser).then().statusCode(200).assertThat()
                .body("success", equalTo(true));

        validUser.setEmail("changed_" + validUser.getEmail());
        updateUser(validUser).then().statusCode(200).assertThat()
                .body("success", equalTo(true));

        validUser.setName("changed_" + validUser.getName());
        updateUser(validUser).then().statusCode(200).assertThat()
                .body("success", equalTo(true));
    }

    @Test
    @DisplayName("Test unsuccessful update of user info")
    @Description("Trying to change user credentials without authorization.")
    public void updateIsUnsuccessfulTest() {
        updateUser().then().statusCode(401).assertThat()
                .body("success", equalTo(false));
    }
}
