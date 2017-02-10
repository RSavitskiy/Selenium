package TestNG.Xml;

import org.testng.annotations.Test;

public class LoginTest {
// properties in SuiteBasicFunctionality.xml


    @Test
    public void LoginViaEmail() {
        System.out.println("Login via e-mail");
    }

    @Test
    public void LoginViaFacebook() {
        System.out.println("Login  via Facebook");
    }

    @Test
    public void LoginViaTwitter() {
        System.out.println("Login Via Twitter");
    }


}
