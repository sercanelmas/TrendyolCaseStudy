package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import static Utils.Definitions.*;

public class General_Elements {


    public static By Footer = By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]");

    public static WebElement Get_Footer() {
        return getElement(Footer);
    }

    public static By popUp = By.id("popupContainer");

    public static By btnClosePopUp = By.xpath("//a[@title='Kapat']");

    public static WebElement Get_btnClosePopUp() {
        return getElement(btnClosePopUp);
    }

}




