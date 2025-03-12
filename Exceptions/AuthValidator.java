package Exceptions;

public class AuthValidator {
    public static void validateCredentials(String login, String password, String confirmPassword)
            throws LoginException, PasswordException {
        if (login == null || login.length() >= 15 || !login.matches("[a-zA-Z0-9_]+")) {
            throw new LoginException("Логин должен содержать только латинские буквы, цифры и знак подчеркивания " + "и его длина должна быть меньше 15 символов");
        }

        if (password == null || password.length() < 7 || password.length() > 20 || !password.matches("[a-zA-Z0-9_]+")) {
            throw new PasswordException("Пароль должен содержать только латинские буквы, цифры и знак подчеркивания, " + "и его длина должна быть от 7 до 20 символов");
        }

        if (!password.equals(confirmPassword)) {
            throw new PasswordException("Пароли не совпадают");
        }

        System.out.println("Логин и пароль успешно прошли проверку");
    }
}
