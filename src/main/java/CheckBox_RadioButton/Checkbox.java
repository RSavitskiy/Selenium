package CheckBox_RadioButton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Checkbox {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        List<WebElement> checkbox = driver.findElements(By.xpath(".//div[@class='display'][1]//input[@name='sports']"));
        System.out.println(checkbox.size());


        for (WebElement element : checkbox) {
            System.out.println(element.isSelected());

//            System.out.println(element.getAttribute("value"));

            if (element.getAttribute("value").equals("soccer")||
                    element.getAttribute("value").equals("football")) {
                element.click();
            }

        }


        for (WebElement element : checkbox) {
            System.out.println(element.isSelected());


//            driver.close();
        }
    }
}
