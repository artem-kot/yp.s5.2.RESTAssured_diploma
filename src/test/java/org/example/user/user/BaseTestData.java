package org.example.user.user;

import org.apache.commons.lang3.RandomStringUtils;

public class BaseTestData {

    String randomEmail = RandomStringUtils.randomAlphabetic(9) + "@example.org";
    String userName = "JohnDoe";
    String password = "password";

    String testdata = "src/test/resources/testdata";

//    expected results
    String userAlreadyExistsError = "User already exists";
    String missingMandatoryFieldError = "Email, password and name are required fields";
}
