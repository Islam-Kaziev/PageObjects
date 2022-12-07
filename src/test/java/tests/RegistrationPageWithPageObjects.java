package tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPageWithPageObjects extends TestBase {

    @Test
    void StudentRegistrationForm() {
        String firstName = "Islam";
        String lastName = "Kaziev";
        String email = "Islam@Vasiya.com";

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender("Other")
                .setPhone("9111111111")
                .setBirthDate("30", "July", "2008");

        $("#subjectsInput").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/resources/dog.jpeg"));
        $("#currentAddress").setValue("KBR, Nalchik, Lenina, 32, B");
        $("#state").click();
        $("#react-select-3-option-3").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();

        //checking the data after sending
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName), text(lastName), text("Islam@Vasiya.com"),
                text("9111111111"), text("16 November,1994"), text("English, Maths"), text("Music"), text("dog.jpeg"),
                text("KBR, Nalchik, Lenina, 32, B"), text("Rajasthan Jaiselmer"));
    }
}
