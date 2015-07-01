package me.WingedMLGPro.Commands;

import me.WingedMLGPro.API.StatsAPI;
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
 * © at 19/04/15 at 7:22 PM
 */
public class Leaderboards implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player)sender;

        if (cmd.getName().equalsIgnoreCase("topKills")){
            p.sendMessage(StatsAPI.getTop("BAKills", 10));
        }
        if (cmd.getName().equalsIgnoreCase("topDeaths")){
            p.sendMessage(StatsAPI.getTop("BADeaths", 10));
        }
        if (cmd.getName().equalsIgnoreCase("topStreak")){
            p.sendMessage(StatsAPI.getTop("BAHighestKillStreak", 10));
        }
        return true;
    }
}
