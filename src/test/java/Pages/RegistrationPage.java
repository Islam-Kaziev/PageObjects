package Pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {


    public void openPage() {
        open("/automation-practice-form");
    }

    public void setFirstName(String value) {
        $("#firstName").setValue(value);
    }

    public void setLastName(String value) {
        $("#lastName").setValue(value);
    }

    public void setEmail(String value) {
        $("#userEmail").setValue(value);
    }
}