package tests;

import org.junit.jupiter.api.Test;

public class RegistrationPageWithPageObjects extends TestBase {

    @Test
    void StudentRegistrationForm() {
        String firstName = "Islam";
        String lastName = "Kaziev";
        String email = "Islam@Vasiya.com";
        String gender = "Male";
        String Phone = "9111111111";
        String birthDay = "30";
        String birthMonth = "June";
        String birthYear = "2008";
        String firstSubjects = "English";
        String secondSubjects = "Math";
        String hobbies = "Music";
        String picture = "dog.jpeg";
        String currentAddress = "KBR, Nalchik, Lenina, 32, B";


        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(Phone)
                .setBirthDate(birthDay, birthMonth, birthYear)
                .setSubjects(firstSubjects, secondSubjects)
                .setHobbies(hobbies)
                .uploadPicture(picture)
                .setAddress(currentAddress)
                .setState()
                .setCity()
                .submitForm()
                .verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", "Islam@Vasiya.com")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "9111111111")
                .verifyResult("Date of Birth", "30 June,2008")
                .verifyResult("Subjects", "English, Maths")
                .verifyResult("Hobbies", "Music")
                .verifyResult("Picture", "dog.jpeg")
                .verifyResult("Address", "KBR, Nalchik, Lenina, 32, B")
                .verifyResult("State and City", "Rajasthan Jaiselmer");
        //checking the data after sending
    }
}
