package business.config;

import java.sql.*;

public class ConnectionDB {
    private static String Driver = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/StudentList";
    private static String UserNameDB = "root";
    private static String PasswordDB = "123456";

    public static Connection openConnection() {
        Connection con = null;
        try {
            Class.forName(Driver);
            con = DriverManager.getConnection(URL, UserNameDB, PasswordDB);
        } catch (SQLException sqp) {
            System.out.println("Loi xay ra trong qua trinh ket noi " + sqp.getMessage());
        } catch (Exception e) {
            System.out.println("Loi khong xac dinh xay ra trong qua trinh ket noi " + e.getMessage());
        }
        return con;
    }
    public static void closeConnection(Connection con, CallableStatement stmt) {
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
