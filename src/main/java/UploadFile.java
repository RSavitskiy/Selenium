import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class UploadFile {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://tinypic.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath(".//*[@id='the_file']")).sendKeys("C:\\Users\\savitskiy.MAIN\\Desktop\\Test txt.txt");



        driver.close();


    }

}
