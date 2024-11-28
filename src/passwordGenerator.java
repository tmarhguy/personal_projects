import java.util.*;

public class passwordGenerator {
    static String password = "";
    static Random random = new Random();
    static int move;   //0 - uppercase, 1 - lowercase, 2 - number, 3 - special
    static char value;
    static char[] special = new char [30];
    static StringBuilder pass = new StringBuilder();

    //ASCII 65 - 90 are Uppercase
    //ASCII 97 - 122 are Lowercase
    //ASCII 48 - 57 are Numbers
    //ASCII 33 - 47 && 58 - 64 && 91 - 96 && 123 - 126 are Special Characters


    static char generate(int move) {
        int now = 33;
        for (int i = 0; i < 30; i++) {
            special[i] = (char) now;
            now++;
            if (now == 47) {
                now = 58;
            } else if (now == 64) {
                now = 91;
            } else if (now == 96) {
                now = 123;
            }
        }

        value = switch (move) {
            case 0 -> (char) random.nextInt(65, 91);    //generate upper
            case 1 -> (char) random.nextInt(97, 122);    //generate lower
            case 2 -> (char) random.nextInt(48, 57);    //generate number
            case 3 -> special[random.nextInt(30)];    //generate special
            default -> throw new IllegalStateException("Unexpected value: " + move);
        };

        return value;
    }

    static String generatePassword() {
        while (!isValidPassword(password)){
            move = random.nextInt(4);
            pass.append(generate(move));
            password = pass.toString();
    }
    return password;
    }

    static boolean isValidPassword(String password) {
        boolean validLength = password.length() >= 10;
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasSpecial = false;
        boolean hasNumber = false;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                hasUpper = true;
            }
            else if (Character.isLowerCase(password.charAt(i))) {
                hasLower = true;
            }
            else if (Character.isDigit(password.charAt(i))) {
                hasNumber = true;
            }
            else {
                hasSpecial = true;
            }
        }

        return validLength && hasLower && hasUpper && hasSpecial && hasNumber;
    }

}