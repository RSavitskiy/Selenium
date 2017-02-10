package TestNG.DataParameters;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataParameters {

    @Test(dataProvider = "data")
    public void registerUser(String firstName, String lastName, String email, String pass) {
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(email);
        System.out.println(pass);

//        System.out.println("Roman");
//        System.out.println("Savitskiy");
//        System.out.println("r.savitskiy08@gmail.com");
//        System.out.println("123456");

    }

    @DataProvider(name = "data")
    public Object[][] testData() {
        Object[][] obj = new Object[3][4];
        obj[0][0] = "Roman";
        obj[0][1] = "Savitskiy";
        obj[0][2] = "r.savitskiy08@gmail.com";
        obj[0][3] = "123456";

        obj[1][0] = "Test user_1";
        obj[1][1] = "Test Last NAme";
        obj[1][2] = "Test e-mail";
        obj[1][3] = "123";

        obj[2][0] = "Roman";
        obj[2][1] = "Romanovitch";
        obj[2][2] = "roman!#$%@gmail.xom";
        obj[2][3] = "#какойтопароль";
        return obj;
    }

}



