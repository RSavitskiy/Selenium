package TestNG;

import org.testng.annotations.*;

public class AnnotationTestNG {

    //call one times when you run the class
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class  AnnotationTestNG \n");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After class");
    }


    // call every times before method which have annotation @test
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method");
    }

    // call every times after method
    @AfterMethod
    public void afterMethod() {
        System.out.println("After method \n");
    }


    //test method
    @Test
    public void test1() {
        System.out.println("Inside test 1");
    }

    @Test
    public void test2() {
        System.out.println("Inside test 2");
    }


}

/*
@BeforeSuite
    @BeforeTest
        @BeforeClass
            @BeforeMethod
                @Test
            @AfterMethod
        @AfterClass
    @AfterTest
@AfterSuite
*/