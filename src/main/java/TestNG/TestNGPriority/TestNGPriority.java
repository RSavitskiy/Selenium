package TestNG.TestNGPriority;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPriority {

//    Priority

/*
    @Test(priority = 1)
    public void login(){
        System.out.println("Login");
    }
    @Test(priority = 3)
    public void logout(){
        System.out.println("Logout");
    }
    @Test(priority = 2)
    public void navigation(){
        System.out.println("Navigation");
    }
    */


//    Dependency
    @Test()
    public void login(){
        System.out.println("Login");
        Assert.assertEquals("test","fail");
    }
    @Test()
    public void logout(){
        System.out.println("Logout");
    }
    @Test(dependsOnMethods = {"login"})
    public void navigation(){
        System.out.println("Navigation");
    }

}
