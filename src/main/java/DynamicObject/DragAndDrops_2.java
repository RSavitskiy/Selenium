package DynamicObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DragAndDrops_2 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        List<WebElement> list = driver.findElements(By.tagName("iframe"));
        System.out.println(list.size());

        driver.switchTo().frame(0);
        WebElement drag= driver.findElement(By.xpath(".//*[@id='draggable']"));
        WebElement drop=driver.findElement(By.xpath(".//*[@id='droppable']"));

        Actions action=new Actions(driver);
        action.moveToElement(drag).dragAndDrop(drag,drop).build().perform();

        driver.close();
    }
}
