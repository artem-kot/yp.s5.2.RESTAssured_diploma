package org.example.user;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.ClientInterface;

import java.util.Arrays;

public class UserApi  implements ClientInterface {

    public RequestSpecification request(UserPojo user, String accessToken){
        return spec
                .with()
                .header("Authorization", accessToken)
                .filters(requestFilter, responseFiler, allureLogger)
                .and()
                .body(user);
    }

    public RequestSpecification request(UserPojo user){
        return spec
                .with()
                .filters(requestFilter, responseFiler, allureLogger)
                .and()
                .body(user);
    }

    public Response registerUser(UserPojo user){
        return request(user).post(registerUserUrl);
    }

    public Response loginUser(UserPojo user){
        return request(user).post(loginUserUrl);
    }

    public Response deleteUser(UserPojo user, String accessToken){
        return request(user, accessToken).delete(deleteUserUrl);
    }

    public Response updateUser(UserPojo user, String accessToken){
        return request(user, accessToken).put(updateUserUrl);
    }

    public Response getUser(){
        return request(new UserPojo()).get(getUserUrl);
    }

}