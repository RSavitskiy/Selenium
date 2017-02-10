package TestNG.PassFailSkipTest;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class PassFailSkip {


    @Test
    public void LoginViaEmail() {
        System.out.println("Login via e-mail");

//        Assert.assertEquals("test","fail");
//        Assert.assertEquals(1,2);
//        Assert.assertTrue(4>1);
//        Assert.assertTrue(1!=1);
//        Assert.assertFalse(1==2);
//        Assert.assertFalse(1<2);

//        skip  fail test
        try {
            Assert.assertEquals("test", "123");
        } catch (Throwable t) {
            System.out.println(t);
        }

    }

    @Test
    public void LoginViaFacebook() {
        System.out.println("Login  via Facebook");
//        skip test
        throw new SkipException("facebook functionality is not supported");
    }

    @Test
    public void LoginViaTwitter() {
        System.out.println("Login Via Twitter");
    }


}


