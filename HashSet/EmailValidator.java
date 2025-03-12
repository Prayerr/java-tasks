package HashSet;

import java.util.regex.Pattern;

public class EmailValidator {
    private static final String emailREGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern emailPattern = Pattern.compile(emailREGEX);

    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        return emailPattern.matcher(email).matches();
    }
}
