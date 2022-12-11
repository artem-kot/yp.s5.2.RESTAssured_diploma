package org.example.user.user;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.user.UserApi;
import org.example.user.UserPojo;
import org.junit.After;
import org.junit.Before;

import java.io.*;

public class UserSteps extends BaseTestData {
    private UserApi client;
    UserPojo validUser;
    UserPojo invalidUser;

    @Before
    @Step("Create test data")
    public void setup() {
        validUser = new UserPojo(randomEmail, "password", "JohnDoe");
        invalidUser = new UserPojo(randomEmail, "password");
        client = new UserApi();
    }

    @Step("Create user")
    public Response createUser(UserPojo user) {
        Response response = client.registerUser(user);
        if(String.valueOf(response.statusCode()).equals("200")){
            String accessToken = response.then().extract().body().path("accessToken").toString();
            storeData(accessToken);
        }
        return response;
    }

    @Step("Delete user")
    public Response deleteUser() {
        return client.deleteUser(validUser, readData());
    }

    @After
    @Step("Clean test data")
    public void cleanData() {
        String data = readData();
        if (data != null){
            deleteUser();
            storeData("");
        }
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