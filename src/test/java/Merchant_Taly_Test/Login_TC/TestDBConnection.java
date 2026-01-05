package Merchant_Taly_Test.Login_TC;

import java.sql.*;

public class TestDBConnection {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://10.20.73.5:1433;databaseName=TalyConsumer;encrypt=true;trustServerCertificate=true";
        String user = "zaid.amr";
        String password = "zaid.amr";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("✅ Connected successfully!");
        } catch (SQLException e) {
            System.out.println("❌ Connection failed: " + e.getMessage());
        }
    }
}
