package DynamicObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class DynamicElement {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.yahoo.com/");
        driver.findElement(By.xpath(".//*[@id='uh-search-box']")).sendKeys("news");

// find some element with pop-up menu ( starts-with )
// ( and we can using contains (".//*[contains(@some element, 'some value')])
        List<WebElement> list = driver.findElements(By.xpath(".//*[starts-with(@class,'yui3-aclist-item')]"));

        System.out.println(list.size());
        Thread.sleep(3000);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
        }

        list.get(3).click();
        driver.close();


    }
}
