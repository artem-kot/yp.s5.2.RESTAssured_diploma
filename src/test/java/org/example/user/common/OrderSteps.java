package org.example.user.common;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.order.OrderApi;
import org.example.order.OrderPojo;
import org.example.user.UserApi;
import org.example.user.UserPojo;
import org.junit.After;
import org.junit.Before;

import java.io.*;

public class OrderSteps extends BaseTestData {
    private OrderApi client;
    protected OrderPojo validOrder;
    protected OrderPojo invalidOrder;
    protected OrderPojo emptyOrder;

    @Before
    @Step("Create test data")
    public void setup() {
        validOrder = new OrderPojo(validIngredients);
        invalidOrder = new OrderPojo(invalidIngredients);
        emptyOrder = new OrderPojo(emptyIngredients);
        client = new OrderApi();
    }

    @Step("Create order")
    public Response createOrder(OrderPojo order) {
        return client.createOrder(order);
    }

    @Step("Create order")
    public Response createOrder(OrderPojo order, String accessToken){
        return client.createOrder(order, accessToken);
    }

    @Step("Get user's orders")
    public Response getOrders(String accessToken) {
        return client.getUserOrders(accessToken);
    }
}