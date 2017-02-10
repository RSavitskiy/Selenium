package DynamicObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Resizen {

    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://jqueryui.com/resizable/");
        driver.manage().window().maximize();

        List<WebElement>list=driver.findElements(By.tagName("iframe"));
        System.out.println(list.size());

        driver.switchTo().frame(0);


        WebElement resizen= driver.findElement(By.xpath(".//*[@id='resizable']/div[3]"));

        Actions actions = new Actions(driver);

        actions.moveToElement(resizen).dragAndDropBy(resizen,100,100).build().perform();






        driver.close();
    }
}
