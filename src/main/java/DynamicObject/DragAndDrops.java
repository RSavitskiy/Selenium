package DynamicObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class DragAndDrops {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://jqueryui.com/draggable/");
        driver.manage().window().maximize();


        List<WebElement> elements = driver.findElements(By.tagName("iframe"));
        System.out.println(elements.size());
        driver.switchTo().frame(0);
        WebElement element = driver.findElement(By.xpath(".//*[@id='draggable']"));
        System.out.println(element.getText());
        Actions actions = new Actions(driver);
        actions.moveToElement(element).dragAndDropBy(element, 50, 50).build().perform();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.close();
    }
}
