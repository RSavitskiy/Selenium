package DynamicObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandlingFrames {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://jqueryui.com/draggable/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


// error
//        WebElement element = driver.findElement(By.xpath(".//*[@id='draggable']"));
//        System.out.println(element.getText());

        List<WebElement> list = driver.findElements(By.tagName("iframe"));

//        1 method
        driver.switchTo().frame(0);
        WebElement element = driver.findElement(By.xpath(".//*[@id='draggable']"));
        System.out.println(element.getText());
        driver.switchTo().defaultContent();
        WebElement PageElement = driver.findElement(By.xpath(".//*[@id='content']/h1"));
        System.out.println(PageElement.getText());

        System.out.println("------------------");

//      2 method
        WebElement frame = driver.findElement(By.xpath(".//*[@id='content']/iframe"));
        driver.switchTo().frame(frame);
        WebElement element_2 = driver.findElement(By.xpath(".//*[@id='draggable']"));
        System.out.println(element_2.getText());
        driver.switchTo().defaultContent();
        WebElement PageElement_2 = driver.findElement(By.xpath(".//*[@id='content']/h1"));
        System.out.println(PageElement_2.getText());


        driver.close();
    }
}
