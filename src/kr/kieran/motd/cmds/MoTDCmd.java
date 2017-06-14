package kr.kieran.motd.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import kr.kieran.motd.Main;
import net.md_5.bungee.api.ChatColor;

public class MoTDCmd implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!sender.hasPermission("motd.motd")) {
			sender.sendMessage("§e§lMoTD version " + Main.get().getConfig().getString("version"));
		} else {
			if (cmd.getName().equalsIgnoreCase("motd")) {
				if (args.length == 0) {
					sender.sendMessage(
							ChatColor.translateAlternateColorCodes('&', Main.get().getConfig().getString("motdhelp1")));
					sender.sendMessage(
							ChatColor.translateAlternateColorCodes('&', Main.get().getConfig().getString("motdhelp2")));
					sender.sendMessage(
							ChatColor.translateAlternateColorCodes('&', Main.get().getConfig().getString("motdhelp3")));
					sender.sendMessage(
							ChatColor.translateAlternateColorCodes('&', Main.get().getConfig().getString("motdhelp4")));
					sender.sendMessage(
							ChatColor.translateAlternateColorCodes('&', Main.get().getConfig().getString("motdhelp5")));
					sender.sendMessage(
							ChatColor.translateAlternateColorCodes('&', Main.get().getConfig().getString("motdhelp6")));
					sender.sendMessage(
							ChatColor.translateAlternateColorCodes('&', Main.get().getConfig().getString("motdhelp7")));
					sender.sendMessage(
							ChatColor.translateAlternateColorCodes('&', Main.get().getConfig().getString("motdhelp8")));
					return true;
				}
				if (!sender.hasPermission("motd.set")) {
					sender.sendMessage(
							ChatColor.translateAlternateColorCodes('&', Main.get().getConfig().getString("prefix") + " "
									+ Main.get().getConfig().getString("noperm")));
				} else {
					if (args[0].equalsIgnoreCase("set")) {
						if (args.length == 1) {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
									Main.get().getConfig().getString("prefix") + " "
											+ Main.get().getConfig().getString("nomotdprovided")));
							return true;
						}
						String message = "";
						for (int i = 1; i < args.length; i++) {
							message += args[i] + " ";
						}
						message = message.trim();
						Main.get().getConfig().set("message", message);
						Main.get().saveDefaultConfig();
						Main.get().reloadConfig();
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								Main.get().getConfig().getString("prefix") + " "
										+ Main.get().getConfig().getString("motdsetto") + " "
										+ Main.get().getConfig().getString("message")));
					} else {
						if (!sender.hasPermission("motd.help")) {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
									Main.get().getConfig().getString("prefix") + " "
											+ Main.get().getConfig().getString("noperm")));
						} else {
							if (args[0].equalsIgnoreCase("help")) {
								sender.sendMessage(
										"§e§m------§r§f§m[§e§m----§r§f[ §e§lMoTD §r§f]§e§m----§f§m]§r§e§m------");
								sender.sendMessage(
										"§e/motd help §r§7- Displays help page. (This page you are seeing now).");
								sender.sendMessage(
										"§e/motd set <message> §r§7- Set's the message sent to players when they join the server.");
								sender.sendMessage(
										"§e/motd clear §r§7- Clears the message sent to players when they join the server.");
								sender.sendMessage(
										"§e/motd reload §r§7- Reloads the config.yml in-case you changed the message manually.");
								sender.sendMessage(
										"§e/motd play §r§7- Messages you the current MoTD saved to the config.yml.");
								sender.sendMessage("§e/motd play §r§7- Displays the current version of MoTD.");
								sender.sendMessage(
										"§e§m------§r§f§m[§e§m----§r§f[ §e§lMoTD §r§f]§e§m----§f§m]§r§e§m------");
							} else {
								if (!sender.hasPermission("motd.reload")) {
									sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
											Main.get().getConfig().getString("prefix") + " "
													+ Main.get().getConfig().getString("noperm")));
								} else {
									if (args[0].equalsIgnoreCase("reload")) {
										Main.get().reloadConfig();
										sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
												Main.get().getConfig().getString("prefix") + " "
														+ Main.get().getConfig().getString("configrel")));
										return true;
									} else {
										if (!sender.hasPermission("motd.clear")) {
											sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
													Main.get().getConfig().getString("prefix") + " "
															+ Main.get().getConfig().getString("noperm")));
										} else {
											if (args[0].equalsIgnoreCase("clear")) {
												String message = "";
												Main.get().getConfig().set("message", message);
												Main.get().saveConfig();
												Main.get().reloadConfig();
												sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
														Main.get().getConfig().getString("prefix") + " "
																+ Main.get().getConfig().getString("motdclear")));
											} else {
												if (!sender.hasPermission("motd.play")) {
													sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
															Main.get().getConfig().getString("prefix") + " "
																	+ Main.get().getConfig().getString("noperm")));
												} else {
													if (args[0].equalsIgnoreCase("play")) {
														if (Main.get().getConfig().getString("message").equals("")) {
															sender.sendMessage(
																	ChatColor.translateAlternateColorCodes('&',
																			Main.get().getConfig().getString("prefix")
																					+ " " + Main.get().getConfig()
																							.getString("nomotd")));
														} else {
															sender.sendMessage(ChatColor.translateAlternateColorCodes(
																	'&', Main.get().getConfig().getString("message",
																			"§cConfig.yml file error.")));
															return true;
														}
													} else {
														if (!sender.hasPermission("motd.version")) {
															sender.sendMessage(
																	ChatColor.translateAlternateColorCodes('&',
																			Main.get().getConfig().getString("prefix")
																					+ " " + Main.get().getConfig()
																							.getString("noperm")));
														}
														if (args[0].equalsIgnoreCase("version")) {
															sender.sendMessage(ChatColor.translateAlternateColorCodes(
																	'&',
																	Main.get().getConfig().getString("prefix") + " "
																			+ Main.get().getConfig()
																					.getString("motdversion")
																			+ " " + Main.get().getConfig()
																					.getString("version")));
														} else {
															sender.sendMessage(
																	ChatColor.translateAlternateColorCodes('&',
																			Main.get().getConfig().getString("prefix")
																					+ " " + Main.get().getConfig()
																							.getString("invalidargs")));
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return true;
	}
}