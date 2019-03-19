package Login;

import Utils.Definitions;
import Utils.Driver;
import org.junit.After;
import org.openqa.selenium.interactions.Actions;

import java.io.FileWriter;
import java.io.IOException;

import static Elements.Login_Elements.*;
import static Elements.Login_Elements.Get_btnLogin;
import static Elements.Login_Elements.Get_password;
import static Utils.Definitions.GetResponseCode;
import static Utils.Definitions.checkElement;
import static Utils.Definitions.driver;

public class Error_Psw extends Driver {

    @After
    public void Error_Psw() throws IOException, InterruptedException {
        FileWriter fileWriter = new FileWriter("C:\\SercanElmas\\test.csv");
        String File_Header = "Expected,     Result";
        fileWriter.append(File_Header + "\n");
        Actions action = new Actions(driver);
        action.moveToElement(Get_btnLoginRegister());
        Thread.sleep(500);
        Get_btnLoginRegister().click();

        if (checkElement(loginPopup)) {
            Get_mail().click();
            Get_mail().sendKeys("test@sercan.com");
            Get_password().click();
            Get_password().sendKeys("test123");
            Get_btnLogin().click();
            GetResponseCode(driver.getCurrentUrl());
            if (Definitions.checkElement(errorBox) && Get_errorBox().equals("Hatalı E-Posta / Şifre. Tekrar Deneyin.")) {
                fileWriter.append("Hatali Sifre Girisi");
                fileWriter.append("Passed");
            } else {
                fileWriter.append("Hatali Sifre Girisi");
                fileWriter.append("Failed");
            }
        }
        fileWriter.flush();
        fileWriter.close();
    }
}
