package hospital.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

// Database connection class
public class conn {

    Connection connection;
    Statement statement;

    public conn(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system", "root", "@Host09server");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
