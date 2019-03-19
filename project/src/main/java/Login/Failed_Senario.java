package Login;

import Utils.Driver;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static Elements.Login_Elements.*;
import static Utils.Definitions.*;

public class Failed_Senario extends Driver {


    public String email = "test@sercan.com";
    public String psw = "test1234";

    @After
    public void Failed_Senario() throws IOException, InterruptedException {
        FileWriter fileWriter = new FileWriter("C:\\SercanElmas\\test.csv");
        String File_Header = "Expected,     Result";
        fileWriter.append(File_Header + "\n");
        Actions action = new Actions(driver);
        action.moveToElement(Get_btnLoginRegister());
        Thread.sleep(500);
        Get_btnLoginRegister().click();

        if (checkElement(loginPopup)) {
            Get_mail().click();
            Get_mail().sendKeys(email);
            Get_password().click();
            Get_password().sendKeys("1234");
            Get_btnLogin().click();
            action.moveToElement(Get_btnLoginRegister());
            basariliGirisCSV(fileWriter, email);

            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("C:\\SercanElmas\\SS.png"));
        }
        fileWriter.flush();
        fileWriter.close();
    }


}
