package CheckBox_RadioButton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RadioButton {


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.echoecho.com/htmlforms10.htm");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        List<WebElement> list = driver.findElements(By.xpath(".//input[@name='group1']"));

        System.out.println(list.size());

        for (WebElement webElement : list) {
            System.out.println(webElement.getAttribute("value") + " " + webElement.isSelected());
//                System.out.print(webElement.isSelected());

            if (webElement.getAttribute("value").equals("Cheese")) {
                webElement.click();
            }
        }
        System.out.println("____________________");
        for (WebElement webElement : list) {
            System.out.println(webElement.getAttribute("value") + " " + webElement.isSelected());
        }


        System.out.println("---------------------");

//        select all radio button in rotation
        for (WebElement webElement : list) {
            if(webElement.getAttribute("value").equals(webElement.getAttribute("value"))){
                Thread.sleep(3000);
                webElement.click();
            }

        }

        driver.close();

    }
}
