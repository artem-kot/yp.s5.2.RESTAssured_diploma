package org.example.user.common;

import org.apache.commons.lang3.RandomStringUtils;

public class UserBaseTest {

    String randomEmail = RandomStringUtils.randomAlphabetic(9) + "@example.org";
    protected String userName = "JohnDoe";
    String password = "password";

    String testdata = "src/test/resources/testdata";


//    expected results
    protected String userAlreadyExistsError = "User already exists";
    protected String missingMandatoryFieldError = "Email, password and name are required fields";
    protected String failedLoginAttemptError = "email or password are incorrect";
}
