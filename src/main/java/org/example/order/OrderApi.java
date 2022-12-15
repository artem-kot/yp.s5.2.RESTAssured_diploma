package org.example.order;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.ClientInterface;
import org.example.user.UserPojo;

public class OrderApi implements ClientInterface {
    public RequestSpecification request(OrderPojo order, String accessToken){
        return RestAssured
                .given()
                .spec(spec)
                .header("Authorization", accessToken)
                .body(order);
    }

    public RequestSpecification request(OrderPojo order){
        return RestAssured
                .given()
                .spec(spec)
                .body(order);
    }

    public RequestSpecification getUserOrder(String accessToken){
        return RestAssured
                .given()
                .spec(spec)
                .header("Authorization", accessToken);
    }

    public RequestSpecification getUserOrders(){
        return RestAssured
                .given()
                .spec(spec);
    }

    public Response createOrder(OrderPojo order){
        return request(order).post(createOrderUrl);
    }
    public Response createOrder(OrderPojo order, String accessToken){ return request(order, accessToken).post(createOrderUrl); }
    public Response getUserOrders(String accessToken){ return getUserOrder(accessToken).get(getOrdersUrl); }

}
