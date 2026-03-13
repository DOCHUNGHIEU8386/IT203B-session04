public class B2 {
    public boolean checkRegistrationAge(int age){
        if(age < 0){
            throw new IllegalArgumentException("age can not be negative");
        }
        return age >= 18;
    }
}
