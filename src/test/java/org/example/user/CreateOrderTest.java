package org.example.user;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.example.user.common.OrderSteps;
import org.example.user.common.UserSteps;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;

@DisplayName("Test cases for order creation process")
public class CreateOrderTest extends OrderSteps {

// TODO: Think how to properly inject user creation. Currently it fails because of user api absence.
    @Test
    @DisplayName("Test a successful creation of order by authorized user")
    @Description("Registering user and then creating an order. Validating that order was successfully created.")
    public void createValidAuthOrderTest() {
        UserSteps user = new UserSteps();
        user.createUser(user.validUser);
        String accessToken = user.readData();

        createOrder(validOrder, accessToken).then().statusCode(200).assertThat()
                .body("success", equalTo(true)).and()
                .body("order.owner.name", equalTo(user.validUser.getName()));

        user.cleanData();
    }

    @Test
    @DisplayName("Test creation of order without authentication")
    @Description("Trying to create a new order without user authentication.")
    public void createValidNonauthOrderTest() {
        createOrder(validOrder).then().statusCode(200).assertThat()
                .body("success", equalTo(true)).and()
                .body("order.owner.name", equalTo(null));
    }
}
