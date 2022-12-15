package org.example.user.common;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.order.OrderApi;
import org.example.order.OrderPojo;
import org.example.user.UserApi;
import org.junit.Before;

public class OrderSteps extends BaseTestData {

    @Step("Create order")
    public Response createOrder(OrderPojo order) {
        return orderApi.createOrder(order);
    }

    @Step("Create order")
    public Response createOrder(OrderPojo order, String accessToken){
        return orderApi.createOrder(order, accessToken);
    }

    @Step("Get user's orders")
    public Response getOrders(String accessToken) {
        return orderApi.getUserOrders(accessToken);
    }
}