package kr.kieran.motd;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import kr.kieran.motd.cmds.LeaveCmd;
import kr.kieran.motd.cmds.MoTDCmd;
import kr.kieran.motd.listeners.JoinListener;

public class Main extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		main = this;

		getConfig().addDefault("BCjoin", true);
		getConfig().addDefault("BCquit", true);
		getLogger().info("You are running MoTD version " + getConfig().getString("version"));
		createConfig();
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
		reloadConfig();
		registerCommands();
		registerListeners();
	}

	public void onDisable() {
		main = null;
		saveDefaultConfig();
	}

	private static Main main;

	public static Main get() {
		return main;
	}

	private void createConfig() {
		this.saveDefaultConfig();
	}

	private void registerCommands() {
		getCommand("motd").setExecutor(new MoTDCmd());
		getCommand("leave").setExecutor(new LeaveCmd());
	}

	private void registerListeners() {
		getServer().getPluginManager().registerEvents(new JoinListener(), this);
//		getServer().getPluginManager().registerEvents(new QuitListener(), this);
	}
}