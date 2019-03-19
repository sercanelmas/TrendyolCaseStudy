package Boutiques;

import Elements.General_Elements;
import Utils.Definitions;
import Utils.Driver;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import static Utils.Definitions.*;

public class Response_Code_Load_Time extends Driver {

    @After

    public void resonponseAndLoadTime() throws InterruptedException, IOException {

        String piIndex = "0";
        while (true) {
            Scrolls(General_Elements.Get_Footer());
            Thread.sleep(1000);
            String URL = driver.getCurrentUrl();

            String piTmp = getQueryStringParam(URL, "pi");
            if (piIndex.equals(piTmp)) {
                break;
            } else {
                piIndex = piTmp;
            }

        }
        navigateTo("https://www.trendyol.com/?pi=" + piIndex);

        List<WebElement> largElements = getElements(By.className("butik-large-image"));

        Iterator<WebElement> iter = largElements.iterator();

        ResponseCode_ImgLoadedTime(iter);

        List<WebElement> smallElements = getElements(By.className("butik-small-image"));

        Iterator<WebElement> iterSmall = smallElements.iterator();

        ResponseCode_ImgLoadedTime(iterSmall);


    }

    private void ResponseCode_ImgLoadedTime(Iterator<WebElement> iterSmall) throws IOException {
        FileWriter fileWriter = new FileWriter("C:\\SercanElmas\\test.csv");
        String File_Header = "Boutiq        Response Code  LoadTime";
        fileWriter.append(File_Header + "\n");
        while (iterSmall.hasNext()) {
            WebElement largeElem = iterSmall.next();
            WebElement aElem = largeElem.findElement(By.tagName("a"));
            WebElement img = aElem.findElement(By.tagName("img"));
            String imgOrjHref = img.getAttribute("data-original");
            String aHref = aElem.getAttribute("href");


            long start = System.currentTimeMillis();
            Definitions.GetContent(imgOrjHref);
            long end = System.currentTimeMillis();
            long totalTime = end - start;

            String Title = img.getAttribute("title");
            fileWriter.append(Title);

            String rsp = String.valueOf(Definitions.GetResponseCode(aHref));
            fileWriter.write("  " + rsp);
            fileWriter.write("     " + totalTime + "ms" + "\n");
        }
    }
}

