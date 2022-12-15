package org.example;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.*;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.*;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.security.KeyStore;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface ClientInterface {
    String testdata = "src/test/resources/testdata";

//    Common filters to log requests and responses.
    Filter requestFilter = new RequestLoggingFilter();
    Filter responseFiler = new ResponseLoggingFilter();
    Filter allureLogger = new AllureRestAssured();

//    Common api client specifications.
    RequestSpecification spec = RestAssured.given()
            .baseUri("https://stellarburgers.nomoreparties.site")
            .basePath("/api")
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .filters(requestFilter, responseFiler, allureLogger);

//    URL paths for different methods.
    String registerUserUrl = "/auth/register";
    String loginUserUrl = "/auth/login";
    String logoutUserUrl = "/auth/logout";
    String getUserUrl = "/auth/user";
    String updateUserUrl = getUserUrl;
    String deleteUserUrl = getUserUrl;

    String getIngredientsUrl = "/ingredients";
    String getOrdersUrl = "/orders/all";
    String getUsersOrdersUrl = "/orders";
    String createOrderUrl = getUsersOrdersUrl;

    String resetPasswordRequestUrl = "/password-reset";
    String resetPasswordConfirmationUrl = "/password-reset/reset";
    String refreshTokenUrl = "/auth/token";

}
