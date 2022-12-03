package tests;

import Pages.RegistrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPageWithPageObjects {

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";

    }
    @Test
    void StudentRegistrationForm() {
        String firstName = "Islam";
        String lastName = "Kaziev";
        String email = "Islam@Vasiya.com";
        new RegistrationPage().openPage();
        new RegistrationPage().setFirstName(firstName);
        new RegistrationPage().setFirstName(lastName);
        new RegistrationPage().setFirstName(email);
        $("#gender-radio-1").doubleClick();
        $("#userNumber").setValue("9111111111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__day--016").click();
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
        $(".table-responsive").shouldHave(text (firstName), text(lastName), text("Islam@Vasiya.com"),
        text("9111111111"), text("16 November,1994"), text("English, Maths"), text("Music"), text("dog.jpeg"),
        text("KBR, Nalchik, Lenina, 32, B"), text("Rajasthan Jaiselmer"));
    }
}
