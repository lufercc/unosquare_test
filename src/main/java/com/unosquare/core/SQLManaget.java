package com.unosquare.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLManaget {
    private static String url = Environment.getInstance().getValue("sqlconnect.urlserver");
    private static String database = Environment.getInstance().getValue("sqlconnect.urlserver");
    private static String usr = Environment.getInstance().getValue("sqlconnect.user");
    private static String pw = Environment.getInstance().getValue("sqlconnect.password");

    public static void sqlQuery(String sqlQuery) {
        String connectionUrl =
                "jdbc:sqlserver:" + url + ";"
                        + "database=" + database + ";"
                        + "user=" + usr + ";"
                        + "password=" + pw + ";"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl);
             Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = sqlQuery;
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2) + " " + resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
