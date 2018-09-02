package fr.marcjus.plugindetest.command;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandLobby implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
        if(sender instanceof Player) {
        	Player player= (Player) sender;
        	Location lobby = new Location(Bukkit.getWorld("world"), -44, 65, 29);
        	player.teleport(lobby);
        	player.setGameMode(GameMode.ADVENTURE);
        }
		
		return false;
	}

}
