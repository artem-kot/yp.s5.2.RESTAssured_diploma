package site.stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.stellarburgers.common.OrderSteps;

import static org.hamcrest.CoreMatchers.equalTo;

@DisplayName("Test cases for order creation process")
public class CreateOrderTest extends OrderSteps {
    @Test
    @DisplayName("Test a successful creation of order by authorized user")
    @Description("Registering user and then creating an order. Validating that order was successfully created.")
    public void createValidAuthOrderTest() {
        createOrder(validOrder, getAccessToken()).then().statusCode(200).assertThat()
                .body("success", equalTo(true)).and()
                .body("order.owner.name", equalTo(validUser.getName()));
    }

    @Test
    @DisplayName("Test creation of order without authentication")
    @Description("Trying to create a new order without user authentication.")
    public void createValidNonauthOrderTest() {
        createOrder(validOrder).then().statusCode(200).assertThat()
                .body("success", equalTo(true)).and()
                .body("order.owner.name", equalTo(null));
    }

    @Test
    @DisplayName("Test creation of order without ingredients")
    @Description("Trying to create a new order without any ingredients.")
    public void createNoIngredientsOrder() {
        createOrder(emptyOrder).then().statusCode(400).assertThat()
                .body("success", equalTo(false)).and()
                .body("message", equalTo(noIngredientsProvidedError));
    }

    @Test
    @DisplayName("Test creation of order with incorrect ingredients")
    @Description("Trying to create a new order with incorrect ingredients.")
    public void createWrongIngredientsOrder() throws InterruptedException {
        Thread.sleep(500); //this wait is added to overcome 429 error (NFR issue)
        createOrder(invalidOrder).then().statusCode(400).assertThat()
                .body("success", equalTo(false)).and()
                .body("message", equalTo(invalidIngredientsHashError));
    }
}
