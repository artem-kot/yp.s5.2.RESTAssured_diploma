package org.example.user.common;

import org.apache.commons.lang3.RandomStringUtils;

public class BaseTestData {

//    Default user details
    String randomEmail = RandomStringUtils.randomAlphabetic(9) + "@example.org";
    String userName = "JohnDoe";
    String password = "password";

    String testdata = "src/test/resources/testdata";

//    Default order details
    String[] validIngredients = new String[]{
            "61c0c5a71d1f82001bdaaa70","61c0c5a71d1f82001bdaaa74", "61c0c5a71d1f82001bdaaa76"};
    String[] invalidIngredients = new String[]{
            "invalid hash", "609646e4dc916e00276b2870"};
    String[] emptyIngredients = new String[0];

//    Expected results.
    protected String userAlreadyExistsError = "User already exists";
    protected String missingMandatoryFieldError = "Email, password and name are required fields";
    protected String failedLoginAttemptError = "email or password are incorrect";

    protected String noIngredientsProvidedError = "Ingredient ids must be provided";
    protected String invalidIngredientsHashError = "One or more ids provided are incorrect";

}
