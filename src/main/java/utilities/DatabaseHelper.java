package utilities;

import java.sql.*;
import java.util.Properties;

public class DatabaseHelper {
    private static final String SERVER = "10.20.73.5";
    private static final String PORT = "1433";
    private static final String DATABASE = "TalyConsumer";
    private static final String USER = "zaid.amr";
    private static final String PASSWORD = "zaid.amr";

    /**
     * Creates a database connection with explicit SQL Server Authentication
     * Workaround for when login's default database is different from target database
     */
    private Connection getConnection() throws SQLException {
        // Method 1: Try connecting without specifying database, let it use default
        String urlNoDb = String.format(
                "jdbc:sqlserver://%s:%s;encrypt=false;trustServerCertificate=true;",
                SERVER, PORT
        );

        Properties props = new Properties();
        props.setProperty("user", USER);
        props.setProperty("password", PASSWORD);
        props.setProperty("loginTimeout", "30");

        System.out.println("🔗 Attempting connection...");
        System.out.println("👤 User: " + USER);

        Connection conn = null;

        try {
            // Connect using default database (master)
            conn = DriverManager.getConnection(urlNoDb, props);
            System.out.println("✅ Connected to default database");

            // Switch to target database
            try (Statement stmt = conn.createStatement()) {
                stmt.execute("USE [" + DATABASE + "]");
                System.out.println("✅ Switched to database: " + DATABASE);
            }
            return conn;

        } catch (SQLException e1) {
            System.out.println("⚠️ Method 1 failed: " + e1.getMessage());

            // Method 2: Try connecting directly to master, then switch
            try {
                String urlMaster = String.format(
                        "jdbc:sqlserver://%s:%s;databaseName=master;encrypt=false;trustServerCertificate=true;",
                        SERVER, PORT
                );

                System.out.println("🔗 Trying to connect to master database explicitly...");
                conn = DriverManager.getConnection(urlMaster, props);
                System.out.println("✅ Connected to master");

                // Switch to target database
                try (Statement stmt = conn.createStatement()) {
                    stmt.execute("USE [" + DATABASE + "]");
                    System.out.println("✅ Switched to database: " + DATABASE);
                }
                return conn;

            } catch (SQLException e2) {
                System.out.println("⚠️ Method 2 failed: " + e2.getMessage());

                // Method 3: Try connecting directly to TalyConsumer (requires user mapping)
                try {
                    String urlDirect = String.format(
                            "jdbc:sqlserver://%s:%s;databaseName=%s;encrypt=false;trustServerCertificate=true;",
                            SERVER, PORT, DATABASE
                    );

                    System.out.println("🔗 Trying direct connection to " + DATABASE + "...");
                    conn = DriverManager.getConnection(urlDirect, props);
                    System.out.println("✅ Connected directly to " + DATABASE);
                    return conn;

                } catch (SQLException e3) {
                    System.out.println("❌ All connection methods failed!");
                    System.out.println("Please ask your DBA to:");
                    System.out.println("1. Create user mapping: USE master; CREATE USER [zaid.amr] FOR LOGIN [zaid.amr];");
                    System.out.println("2. Or change default database: ALTER LOGIN [zaid.amr] WITH DEFAULT_DATABASE = [TalyConsumer];");
                    throw e3;
                }
            }
        }
    }

    /**
     * Tests if the connection to the database works
     */
    public boolean testConnection() {
        try (Connection conn = getConnection()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("✅ Connection successful!");
                System.out.println("📊 Database: " + conn.getCatalog());
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println("❌ Connection failed!");
            System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Message: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Retrieves the latest OTP for a given username
     */
    public String getLatestOTP(String username) {
        String otp = null;
        String query = "SELECT TOP 1 [VerificationToken] " +
                "FROM [dbo].[UserAuthentication] " +
                "WHERE [Username] = ? " +
                "ORDER BY [CreatedDate] DESC";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            System.out.println("🔍 Searching OTP for user: " + username);
            stmt.setString(1, username);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    otp = rs.getString("VerificationToken");
                    System.out.println("✅ OTP retrieved successfully: " + otp);
                } else {
                    System.out.println("⚠️ No OTP found for user: " + username);
                    throw new RuntimeException("❌ OTP not found in database for user: " + username);
                }
            }
        } catch (SQLException e) {
            System.out.println("❌ Database error while fetching OTP");
            System.out.println("Error: " + e.getMessage());
            throw new RuntimeException("❌ Database error: " + e.getMessage(), e);
        }

        return otp;
    }

    /**
     * Retrieves the latest OTP with retry logic
     * @param username The username to search for
     * @param maxRetries Maximum number of retry attempts
     * @param waitSeconds Wait time between retries in seconds
     */
    public String getLatestOTPWithRetry(String username, int maxRetries, int waitSeconds) {
        System.out.println("🔄 Starting OTP retrieval with retry logic");
        System.out.println("   Max retries: " + maxRetries);
        System.out.println("   Wait between retries: " + waitSeconds + " seconds");

        for (int i = 0; i < maxRetries; i++) {
            try {
                String otp = getLatestOTP(username);
                if (otp != null && !otp.isEmpty()) {
                    System.out.println("✅ OTP retrieved on attempt " + (i + 1));
                    return otp;
                }
            } catch (RuntimeException e) {
                System.out.println("⏳ Attempt " + (i + 1) + "/" + maxRetries + " - " + e.getMessage());
            }

            // Wait before next retry (except on last attempt)
            if (i < maxRetries - 1) {
                try {
                    System.out.println("⏱️ Waiting " + waitSeconds + " seconds before retry...");
                    Thread.sleep(waitSeconds * 1000L);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("❌ Thread interrupted", e);
                }
            }
        }

        throw new RuntimeException("❌ OTP not found after " + maxRetries + " attempts for user: " + username);
    }

    /**
     * Main method for testing database connection and OTP retrieval
     */
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════");
        System.out.println("  DATABASE CONNECTION TEST");
        System.out.println("═══════════════════════════════════════");

        DatabaseHelper db = new DatabaseHelper();

        // Test 1: Connection Test
        System.out.println("\n[TEST 1] Testing Database Connection...");
        System.out.println("Server: " + SERVER + ":" + PORT);
        System.out.println("Database: " + DATABASE);
        System.out.println("User: " + USER);
        System.out.println("---");

        if (!db.testConnection()) {
            System.out.println("\n❌ Connection test failed! Fix connection issues first.");
            return;
        }

        // Test 2: OTP Retrieval Test
        System.out.println("\n[TEST 2] Testing OTP Retrieval...");
        System.out.println("---");

        try {
            String testUser = "ziadamr200+BR_Maker@gmail.com";
            String otp = db.getLatestOTP(testUser);
            System.out.println("\n✅ SUCCESS! OTP retrieved: " + otp);
        } catch (Exception e) {
            System.out.println("\n❌ FAILED! " + e.getMessage());
        }

        System.out.println("\n═══════════════════════════════════════");
    }
}