package Selectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class XpathSelectors {


    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
//        driver.get("http://w3schools.com/");
//        driver.manage().window().maximize();
//        driver.findElement(By.xpath("html/body/ul/li[5]/a")).click();
//        driver.findElement(By.id("gsc-i-id1")).sendKeys("test");
//        driver.findElement(By.linkText("Learn JSON")).click();
//        driver.navigate().back();
//        driver.findElement(By.partialLinkText("JSON")).click();
//        driver.navigate().back();

//        List<WebElement>list= driver.findElements(By.tagName("a"));
//        System.out.println(list.size());

//         find element in all page by some text
//        for (int i=0;i<list.size();i++){
//            System.out.println(list.get(i).getText());
//            if(list.get(i).getText().equals("Learn HTML")){
//                list.get(i).click();
//                break;
//            }
//        }

//        xpath contain id and some text in this id
//        driver.findElement(By.xpath(" //*[@id='mySidenav']/a[text()='Learn JSON']")).click();
//        or
//        driver.findElement(By.xpath(".//*[@id='mySidenav']/a[15]"));


        driver.get("https://www.google.ru/");
//        specific name (id)
//        driver.findElement(By.xpath("//a[@id='gb_70']"));
//        or
//        name(id) start with some letter
//        driver.findElement((By.xpath("//a[starts-with(@id,'gb_7')]"))).click();
//        or
//        name(id)contain some letter
        driver.findElement(By.xpath("//a[contains(@id,'b_7')]")).click();

//      find some text in the page ( text contain in 'a')
        driver.get("http://w3schools.com/");
        driver.findElement(By.xpath("//*[@id='mySidenav']/a[starts-with(text(),'Learn Co')]")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("//*[@id='mySidenav']/a[contains(text(),'arn Ho')]")).click();
        

        driver.quit();
    }
}
