package site.stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import site.stellarburgers.common.OrderSteps;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.empty;

@DisplayName("Test cases for getting a list of orders for particular user")
public class GetOrdersTest extends OrderSteps {
    @Test
    @DisplayName("Test that it is possible to get a list of orders created by a particular user")
    @Description("Registering user and then requesting a list of orders created by this user. Validating that request returns with empty list of orders.")
    public void getUsersOrdersWithAuth() {
        getOrders(getAccessToken()).then().statusCode(200).assertThat()
                .body("success", equalTo(true)).and()
                .body("orders", empty());
    }

    @Test
    @DisplayName("Test that it is impossible to get a list of orders created by user without authentication")
    @Description("Trying to create a new order without user authentication.")
    public void getUsersOrdersWithNoAuth() {
        getOrders().then().statusCode(401).assertThat()
                .body("success", equalTo(false)).and()
                .body("message", equalTo(missingAuthorizationError));
    }
}
