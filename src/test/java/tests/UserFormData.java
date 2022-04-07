package tests;

import com.github.javafaker.Faker;

public class UserFormData {

    private String fullName;
    private String email;
    private String message;
    private String FirstName;
    private String LastName;
    private String OldPassword;
    private String NewPassword;

    public UserFormData() {
        Faker faker = new Faker();
        fullName = faker.name().fullName();
        email = faker.internet().safeEmailAddress();
        message = faker.gameOfThrones().quote();
        FirstName = faker.name().firstName();
        LastName = faker.name().lastName();
        OldPassword = faker.number().digits(8).toString();
        NewPassword = faker.number().digits(9).toString();
    }

    public String getFullName() {
        return fullName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }
    public String getOldPassword() {
        return OldPassword;
    }
    public String getNewPassword() {
        return NewPassword;
    }

    public String getEmail() {
        return email;
    }
    public String getMessage() {
        return message;
    }
}
