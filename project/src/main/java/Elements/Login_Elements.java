package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Utils.Definitions.getElement;

public class Login_Elements {

    public static By btnLoginRegister = By.cssSelector(".icon-container");

    public static WebElement Get_btnLoginRegister() {
        return getElement(btnLoginRegister);
    }

    public static By userEmail = By.cssSelector(".user-email");

    public static WebElement Get_userEmail() {
        return getElement(userEmail);
    }

    public static By loginPopup = By.cssSelector(".fancybox-wrap.fancybox-desktop.fancybox-type-html.default-popup.fancybox-opened");

    public static By email = By.id("email");

    public static WebElement Get_mail() {
        return getElement(email);
    }

    public static By password = By.id("password");

    public static WebElement Get_password() {
        return getElement(password);
    }

    public static By btnLogin = By.id("loginSubmit");

    public static WebElement Get_btnLogin() {
        return getElement(btnLogin);
    }

    public static By errorBox = By.id("errorBox");

    public static WebElement Get_errorBox() {
        return getElement(errorBox);
    }


}
