package Login;

import Utils.Driver;
import org.junit.After;
import org.openqa.selenium.interactions.Actions;

import java.io.FileWriter;
import java.io.IOException;

import static Elements.Login_Elements.*;
import static Utils.Definitions.*;
import static Utils.Definitions.checkElement;

public class Passed_Login extends Driver {

    String email = "test@sercan.com";
    String psw = "test1234";

    @After
    public void Passed_Login () throws IOException, InterruptedException {
        FileWriter fileWriter = new FileWriter ("C:\\SercanElmas\\test.csv");
        String File_Header = "Expected,     Result";
        fileWriter.append(File_Header + "\n");
        Actions action = new Actions(driver);
        action.moveToElement(Get_btnLoginRegister());
        Thread.sleep(500);
        Get_btnLoginRegister().click();

        if(checkElement(loginPopup)) {
            Get_mail().click();
            Get_mail().sendKeys(email);
            Get_password().click();
            Get_password().sendKeys(psw);
            Get_btnLogin().click();
            action.moveToElement(Get_btnLoginRegister());
            basariliGirisCSV(fileWriter, email);
        }
        fileWriter.flush();
        fileWriter.close();
    }
}
