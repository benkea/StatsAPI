package me.WingedMLGPro.API;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * © This Document and Code is STRICTLY copyrited(©) to Ben.
 * © If anyone takes any part of this code and uses it for
 * © Something public, Share with someone, uses it for API's,
 * © implementing it to their code and taking the rights for
 * © it is NOT allowed unless you get permission from me!
 * © This project StatsAPI was created by 35047
 * © at 19/04/15 at 9:02 AM
 */
public class StatsAPI {

    public static String[] getTop(String type, int amount){
        String[] array = new String[amount];
        ResultSet rs = StatsMySQL.getResult("SELECT * FROM SwiftyStats ORDER BY CONVERT(" + type.toLowerCase() + ", UNSIGNED INTEGER) DESC LIMIT " + amount);
        try {
            int counter = 0;
            while (rs.next()) {
                array[counter] = rs.getString("PlayerName") + ": §a" + rs.getInt(type.toLowerCase());
                counter++;
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return array;
    }

    public static Integer getBAKills(Player p){

        ResultSet rs = StatsMySQL.getResult("SELECT BAKills FROM SwiftyStats WHERE UUID='" + p.getUniqueId() + "'");
        try {
            if (rs.next()){
                return rs.getInt("BAKills");
            }
            return null;
        } catch (Exception e){
            Bukkit.getLogger().severe("§4Can not Get Kills!");
        }
        return 0;
    }
    public static Integer getBADeaths(Player p){

        ResultSet rs = StatsMySQL.getResult("SELECT BADeaths FROM SwiftyStats WHERE UUID='" + p.getUniqueId() + "'");
        try {
            if (rs.next()){
                return rs.getInt("BADeaths");
            }
            return null;
        } catch (Exception e){
            Bukkit.getLogger().severe("§4Can not Get Deaths!");
        }
        return 0;
    }
    public static Integer getBAKillStreak(Player p){

        ResultSet rs = StatsMySQL.getResult("SELECT BAKillStreak FROM SwiftyStats WHERE UUID='" + p.getUniqueId() + "'");
        try {
            if (rs.next()){
                return rs.getInt("BAKillStreak");
            }
            return null;
        } catch (Exception e){
            Bukkit.getLogger().severe("§4Can not Get KillStreak!");
        }
        return 0;
    }
    public static Integer getBAHKillStreak(Player p){

        ResultSet rs = StatsMySQL.getResult("SELECT BAHighestKillStreak FROM SwiftyStats WHERE UUID='" + p.getUniqueId() + "'");
        try {
            if (rs.next()){
                return rs.getInt("BAHighestKillStreak");
            }
            return null;
        } catch (Exception e){
            Bukkit.getLogger().severe("§4Can not Get Highest KillStreak!");
        }
        return 0;
    }
    public static void setBAKills(Player p, int kills){
        if (getBAKills(p)==null){
            StatsMySQL.update("INSERT INTO `SwiftyStats`(`UUID`, `PlayerName`, `BAKills`) VALUES ('"+p.getUniqueId()+"','"+p.getName()+"','"+kills+"')");
        }
        else if (getBAKills(p) != null){
            StatsMySQL.update("UPDATE `SwiftyStats` SET `UUID`='" + p.getUniqueId() + "',`PlayerName`='" + p.getName() + "',`BAKills`='" + kills + "' WHERE uuid='" + p.getUniqueId() + "'");
        }
    }
    public static void setBADeaths(Player p, int deaths){
        if (getBADeaths(p)==null){
            StatsMySQL.update("INSERT INTO `SwiftyStats`(`UUID`, `PlayerName`, `BADeaths`) VALUES ('"+p.getUniqueId()+"','"+p.getName()+"','"+deaths+"')");
        }
        else if (getBADeaths(p) != null){
            StatsMySQL.update("UPDATE `SwiftyStats` SET `UUID`='" + p.getUniqueId() + "',`PlayerName`='" + p.getName() + "',`BADeaths`='" + deaths + "' WHERE uuid='" + p.getUniqueId() + "'");
        }
    }
    public static void setBAKillStreak(Player p, int killstreak){
        if (getBAKillStreak(p)==null){
            StatsMySQL.update("INSERT INTO `SwiftyStats`(`UUID`, `PlayerName`, `BAKillStreak`) VALUES ('"+p.getUniqueId()+"','"+p.getName()+"','"+killstreak+"')");
        }
        else if (getBAKillStreak(p) != null){
            StatsMySQL.update("UPDATE `SwiftyStats` SET `UUID`='" + p.getUniqueId() + "',`PlayerName`='" + p.getName() + "',`BAKillStreak`='" + killstreak + "' WHERE uuid='" + p.getUniqueId() + "'");
        }
    }
    public static void setBAHKillStreak(Player p, int hkillstreak){
        if (getBAHKillStreak(p)==null){
            StatsMySQL.update("INSERT INTO `SwiftyStats`(`UUID`, `PlayerName`, `BAHighestKillStreak`) VALUES ('"+p.getUniqueId()+"','"+p.getName()+"','"+hkillstreak+"')");
        }
        else if (getBAHKillStreak(p) != null){
            StatsMySQL.update("UPDATE `SwiftyStats` SET `UUID`='" + p.getUniqueId() + "',`PlayerName`='" + p.getName() + "',`BAHighestKillStreak`='" + hkillstreak + "' WHERE uuid='" + p.getUniqueId() + "'");
        }
    }
    public static void addBAKills(Player p, int amount){
        if (getBAKills(p)==null){
            StatsMySQL.update("INSERT INTO `SwiftyStats`(`UUID`, `PlayerName`, `BAKills`) VALUES ('"+p.getUniqueId()+"','"+p.getName()+"','"+amount+"')");
        }
        else {
            int num = getBAKills(p) + amount;
            StatsMySQL.update("UPDATE `SwiftyStats` SET `UUID`='" + p.getUniqueId() + "',`PlayerName`='" + p.getName() + "',`BAKills`='" + num + "' WHERE uuid='" + p.getUniqueId() + "'");
        }
    }
    public static void addBADeaths(Player p, int amount){
        if (getBADeaths(p)==null){
            StatsMySQL.update("INSERT INTO `SwiftyStats`(`UUID`, `PlayerName`, `BADeaths`) VALUES ('"+p.getUniqueId()+"','"+p.getName()+"','"+amount+"')");
        }
        else {
            int num = getBADeaths(p) + amount;
            StatsMySQL.update("UPDATE `SwiftyStats` SET `UUID`='" + p.getUniqueId() + "',`PlayerName`='" + p.getName() + "',`BADeaths`='" + num + "' WHERE uuid='" + p.getUniqueId() + "'");
        }
    }
    public static void addBAKillStreak(Player p, int amount){
        if (getBAKillStreak(p)==null){
            StatsMySQL.update("INSERT INTO `SwiftyStats`(`UUID`, `PlayerName`, `BAKillStreak`) VALUES ('"+p.getUniqueId()+"','"+p.getName()+"','"+amount+"')");
        }
        else {
            int num = getBAKillStreak(p) + amount;
            StatsMySQL.update("UPDATE `SwiftyStats` SET `UUID`='" + p.getUniqueId() + "',`PlayerName`='" + p.getName() + "',`BAKillStreak`='" + num + "' WHERE uuid='" + p.getUniqueId() + "'");
        }
    }
    public static void addBAHKillStreak(Player p, int amount){
        if (getBAHKillStreak(p)==null){
            StatsMySQL.update("INSERT INTO `SwiftyStats`(`UUID`, `PlayerName`, `BAHighestKillStreak`) VALUES ('"+p.getUniqueId()+"','"+p.getName()+"','"+amount+"')");
        }
        else {
            int num = getBAHKillStreak(p) + amount;
            StatsMySQL.update("UPDATE `SwiftyStats` SET `UUID`='" + p.getUniqueId() + "',`PlayerName`='" + p.getName() + "',`BAHighestKillStreak`='" + num + "' WHERE uuid='" + p.getUniqueId() + "'");
        }
    }

    public static Integer getUHCWins(Player p){
        ResultSet rs = StatsMySQL.getResult("SELECT UHCWins FROM SwiftyStats WHERE UUID='"+p.getUniqueId()+"'");
        try {
            if (rs.next()) {
                return rs.getInt("UHCWins");
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static Integer getUHCKills(Player p){
        ResultSet rs = StatsMySQL.getResult("SELECT UHCKills FROM SwiftyStats WHERE UUID='"+p.getUniqueId()+"'");
        try {
            if (rs.next()) {
                return rs.getInt("UHCKills");
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static Integer getUHCDeaths(Player p){
        ResultSet rs = StatsMySQL.getResult("SELECT UHCDeaths FROM SwiftyStats WHERE UUID='"+p.getUniqueId()+"'");
        try {
            if (rs.next()) {
                return rs.getInt("UHCDeaths");
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static Integer getUHCHeadsEaten(Player p){
        ResultSet rs = StatsMySQL.getResult("SELECT UHCHeadsEaten FROM SwiftyStats WHERE UUID='"+p.getUniqueId()+"'");
        try {
            if (rs.next()) {
                return rs.getInt("UHCHeadsEaten");
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static Integer getUHCGamesPlayed(Player p){
        ResultSet rs = StatsMySQL.getResult("SELECT UHCGamesPlayed FROM SwiftyStats WHERE UUID='"+p.getUniqueId()+"'");
        try {
            if (rs.next()) {
                return rs.getInt("UHCGamesPlayed");
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public static void setUHCWins(int wins, Player p){
        if (getUHCWins(p)==null){
            StatsMySQL.update("INSERT INTO `SwiftyStats`(`UUID`, `PlayerName`, `UHCWins`) VALUES ('"+p.getUniqueId()+"','"+p.getName()+"','"+wins+"')");
        }
        else if (getUHCWins(p)!=null){
            StatsMySQL.update("UPDATE `SwiftyStats` SET `UUID`='"+p.getUniqueId()+"',`PlayerName`='"+p.getName()+"',`UHCWins`='"+wins+"' WHERE UUID='"+p.getUniqueId()+"'");
        }
    }
    public static void setUHCKills(int kills, Player p){
        if (getUHCKills(p)==null){
            StatsMySQL.update("INSERT INTO `SwiftyStats`(`UUID`, `PlayerName`, `UHCKills`) VALUES ('"+p.getUniqueId()+"','"+p.getName()+"','"+kills+"')");
        }
        else if (getUHCKills(p)!=null){
            StatsMySQL.update("UPDATE `SwiftyStats` SET `UUID`='"+p.getUniqueId()+"',`PlayerName`='"+p.getName()+"',`UHCKills`='"+kills+"' WHERE UUID='"+p.getUniqueId()+"'");
        }
    }
    public static void setUHCDeaths(int deaths, Player p){
        if (getUHCDeaths(p)==null){
            StatsMySQL.update("INSERT INTO `SwiftyStats`(`UUID`, `PlayerName`, `UHCDeaths`) VALUES ('"+p.getUniqueId()+"','"+p.getName()+"','"+deaths+"')");
        }
        else if (getUHCDeaths(p)!=null){
            StatsMySQL.update("UPDATE `SwiftyStats` SET `UUID`='"+p.getUniqueId()+"',`PlayerName`='"+p.getName()+"',`UHCDeaths`='"+deaths+"' WHERE UUID='"+p.getUniqueId()+"'");
        }
    }
    public static void setUHCHeadsEaten(int headsEaten, Player p){
        if (getUHCHeadsEaten(p)==null){
            StatsMySQL.update("INSERT INTO `SwiftyStats`(`UUID`, `PlayerName`, `UHCHeadsEaten`) VALUES ('"+p.getUniqueId()+"','"+p.getName()+"','"+headsEaten+"')");
        }
        else if (getUHCHeadsEaten(p)!=null){
            StatsMySQL.update("UPDATE `SwiftyStats` SET `UUID`='"+p.getUniqueId()+"',`PlayerName`='"+p.getName()+"',`UHCHeadsEaten`='"+headsEaten+"' WHERE UUID='"+p.getUniqueId()+"'");
        }
    }
    public static void setUHCGamesPlayed(int gamesPlayed, Player p){
        if (getUHCGamesPlayed(p)==null){
            StatsMySQL.update("INSERT INTO `SwiftyStats`(`UUID`, `PlayerName`, `UHCGamesPlayed`) VALUES ('"+p.getUniqueId()+"','"+p.getName()+"','"+gamesPlayed+"')");
        }
        else if (getUHCGamesPlayed(p)!=null){
            StatsMySQL.update("UPDATE `SwiftyStats` SET `UUID`='"+p.getUniqueId()+"',`PlayerName`='"+p.getName()+"',`UHCGamesPlayed`='"+gamesPlayed+"' WHERE UUID='"+p.getUniqueId()+"'");
        }
    }
    public static void addUHCWins(int amount, Player p){
        if (getUHCWins(p)==null){
            StatsMySQL.update("INSERT INTO `SwiftyStats`(`UUID`, `PlayerName`, `UHCWins`) VALUES ('"+p.getUniqueId()+"','"+p.getName()+"','"+amount+"')");
        }
        else if (getUHCWins(p)!=null){
            int wins = getUHCWins(p) + amount;
            StatsMySQL.update("UPDATE `SwiftyStats` SET `UUID`='"+p.getUniqueId()+"',`PlayerName`='"+p.getName()+"',`UHCWins`='"+wins+"' WHERE UUID='"+p.getUniqueId()+"'");
        }
    }
    public static void addUHCKills(int amount, Player p){
        if (getUHCKills(p)==null){
            StatsMySQL.update("INSERT INTO `SwiftyStats`(`UUID`, `PlayerName`, `UHCKills`) VALUES ('"+p.getUniqueId()+"','"+p.getName()+"','"+amount+"')");
        }
        else if (getUHCKills(p)!=null){
            int kills = getUHCKills(p) + amount;
            StatsMySQL.update("UPDATE `SwiftyStats` SET `UUID`='"+p.getUniqueId()+"',`PlayerName`='"+p.getName()+"',`UHCKills`='"+kills+"' WHERE UUID='"+p.getUniqueId()+"'");
        }
    }
    public static void addUHCDeaths(int amount, Player p){
        if (getUHCDeaths(p)==null){
            StatsMySQL.update("INSERT INTO `SwiftyStats`(`UUID`, `PlayerName`, `UHCDeaths`) VALUES ('"+p.getUniqueId()+"','"+p.getName()+"','"+amount+"')");
        }
        else if (getUHCDeaths(p)!=null){
            int deaths = getUHCDeaths(p) + amount;
            StatsMySQL.update("UPDATE `SwiftyStats` SET `UUID`='"+p.getUniqueId()+"',`PlayerName`='"+p.getName()+"',`UHCDeaths`='"+deaths+"' WHERE UUID='"+p.getUniqueId()+"'");
        }
    }
    public static void addUHCHeadsEaten(int amount, Player p){
        if (getUHCHeadsEaten(p)==null){
            StatsMySQL.update("INSERT INTO `SwiftyStats`(`UUID`, `PlayerName`, `UHCHeadsEaten`) VALUES ('"+p.getUniqueId()+"','"+p.getName()+"','"+amount+"')");
        }
        else if (getUHCHeadsEaten(p)!=null){
            int headsEaten = getUHCHeadsEaten(p) + amount;
            StatsMySQL.update("UPDATE `SwiftyStats` SET `UUID`='"+p.getUniqueId()+"',`PlayerName`='"+p.getName()+"',`UHCHeadsEaten`='"+headsEaten+"' WHERE UUID='"+p.getUniqueId()+"'");
        }
    }
    public static void addUHCGamesPlayed(int amount, Player p){
        if (getUHCGamesPlayed(p)==null){
            StatsMySQL.update("INSERT INTO `SwiftyStats`(`UUID`, `PlayerName`, `UHCGamesPlayed`) VALUES ('"+p.getUniqueId()+"','"+p.getName()+"','"+amount+"')");
        }
        else if (getUHCGamesPlayed(p)!=null){
            int gamesPlayed = getUHCGamesPlayed(p) + amount;
            StatsMySQL.update("UPDATE `SwiftyStats` SET `UUID`='"+p.getUniqueId()+"',`PlayerName`='"+p.getName()+"',`UHCGamesPlayed`='"+gamesPlayed+"' WHERE UUID='"+p.getUniqueId()+"'");
        }
    }
}
