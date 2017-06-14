package kr.kieran.motd.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import kr.kieran.motd.Main;
import net.md_5.bungee.api.ChatColor;

public class JoinListener implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&',
				Main.get().getConfig().getString("message", "§cConfig.yml file error.")));
	}
	
}