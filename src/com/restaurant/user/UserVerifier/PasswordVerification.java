package com.restaurant.user.UserVerifier;

public class PasswordVerification {
    protected boolean verificationPassword(String password) {
        boolean valid = false;
        try {
            if (password == null || password.trim().isEmpty()) {
                throw new IllegalArgumentException("\u001B[33mНеможе да създадете парола с интервал\u001B[0m");
            }
            if (password.length() < 8) {
                throw new IllegalArgumentException("\u001B[33mДължината на поролата трябва да е >=8\u001B[0m");
            }
            valid = verificationPasswordCharacters(password);

            if (!valid) {
                throw new IllegalArgumentException("\u001B[33mПоролата трябва да съдържа поне една главна, малка буква,символ и цифра.\u001B[0m");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("\u001B[33mНевалидна парола: \u001B[0m" + e.getMessage());
        }
        return valid;
    }

    protected boolean verificationPasswordCharacters(String password) {
        boolean charValid = false;
        boolean uppercaseValid = false;
        boolean lowercaseValid = false;
        boolean digitValid = false;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                uppercaseValid = true;
            }
            else if (!Character.isLetterOrDigit(password.charAt(i))) {
                charValid = true;
            }
            else if (Character.isLowerCase(password.charAt(i))) {
                lowercaseValid = true;
            }
            else if (Character.isDigit(password.charAt(i))) {
                digitValid = true;
            }
            if (charValid && uppercaseValid && lowercaseValid && digitValid) {
                break;
            }
        }

        return charValid && uppercaseValid && lowercaseValid && digitValid;
    }
}
