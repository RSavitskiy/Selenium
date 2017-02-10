import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class HidePassword {
    public static void main(String[] args) {


        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.rediff.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath(".//*[@id='signin_info']/a[1]")).click();
        driver.findElement(By.xpath(".//*[@id='login1']")).sendKeys("appautomator@rediffmail.com");
        driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(getEncodedPassword());
        driver.findElement(By.xpath(".//*[@value='Go']")).click();

        driver.close();
    }

    private static String encodedPassword = "QXBwaXVtMTIz";

    private static String getEncodedPassword() {
        return new String(Base64.decodeBase64(encodedPassword.getBytes()));
    }

    // decode("Appium123");
    private static void decode(String pass) {
        String encode = new String(Base64.encodeBase64(pass.getBytes()));
        System.out.println(encode);
        String decode = new String(Base64.decodeBase64(encode.getBytes()));
        System.out.println(decode);
    }
}


