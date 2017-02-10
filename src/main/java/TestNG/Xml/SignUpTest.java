package TestNG.Xml;

import org.testng.annotations.Test;

public class SignUpTest {
// properties in SuiteBasicFunctionality.xml


    @Test
    public void SignUpViaEmail(){
        System.out.println("Sign up via Email");
    }

    @Test
    public void SignUpViaFacebook(){
        System.out.println("Sign up via Facebook");
    }

    @Test
    public void SignUpViaTwitter(){
        System.out.println("Sign up via Twitter");
    }
}
