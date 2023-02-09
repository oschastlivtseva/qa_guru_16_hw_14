package guru.qa.utils;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class UserDataGenerator {

    private final Faker faker = new Faker();
    private final Random random = new Random();

    public UserData generateUserData() {
        String firstName = generateFirstName();
        String lastName = generateLastName();
        String email = generateEmail();
        String password = generatePassword();

        return new UserData(firstName, lastName, email, password);
    }

    private String generateFirstName() {
        return faker.name().firstName();
    }

    private String generateLastName() {
        return faker.name().lastName();
    }

    private String generateEmail() {
        return faker.internet().emailAddress();
    }

    private String generatePassword() {
        List<String> specialCharsOptions = Arrays.asList("!", "#", "%", "+", ":", "=", "?", "@", " ");
        String specialChar = specialCharsOptions.get(random.nextInt(specialCharsOptions.size()));

        String lowerCaseChars = faker.lorem().word().toLowerCase();
        String upperCaseChars = faker.lorem().word().toUpperCase();
        String number = faker.numerify("#####");

        return lowerCaseChars + upperCaseChars + number + specialChar;
    }


}
