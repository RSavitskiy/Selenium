package TestNG;

import org.testng.annotations.*;

public class AnnotationTestNG_2 {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before suite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After suite");
    }


    @BeforeTest
    public void beforeTest(){
        System.out.println("Before all test, anywhere  ");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After all test anywhere");
    }


    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class AnnotationTestNG_2");
    }

    @Test
    public void test_3(){
        System.out.println("Inside test 3");
    }
}
