package fr.marcjus.plugindetest;

//import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
//import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
//import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
//import org.bukkit.potion.PotionEffect;
//import org.bukkit.potion.PotionEffectType;

//import io.netty.util.internal.chmv8.ConcurrentHashMapV8.Action;


public class pluginListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		Location hub = new Location(Bukkit.getWorld("world"), -44, 65, 29);
		player.sendMessage("variable hub");
		player.teleport(hub);
		player.getInventory().clear();
		player.getInventory().addItem(new ItemStack(org.bukkit.Material.IRON_SWORD, 3));
		
		player.setGameMode(GameMode.ADVENTURE);
		ItemStack custombloc=new ItemStack(Material.COMPASS, 1);
		ItemMeta customM=custombloc.getItemMeta();
		customM.setDisplayName("§aNavigation");
		//customM.addEnchant(Enchantment.DAMAGE_ALL, 200, true);
		//customM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		custombloc.setItemMeta(customM);
		
		
		player.getInventory().setItem(0, custombloc);
		
		player.updateInventory();
		
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		
		Player player=event.getPlayer();
		org.bukkit.event.block.Action action=event.getAction();
		ItemStack it=event.getItem();
		
		if(it==null) return;
		
		
		
		if(it.getType()==Material.COMPASS && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§aNavigation")) {
			
			Inventory inv=Bukkit.createInventory(null, 27, "§8Mon Menu");
			
			ItemStack minage1=new ItemStack(Material.DIAMOND_PICKAXE, 1);
			ItemMeta mm1= minage1.getItemMeta();
			mm1.setDisplayName("Minage 1");
			minage1.setItemMeta(mm1);
			
			inv.setItem(2, minage1);
			
			
			
			
			player.openInventory(inv);
			
		}
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		
		Inventory inv=event.getInventory();
		Player player=(Player) event.getWhoClicked();
		ItemStack current=event.getCurrentItem();
		Location serverminage1= new Location(Bukkit.getWorld("minage1"), -0, 71, 2);
		
		
		if(current==null)return;
		
		if(inv.getName().equalsIgnoreCase("§8Mon Menu")) {
			
			
			/*if(current.getType()== Material.APPLE) {
				event.setCancelled(true);
				player.closeInventory();
				player.setGameMode(GameMode.ADVENTURE);
			}
			if(current.getType()==Material.ANVIL) {
				player.closeInventory();
				event.setCancelled(true);
				player.closeInventory();
				player.getInventory().addItem(new ItemStack(Material.TNT));
			}*/
			if(current.getType()==Material.DIAMOND_PICKAXE) {
				player.closeInventory();
				event.setCancelled(true);
				player.teleport(serverminage1);
				player.setGameMode(GameMode.SURVIVAL);
			}
		}
		
		
	}
	
	public ItemStack getItem(Material material, String customName) {
		ItemStack it=new ItemStack(material, 1);
		ItemMeta metait=it.getItemMeta();
		metait.setDisplayName(customName);
		it.setItemMeta(metait);
		return it;
	}
}
