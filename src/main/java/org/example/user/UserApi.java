package org.example.user;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.ClientInterface;

import java.io.*;

public class UserApi implements ClientInterface {

    public RequestSpecification request(UserPojo user, String accessToken){
        return RestAssured
                .given()
                .spec(spec)
                .header("Authorization", accessToken)
                .body(user);
    }

    public RequestSpecification request(UserPojo user){
        return RestAssured
                .given()
                .spec(spec)
                .body(user);
    }

    public RequestSpecification request(String accessToken){
        return RestAssured
                .given()
                .spec(spec)
                .header("Authorization", accessToken);
    }

    public Response registerUser(UserPojo user){
        Response response = request(user).post(registerUserUrl);
        if(String.valueOf(response.statusCode()).equals("200")){
            String accessToken = response.then().extract().body().path("accessToken").toString();
            storeData(accessToken);
        }
        return response;
    }

    public Response loginUser(UserPojo user){
        Response response = request(user).post(loginUserUrl);
        if(String.valueOf(response.statusCode()).equals("200")){
            String accessToken = response.then().extract().body().path("accessToken").toString();
            storeData(accessToken);
        }
        return response;
    }

    public void deleteUser(String accessToken){
        request(accessToken).delete(deleteUserUrl);
    }

    public Response updateUser(UserPojo user, String accessToken){
        return request(user, accessToken).patch(updateUserUrl);
    }

    public Response updateUser(UserPojo user){
        return request(user).patch(updateUserUrl);
    }

    public Response getUser(){
        return request(new UserPojo()).get(getUserUrl);
    }

    public void storeData(String string) {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(testdata));
            writer.write(string);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readData() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(testdata));
            String token = reader.readLine();
            reader.close();
            return token;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}