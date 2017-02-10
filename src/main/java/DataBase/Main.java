package DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connections connections = null;
        connections = new Connections();
        String query = "SELECT id, Name, Phone FROM users";

        try {
            Statement statement = connections.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getInt("Id"));
                user.setName(resultSet.getString("Name"));
//                user.setEmail(resultSet.getString("Email"));
//                user.setAge(resultSet.getInt("Age"));
                user.setPhone(resultSet.getInt("Phone"));

                System.out.println(user);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
