import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Wait {


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.rediff.com/");
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        driver.findElement(By.xpath(".//*[@id='signin_info']/a[1]")).click();

        driver.findElement(By.xpath(".//*[@id='login1']")).sendKeys("appautomator@rediffmail.com");
        driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("Appium123");
        driver.findElement(By.xpath(".//*[@value='Go']")).click();

//        or
//        Thread.sleep(10000);
//        or
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='99_54421_newsletters']/span[2]")));


        driver.findElement(By.xpath(".//*[@id='99_54421_newsletters']/span[2]")).click();


        driver.close();
    }
}
