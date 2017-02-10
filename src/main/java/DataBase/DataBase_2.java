package DataBase;

//import junit.framework.Assert;

import java.sql.*;

public class DataBase_2 {

    public static void main(String[] args) throws SQLException {

        String nameUser = "Bill";
        String emailUser = "bill@gmail.com";
        String ageUser = "33";
        String phoneUser = "635698745";


        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/testdatabase?autoReconnect=true&useSSL=false";
//        String url = "jdbc:mysql://localhost:3306/";
//        String dataBase = "testdatabase";
        String loginDataBase = "root";
        String passwordDataBase = "root";

        ResultSet resultSet = null;


        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, loginDataBase, passwordDataBase);


            String sqlQuery = "SELECT*FROM users";
            Statement statement = conn.createStatement();
            resultSet = statement.executeQuery(sqlQuery);


//            resultSet.next();
//            System.out.println(resultSet.getString("Id"));
//            System.out.println(resultSet.getString("Name"));
//            System.out.println(resultSet.getString("Email"));
//            System.out.println(resultSet.getString("Age"));
//            System.out.println(resultSet.getString("Phone"));


            while (resultSet.next()) {
                System.out.print(resultSet.getString("Id") + " ");
                System.out.print(resultSet.getString("Name") + " ");
                System.out.print(resultSet.getString("Email") + " ");
                System.out.print(resultSet.getString("Age") + " ");
                System.out.print(resultSet.getString("Phone") + " \n");
            }


        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (conn != null) {
                conn = null;
            }
        }

//        Assert.assertEquals(resultSet.getString("Name"), nameUser);
//        Assert.assertEquals(resultSet.getString("Email"), emailUser);
//        Assert.assertEquals(resultSet.getString("Age"), ageUser);
//        Assert.assertEquals(resultSet.getString("Phone"), phoneUser);
    }


}
