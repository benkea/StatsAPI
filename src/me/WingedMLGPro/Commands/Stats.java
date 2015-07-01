package me.WingedMLGPro.Commands;

import me.WingedMLGPro.API.OfflineStatsAPI;
import me.WingedMLGPro.API.StatsAPI;
import me.WingedMLGPro.StatsAPIMain;
import me.dylzqn.PlayerAPI.OfflineSwiftyPlayer;
import me.dylzqn.PlayerAPI.SwiftyPlayer;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * © This Document and Code is STRICTLY copyrited(©) to Ben.
 * © If anyone takes any part of this code and uses it for
 * © Something public, Share with someone, uses it for API's,
 * © implementing it to their code and taking the rights for
 * © it is NOT allowed unless you get permission from me!
 * © This project StatsAPI was created by 35047
 * © at 19/04/15 at 5:12 PM
 */
public class Stats implements CommandExecutor {

    // /stats <Server> <Player>

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("stats")) {
            if (args.length <= 1){
                p.sendMessage(StatsAPIMain.Error + "Usage: /stats <Server> <Player>");
                p.sendMessage(StatsAPIMain.Arrows+"§bAvailable Servers§7: §aUHC§7,§aBA");
                return true;
            }
            String server = args[0];
            Player target = Bukkit.getPlayer(args[1]);
            SwiftyPlayer tuser = new SwiftyPlayer(target);
            if ((!server.equalsIgnoreCase("BA") && !server.equalsIgnoreCase("UHC"))) {
                p.sendMessage(StatsAPIMain.Error + "Usage: /stats <Server> <Player>");
                p.sendMessage(StatsAPIMain.Arrows + "§bAvailable Servers§7: §aUHC§7,§aBA");
                return true;
            }
            if (target != null) {
                if (server.equalsIgnoreCase("UHC")) {
                    p.sendMessage(tuser.getRank() + " " + tuser.getRankColour() + " §6UHC Stats§7:");
                    p.sendMessage(StatsAPIMain.Arrows + "§bWins§7: §a" + StatsAPI.getUHCWins(target));
                    p.sendMessage(StatsAPIMain.Arrows + "§bKills§7: §a" + StatsAPI.getUHCKills(target));
                    p.sendMessage(StatsAPIMain.Arrows + "§bDeaths§7: §a" + StatsAPI.getUHCDeaths(target));
                    p.sendMessage(StatsAPIMain.Arrows + "§bHeads Eaten§7: §a" + StatsAPI.getUHCHeadsEaten(target));
                    p.sendMessage(StatsAPIMain.Arrows + "§bGames Played§7: §a" + StatsAPI.getUHCGamesPlayed(target));
                }
                if (server.equalsIgnoreCase("BA")) {
                    p.sendMessage(tuser.getRank() + " " + tuser.getRankColour() + " §6BA Stats§7:");
                    p.sendMessage(StatsAPIMain.Arrows + "§bKills§7: §a" + StatsAPI.getBAKills(target));
                    p.sendMessage(StatsAPIMain.Arrows + "§bDeaths§7: §a" + StatsAPI.getBADeaths(target));
                    p.sendMessage(StatsAPIMain.Arrows + "§bKillStreak§7: §a" + StatsAPI.getBAKillStreak(target));
                    p.sendMessage(StatsAPIMain.Arrows + "§bHighestKillStreak§7: §a" + StatsAPI.getBAHKillStreak(target));
                }
                return true;
            }
            else if (target == null){
                OfflinePlayer otarget = Bukkit.getOfflinePlayer(args[1]);
                OfflineSwiftyPlayer otuser = new OfflineSwiftyPlayer(otarget);
                if (server.equalsIgnoreCase("UHC")) {
                    p.sendMessage(otuser.getName()+" §r"+otuser.getName()+" §6UHC Stats§7:");
                    p.sendMessage(StatsAPIMain.Arrows + "§bWins§7: §a" + OfflineStatsAPI.getUHCWins(target));
                    p.sendMessage(StatsAPIMain.Arrows + "§bKills§7: §a" + OfflineStatsAPI.getUHCKills(target));
                    p.sendMessage(StatsAPIMain.Arrows + "§bDeaths§7: §a" + OfflineStatsAPI.getUHCDeaths(target));
                    p.sendMessage(StatsAPIMain.Arrows + "§bHeads Eaten§7: §a" + OfflineStatsAPI.getUHCHeadsEaten(target));
                    p.sendMessage(StatsAPIMain.Arrows + "§bGames Played§7: §a" + OfflineStatsAPI.getUHCGamesPlayed(target));
                }
                if (server.equalsIgnoreCase("BA")) {
                    p.sendMessage(tuser.getRank() + " " + tuser.getRankColour() + " §6BA Stats§7:");
                    p.sendMessage(StatsAPIMain.Arrows + "§bKills§7: §a" + OfflineStatsAPI.getBAKills(target));
                    p.sendMessage(StatsAPIMain.Arrows + "§bDeaths§7: §a" + OfflineStatsAPI.getBADeaths(target));
                    p.sendMessage(StatsAPIMain.Arrows + "§bKillStreak§7: §a" + OfflineStatsAPI.getBAKillStreak(target));
                    p.sendMessage(StatsAPIMain.Arrows + "§bHighestKillStreak§7: §a" + OfflineStatsAPI.getBAHKillStreak(target));
                }
            }
        }
        return true;
    }
}
