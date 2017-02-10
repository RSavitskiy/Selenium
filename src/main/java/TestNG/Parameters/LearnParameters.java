package TestNG.Parameters;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LearnParameters {

    @Parameters("email")
    @Test
    public void login(String email) {
        System.out.println("Inside Login");
        System.out.println(email);
    }
    @Parameters("pass")
    @Test (priority = 2)
    public void lass(String pass){
        System.out.println(pass);
    }
}
