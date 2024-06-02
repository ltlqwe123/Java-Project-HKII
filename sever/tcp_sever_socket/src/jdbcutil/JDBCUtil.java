package jdbcutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static Connection getConnection(){
        Connection c = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            String url= "jdbc:mysql://localhost:3306/?user=root";
            String userName = "root";
            String passWord = "@Santo.22";

            c = DriverManager.getConnection(url, userName, passWord);

        }catch (SQLException e){
            e.printStackTrace();
        }
        return c;
    }

    public static void closeConnection(Connection c){
        try {
            if (c != null){
                c.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
