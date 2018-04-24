package sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Connect  {
    private final static String userName = "root";
    private final static String pass = "12345";
    private final static String connUrl = "jdbc:mysql://localhost:3306/mydb";
    private  static Connection conn;
    private  static  Statement stmt;
    private  static ResultSet rs;

    public void connect() {
        try {
            conn = DriverManager.getConnection(connUrl, userName, pass);
            stmt = conn.createStatement();
            System.out.println("Connection was successful.");
            rs = stmt.executeQuery("select * FROM Student;");
            while (rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("Surname"));
                System.out.println("______________");
            }
            System.out.println("Запрос виконаний!");
        }
        catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        finally {
            //close connection ,stmt and resultset here
            try { conn.close(); } catch(SQLException se) {}
            try { stmt.close(); } catch(SQLException se) {}
}
    }




            }
