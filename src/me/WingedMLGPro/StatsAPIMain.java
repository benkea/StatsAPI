package me.WingedMLGPro;

import me.WingedMLGPro.API.StatsMySQL;
import me.WingedMLGPro.Commands.Leaderboards;
import me.WingedMLGPro.Commands.Stats;
import me.WingedMLGPro.Listeners.LoginListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * © This Document and Code is STRICTLY copyrited(©) to Ben.
 * © If anyone takes any part of this code and uses it for
 * © Something public, Share with someone, uses it for API's,
 * © implementing it to their code and taking the rights for
 * © it is NOT allowed unless you get permission from me!
 * © This project StatsAPI was created by 35047
 * © at 19/04/15 at 8:54 AM
 */
public class StatsAPIMain extends JavaPlugin {

    public static String StatsTag = "§6§lSwi§e§lfty §6Stats§7:";
    public static String Error = "§c§l/§4§l/ §6";
    public static String CantFindPlayer = Error+"Sorry, but we could not find the player ";
    public static String NoCONSOLE = Error+"Sorry, But the Console can't run this command!";
    public static String TAG = "§6§lSwi§e§lfty§6§l>§e§l>§r ";
    public static String TAG2 = "§6§l/§e§l/ ";
    public static String Arrows = "§e§l>§6§l> ";
    public static String SwiftyAnnounment = "§6§lSwi§e§lfty§6§l>§e§l>§r ";
    public static String PermCONSOLE = "§c§l/§4§l/ §cYou are not as cool as a Console, so stop trying to use this command!";
    public static String PermOWNER = "§c§l/§4§l/ §cYou are not as cool as a Owner, so stop trying to use this command!";
    public static String PermHEADADMIN = "§c§l/§4§l/ §cYou are not as cool as a HeadAdmin, so stop trying to use this command!";
    public static String PermAdmin = "§c§l/§4§l/ §cYou are not as cool as a Admin, so stop trying to use this command!";
    public static String PermMOD = "§c§l/§4§l/ §cYou are not as cool as a Mod, so stop trying to use this command!";
    public static String PermVIP = "§c§l/§4§l/ §cYou are not as cool as a VIP, so stop trying to use this command!";
    public static String PermHELPER = "§c§l/§4§l/ §cYou are not as cool as a Helper, so stop trying to use this command!";
    public static String PermIMMORTAL = "§c§l/§4§l/ §cYou are not as cool as a Immortal, so stop trying to use this command!";
    public static String PermLEGEND = "§c§l/§4§l/ §cYou are not as cool as a Legend, so stop trying to use this command!";
    public static String PermELITE = "§c§l/§4§l/ §cYou are not as cool as a Elite, so stop trying to use this command!";
    public static String PermHERO = "§c§l/§4§l/ §cYou are not as cool as a Hero, so stop trying to use this command!";
    public static String PermSergeant = "§c§l/§4§l/ §cYou are not as cool as a Sergeant, so stop trying to use this command!";

    static StatsAPIMain instance;

    public static StatsAPIMain getInstance(){
        return instance;
    }

    public void regCommands(){
        getCommand("stats").setExecutor(new Stats());
        getCommand("topKills").setExecutor(new Leaderboards());
        getCommand("topDeaths").setExecutor(new Leaderboards());
        getCommand("topStreak").setExecutor(new Leaderboards());
    }
    public void regListeners(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new LoginListener(), this);
    }

    @Override
    public void onEnable(){

        regCommands();

        regListeners();

        instance = this;

        StatsMySQL.connect();
        StatsMySQL.createTable();

    }
    @Override
    public void onDisable(){

        instance = null;


    }

}
