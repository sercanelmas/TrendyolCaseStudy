package Login;

import Utils.Definitions;
import Utils.Driver;
import org.junit.After;
import org.openqa.selenium.interactions.Actions;

import java.io.FileWriter;
import java.io.IOException;

import static Elements.Login_Elements.*;
import static Utils.Definitions.*;

public class No_Psw extends Driver {

    @After
    public void No_Psw() throws IOException, InterruptedException {
        FileWriter fileWriter = new FileWriter("C:\\SercanElmas\\test.csv");
        String File_Header = "Expected,     Result";
        fileWriter.append(File_Header + "\n");
        Actions action = new Actions(driver);
        action.moveToElement(Get_btnLoginRegister());
        Thread.sleep(500);
        Get_btnLoginRegister().click();

        if (checkElement(loginPopup)) {
            Get_mail().click();
            Get_mail().sendKeys("test@src.com");
            Get_password().click();
            Get_password().sendKeys("");
            Get_btnLogin().click();
            GetResponseCode(driver.getCurrentUrl());
            if (Definitions.checkElement(errorBox) && Get_errorBox().equals("Lütfen şifre giriniz.")) {
                fileWriter.append("Sifresiz Giris");
                fileWriter.append("Passed");
            } else {
                fileWriter.append("Sifresiz Giris");
                fileWriter.append("Failed");
            }
        }
        fileWriter.flush();
        fileWriter.close();
    }
}
