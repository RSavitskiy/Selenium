package TestNG.Xml;

import org.testng.annotations.Test;

public class PaymentTest {


    @Test
    public void PaymentInDollar(){
        System.out.println("Payment in dollar");
    }

    @Test
    public void PaymentInEuro(){
        System.out.println("Payment in euro");
    }

    @Test
    public void PaymentInUah(){
        System.out.println("Payment in uah");
    }
}
