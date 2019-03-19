package Utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static Elements.General_Elements.*;
import static Utils.Definitions.*;

public class Driver {

    @Before
    public void setUp() {
        driverSettings();
    }

    @Test
    public void trendyol() {
        navigateTo("https://www.trendyol.com/");

        if (checkElement(popUp)) {
            Get_btnClosePopUp().click();
        }
    }


    @After
    public void endReport() {
        driver.quit();
    }
}
