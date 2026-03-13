public class B4 {

    public String evaluatePasswordStrength(String password) {

        if (password == null || password.length() < 8) {
            return "Yếu";
        }

        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasLower = password.matches(".*[a-z].*");
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");

        if (hasUpper && hasLower && hasNumber && hasSpecial) {
            return "Mạnh";
        }

        if (hasUpper || hasLower || hasNumber || hasSpecial) {
            return "Trung bình";
        }

        return "Yếu";
    }
}