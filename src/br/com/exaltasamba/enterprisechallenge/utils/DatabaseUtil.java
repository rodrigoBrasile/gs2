package br.com.exaltasamba.enterprisechallenge.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://avnadmin:AVNS_s0-yY6ssoExBf3r-fgn@enterprise-challenge-digo-a0d1.aivencloud.com:15825/defaultdb?ssl-mode=REQUIRED";
    private static final String USER = "avnadmin";
    private static final String PASSWORD = "AVNS_s0-yY6ssoExBf3r-fgn";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Outros métodos úteis, como fechar conexões, statements, etc.
}
