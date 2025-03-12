package Exceptions;

import Exceptions.AuthValidator;
import Exceptions.LoginException;
import Exceptions.PasswordException;

public class App {
    public static void main(String[] args) {
        try {
            AuthValidator.validateCredentials("user_123", "password123", "password123");
            AuthValidator.validateCredentials("user@123", "password123", "password123");
        } catch (LoginException | PasswordException e) {
            System.out.println("Ошибка " + e.getMessage());
        }

        try {
            AuthValidator.validateCredentials("user_123", "pass", "pass");
        } catch (LoginException | PasswordException e) {
            System.out.println("Ошибка " + e.getMessage());
        }

        try {
            AuthValidator.validateCredentials("user_123", "password123", "password456");
        } catch (LoginException | PasswordException e) {
            System.out.println("Ошибка " + e.getMessage());
        }
    }
}
