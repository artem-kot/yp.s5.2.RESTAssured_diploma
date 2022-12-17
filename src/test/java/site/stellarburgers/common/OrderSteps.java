package site.stellarburgers.common;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import site.stellarburgers.order.OrderPojo;

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

    @Step("Get user's orders")
    public Response getOrders() {
        return orderApi.getUserOrders();
    }
}