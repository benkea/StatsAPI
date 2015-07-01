package me.WingedMLGPro.Listeners;

import me.WingedMLGPro.API.StatsAPI;
import me.WingedMLGPro.Commands.Stats;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 * © This Document and Code is STRICTLY copyrited(©) to Ben.
 * © If anyone takes any part of this code and uses it for
 * © Something public, Share with someone, uses it for API's,
 * © implementing it to their code and taking the rights for
 * © it is NOT allowed unless you get permission from me!
 * © This project StatsAPI was created by 35047
 * © at 19/04/15 at 9:55 AM
 */
public class LoginListener implements Listener {

    @EventHandler
    public void onLogin(PlayerLoginEvent e){
        StatsAPI stats = new StatsAPI();
        Player p = e.getPlayer();
        if (stats.getBAKills(p)==null){
            stats.setBAKills(p, 0);
        }
        if (stats.getBADeaths(p)==null){
            stats.setBADeaths(p, 0);
        }
        if (stats.getBAKillStreak(p)==null){
            stats.setBAKillStreak(p, 0);
        }
        if (stats.getBAHKillStreak(p)==null){
            stats.setBAHKillStreak(p, 0);
        }
        if (StatsAPI.getUHCWins(p)==null){
            StatsAPI.setUHCWins(0, p);
        }
        if (StatsAPI.getUHCKills(p)==null){
            StatsAPI.setUHCKills(0, p);
        }
        if (StatsAPI.getUHCDeaths(p)==null){
            StatsAPI.setUHCDeaths(0, p);
        }
        if (StatsAPI.getUHCHeadsEaten(p)==null){
            StatsAPI.setUHCHeadsEaten(0, p);
        }
        if (StatsAPI.getUHCGamesPlayed(p)==null){
            StatsAPI.setUHCGamesPlayed(0, p);
        }
    }

}
