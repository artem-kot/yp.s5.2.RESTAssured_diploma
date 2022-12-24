package site.stellarburgers.common;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import site.stellarburgers.order.OrderApi;
import site.stellarburgers.order.OrderPojo;
import site.stellarburgers.user.UserApi;
import site.stellarburgers.user.UserPojo;

public class BaseTestData {

    public UserPojo validUser;
    public UserPojo invalidUser;
    protected UserApi userApi;
    protected OrderPojo validOrder;
    protected OrderPojo invalidOrder;
    protected OrderPojo emptyOrder;
    protected OrderApi orderApi;
    //    Expected results.
    protected String userAlreadyExistsError = "User already exists";
    protected String missingMandatoryFieldError = "Email, password and name are required fields";
    protected String failedLoginAttemptError = "email or password are incorrect";
    protected String noIngredientsProvidedError = "Ingredient ids must be provided";
    protected String invalidIngredientsHashError = "One or more ids provided are incorrect";
    protected String missingAuthorizationError = "You should be authorised";
    //    Default user details
    String randomEmail = RandomStringUtils.randomAlphabetic(9) + "@example.org";
    String userName = "JohnDoe";
    String password = "password";
    //    Default order details
    String[] validIngredients = new String[]{
            "61c0c5a71d1f82001bdaaa70", "61c0c5a71d1f82001bdaaa74", "61c0c5a71d1f82001bdaaa76"};
    String[] invalidIngredients = new String[]{
            "invalid hash", "609646e4dc916e00276b2870"};
    String[] emptyIngredients = new String[0];

    @Before
    @Step("Create test data")
    public void setup() {
        validUser = new UserPojo(randomEmail, password, userName);
        invalidUser = new UserPojo(randomEmail, password);
        userApi = new UserApi();

        validOrder = new OrderPojo(validIngredients);
        invalidOrder = new OrderPojo(invalidIngredients);
        emptyOrder = new OrderPojo(emptyIngredients);
        orderApi = new OrderApi();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Step("Get access token")
    public String getAccessToken() {
        userApi.registerUser(validUser);
        return userApi.readData();
    }

    @After
    @Step("Clean test data")
    public void cleanData() {
        String data = userApi.readData();
        if (data != null) {
            userApi.deleteUser(userApi.readData());
            userApi.storeData("");
        }
    }

}
