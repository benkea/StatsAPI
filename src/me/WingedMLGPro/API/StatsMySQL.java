package me.WingedMLGPro.API;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * © This Document and Code is STRICTLY copyrited(©) to Ben.
 * © If anyone takes any part of this code and uses it for
 * © Something public, Share with someone, uses it for API's,
 * © implementing it to their code and taking the rights for
 * © it is NOT allowed unless you get permission from me!
 * © This project StatsAPI was created by 35047
 * © at 19/04/15 at 8:57 AM
 */
public class StatsMySQL {

    private static Connection connection;
    public static String username = "mc21425";
    public static String password = "ac849ef462";
    public static String database = "mc21425";
    public static String host = "23.94.114.66";
    public static String port = "3306";

    public static void connect() {
        if (!isConnected())
            try {
                connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public static void close()
    {
        if (isConnected())
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public static void update(String qry)
    {
        if (isConnected())
            try {
                connection.createStatement().executeUpdate(qry);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public static ResultSet getResult(String qry)
    {
        if (isConnected()) {
            try {
                return connection.createStatement().executeQuery(qry);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static boolean isConnected() {
        return connection != null;
    }

    public static void createTable() {
        if (isConnected())
            try {
                connection.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS SwiftyStats (UUID VARCHAR(100), PlayerName VARCHAR(100), BAKills INT(10), BADeaths INT(10), BAKillStreak INT(10), BAHighestKillStreak INT(10), UHCWins INT(10), UHCKills INT(10), UHCDeaths INT(10),UHCHeadsEaten INT(10), UHCGapplesEaten INT(10), UHCGamesPlayed INT(10))");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
