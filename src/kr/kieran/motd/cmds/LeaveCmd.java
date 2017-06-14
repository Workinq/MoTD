package kr.kieran.motd.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import kr.kieran.motd.Main;
import net.md_5.bungee.api.ChatColor;

public class LeaveCmd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (!(sender instanceof Player)) {
			sender.sendMessage("Only in-game players can use this command.");
		} else {
			if (!sender.hasPermission("motd.leave")) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
						Main.get().getConfig().getString("prefix") + " " + Main.get().getConfig().getString("noperm")));
			} else {
				if (cmd.getName().equalsIgnoreCase("leave")) {
					p.kickPlayer(ChatColor.translateAlternateColorCodes('&', Main.get().getConfig().getString("prefix")
							+ " " + Main.get().getConfig().getString("logoutmsg")));
					return true;
				}
			}
		}
		return true;
	}
}