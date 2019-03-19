package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static Elements.Login_Elements.Get_userEmail;
import static Elements.Login_Elements.userEmail;

public class Definitions {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void navigateTo(String url) {
        driver.navigate().to(url);
    }


    public static void driverSettings() {

        System.setProperty("webdriver.chrome.driver", "C:\\ProjectFolder\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 60);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public static void jsExecuter(Object element, String jsCode) {
        ((JavascriptExecutor) Definitions.driver).executeScript(jsCode, element);
    }

    public static void Scrolls(WebElement element) {
        jsExecuter(element, "arguments[0].scrollIntoView(true)");
    }

    public static WebElement getElement(By elementLocator) {
        return driver.findElement(elementLocator);
    }

    public static List<WebElement> getElements(By elementLocator) {
        return driver.findElements(elementLocator);
    }

    public static boolean checkElement(By elementLocator) {
        return driver.findElements(elementLocator).size() != 0;
    }


    public static void basariliGirisCSV(FileWriter fileWriter, String email) throws IOException {
        if (checkElement(userEmail) && Get_userEmail().getText().equals(email)) {
            fileWriter.append("Başarılı Giriş");
            fileWriter.append("Passed");
        } else {
            fileWriter.append("Başarılı Giriş");
            fileWriter.append("Failed");
        }
    }

    public static String getQueryStringParam(String url, String Param) {
        String qsPart = url.substring(url.indexOf("?") + 1);
        String result = qsPart.substring(qsPart.indexOf(Param) + Param.length() + 1);
        return result;
    }

    public static int GetResponseCode(String url) throws IOException {

        URL largeBoutique = new URL(url);
        HttpURLConnection connectionHeader = (HttpURLConnection) largeBoutique.openConnection();
        connectionHeader.setRequestMethod("GET");
        connectionHeader.connect();
        int rspCode = connectionHeader.getResponseCode();
        return rspCode;
    }

    public static Object GetContent(String url) throws IOException {

        URL largeBoutique = new URL(url);
        HttpURLConnection connectionHeader = (HttpURLConnection) largeBoutique.openConnection();
        connectionHeader.setRequestMethod("GET");
        connectionHeader.connect();
        Object content = connectionHeader.getContent();
        return content;
    }

}