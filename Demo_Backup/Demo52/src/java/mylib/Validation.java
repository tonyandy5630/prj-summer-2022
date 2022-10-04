/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylib;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author thanh
 */
public class Validation {
    public static String emailValidateFailedMsg = "You have entered an invalid e-mail address. Please try again.";
    public static String passwordValidateFailedMsg = "The minimum password length is 8 characters and must contain at least 1 lowercase letter, 1 capital letter, 1 number and 1 special character. Please try again.";
    public static String fullnameValidateFailedMsg = "Your full name must not contain number and special character. Please try again.";
    public static String phoneNumberValidateFailedMsg = "You have entered an invalid phone number. Please try again.";

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);

    public static final Pattern VALID_PASSWORD_REGEX = Pattern.compile(
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
            Pattern.CASE_INSENSITIVE);

    public static final Pattern VALID_FULLNAME_REGEX = Pattern.compile("^[a-zA-Z\\s]+",
            Pattern.CASE_INSENSITIVE);

    public static final Pattern VALID_PHONE_NUMBER_REGEX = Pattern.compile("^\\d{10}$",
            Pattern.CASE_INSENSITIVE);

    public static boolean emailValidate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public static boolean passwordValidate(String password) {
        Matcher matcher = VALID_PASSWORD_REGEX.matcher(password);
        return matcher.find();
    }

    public static boolean fullnameValidate(String fullname) {
        Matcher matcher = VALID_FULLNAME_REGEX.matcher(fullname);
        return matcher.find();
    }

    public static boolean phoneNumberValidate(String phoneNumber) {
        Matcher matcher = VALID_PHONE_NUMBER_REGEX.matcher(phoneNumber);
        return matcher.find();
    }

}
