package atharva;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

    static Connection con; // to store connection

    public static Connection createC() {
        try {
            // to load driver
           Class.forName("com.mysql.jdbc.Driver");

//            //to create connection
//
//
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atharva", "root","Diya@1808");
            System.out.println("Connected to database 😊 ");

        }
       catch(Exception e) {
           e.printStackTrace();
        }
        return con;
    }
}
