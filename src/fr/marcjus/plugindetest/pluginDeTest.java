package fr.marcjus.plugindetest;

import org.bukkit.plugin.java.JavaPlugin;

import fr.marcjus.plugindetest.command.CommandLobby;

//import com.avaje.ebean.validation.Length;

import fr.marcjus.plugindetest.command.Commandtest;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
//import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;


public class pluginDeTest extends JavaPlugin {
	

	public class CommandDay implements CommandExecutor {

	    @Override
	    public boolean onCommand(CommandSender sender, Command cmd, String label,
	            String[] args) {
	        if (label.equalsIgnoreCase("day")) {
	            // On vérifie si le sender est un joueur
	            if (sender instanceof Player) {
	                // ON récupère le joueur
	                Player player = (Player) sender;
	                // A-t-il la permission?
	                if (player.hasPermission("tuto.day")) {
	                    // On vérifie qu'il n'y a pas d'arguments
	                    if (args.length == 0) {
	                        // On mets les ticks sur 1000 dans le monde où se trouve
	                        // le joueur
	                        player.getWorld().setTime(1000);
	                        // On envoit un message au joueur
	                        player.sendMessage(ChatColor.GREEN
	                                + "Il fait jour dans ton monde!");
	                        // SI il y a un argument
	                    } else if (args.length == 1) {
	                        // On récupère l'argument qui est le nom d'un monde
	                        World world = Bukkit.getWorld(args[0]);
	                        // On vérifie que le monde existe
	                        if (world != null) {
	                            // On mets les ticks sur 1000 dans le monde en
	                            // question
	                            world.setTime(1000);
	                            // On envoit un message au joueur
	                            player.sendMessage(ChatColor.GREEN
	                                    + "Il fait jour dans le monde: "
	                                    + ChatColor.RED + world.getName());
	                        } else {
	                            // On envoit un message au joueur d'erreur: le monde
	                            // n'existe pas
	                            player.sendMessage(ChatColor.DARK_RED + "[Erreur] "
	                                    + ChatColor.RED + "Le monde \""
	                                    + ChatColor.DARK_RED + args[0]
	                                    + ChatColor.RED + "\" n'existe pas!");
	                        }
	                        // Si il y a plus qu'un argument on envoie le message
	                        // d'Usage
	                    } else {
	                        return false;
	                    }
	                } else {
	                    player.sendMessage(ChatColor.DARK_RED + "[Permissions] "
	                            + ChatColor.RED + "Vous n'avez pas la permission!");
	                }
	            } else {
	                // Erreur: le sender n'est pas un joueur
	                sender.sendMessage("Vous devez etre un joueur!");
	            }
	            // On n'envoie pas l'usage
	            return true;
	        }
	        return false;
	    }

	}
	
	public class CommandNight implements CommandExecutor {

	    @Override
	    public boolean onCommand(CommandSender sender, Command cmd, String label,
	            String[] args) {
	        if (label.equalsIgnoreCase("night")) {
	            // On vérifie si le sender est un joueur
	            if (sender instanceof Player) {
	                // ON récupère le joueur
	                Player player = (Player) sender;
	                // A-t-il la permission?
	                if (player.hasPermission("tuto.night")) {
	                    // On vérifie qu'il n'y a pas d'arguments
	                    if (args.length == 0) {
	                        // On mets les ticks sur 1000 dans le monde où se trouve
	                        // le joueur
	                        player.getWorld().setTime(13000);
	                        // On envoit un message au joueur
	                        player.sendMessage(ChatColor.GREEN
	                                + "Il fait nuit dans ton monde!");
	                        // SI il y a un argument
	                    } else if (args.length == 1) {
	                        // On récupère l'argument qui est le nom d'un monde
	                        World world = Bukkit.getWorld(args[0]);
	                        // On vérifie que le monde existe
	                        if (world != null) {
	                            // On mets les ticks sur 1000 dans le monde en
	                            // question
	                            world.setTime(1000);
	                            // On envoit un message au joueur
	                            player.sendMessage(ChatColor.GREEN
	                                    + "Il fait nuit dans le monde: "
	                                    + ChatColor.RED + world.getName());
	                        } else {
	                            // On envoit un message au joueur d'erreur: le monde
	                            // n'existe pas
	                            player.sendMessage(ChatColor.DARK_RED + "[Erreur] "
	                                    + ChatColor.RED + "Le monde \""
	                                    + ChatColor.DARK_RED + args[0]
	                                    + ChatColor.RED + "\" n'existe pas!");
	                        }
	                        // Si il y a plus qu'un argument on envoie le message
	                        // d'Usage
	                    } else {
	                        return false;
	                    }
	                } else {
	                    player.sendMessage(ChatColor.DARK_RED + "[Permissions] "
	                            + ChatColor.RED + "Vous n'avez pas la permission!");
	                }
	            } else {
	                // Erreur: le sender n'est pas un joueur
	                sender.sendMessage("Vous devez etre un joueur!");
	            }
	            // On n'envoie pas l'usage
	            return true;
	        }
	        return false;
	    }

	}
	
	public class CommandGm implements CommandExecutor {

	    @Override
	    public boolean onCommand(CommandSender sender, Command cmd, String label,
	            String[] args) {
	        if (label.equalsIgnoreCase("gm")) {
	            // On vérifie si le sender est un joueur
	                // ON récupère le joueur
	                Player player = (Player) sender;
	                player.sendMessage("dans la commnde gm");
	                // A-t-il la permission?
	                if (player.hasPermission("tuto.gm")) {
		                player.sendMessage("j'ai la permission");
	                    // On vérifie qu'il n'y a pas d'arguments
	                    if (args.length == 0) {
	                        player.sendMessage(ChatColor.RED+"Tu dois entrer un numéro de mode de jeu!");
	                        // SI il y a un argument
	                    } else if (args.length == 1) {
	                    	if (args[0].equals("1") || args[0].equals("c")) {
	                    		 player.sendMessage(ChatColor.GREEN+ "Tu est en creatif!");
	                    		 player.setGameMode(GameMode.CREATIVE);
	                    	}else if(args[0].equals("0") || args[0].equals("s")){
	                    		player.sendMessage(ChatColor.GREEN+"Tu est en survie!");
	                    		player.setGameMode(GameMode.SURVIVAL);
	                    	}else if(args[0].equals("2") || args[0].equals("a")){
	                    		player.sendMessage(ChatColor.GREEN+"Tu est en aventure!");
	                    		player.setGameMode(GameMode.ADVENTURE);
	                    	}else if(args[0].equals("3") || args[0].equals("sp")) {
	                    		player.sendMessage(ChatColor.GREEN+"Tu est en spectateur!");
	                    		player.setGameMode(GameMode.SPECTATOR);
	                    	}
	                       
	                        
	                        // Si il y a plus qu'un argument on envoie le message
	                        // d'Usage
	                    } else {
	    	                player.sendMessage("il y a plus d'un argument");
	                        return false;
	                    }
	                } else {
	                    player.sendMessage(ChatColor.DARK_RED + "[Permissions] "
	                            + ChatColor.RED + "Vous n'avez pas la permission!");
	                }
	            }
	            // On n'envoie pas l'usage
	            return true;
	    }

	}
	
	
	
    private static ConsoleCommandSender console = Bukkit.getConsoleSender();

	
	@Override
	public void onEnable() {
		System.out.println("plugin Marc start");
		getCommand("test").setExecutor(new Commandtest());
		getCommand("day").setExecutor(new CommandDay());
		getCommand("night").setExecutor(new CommandNight());
		getCommand("gm").setExecutor(new CommandGm());
		getCommand("lobby").setExecutor(new CommandLobby());
		getServer().getPluginManager().registerEvents(new pluginListener(), this);
	}	
		
	
	@Override
	public void onDisable() {
		System.out.println("plugin Marc stop");
	}
	
	 public static ConsoleCommandSender getConsole() {
	        return console;
	    }
	 
}
