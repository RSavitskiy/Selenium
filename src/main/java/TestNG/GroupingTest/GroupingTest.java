package TestNG.GroupingTest;

import org.testng.annotations.Test;


public class GroupingTest {

    //smoke test
    @Test(groups = {"smoke"})
    public void feature1() {
        System.out.println("inside feature 1");
    }

    //recreation test
    @Test(groups = {"recreation"})
    public void feature2() {
        System.out.println("inside feature 2");
    }

    //stress test
    @Test (groups = {"smoke","recreation"})
    public void feature3() {
        System.out.println("inside feature 3");
    }


}
