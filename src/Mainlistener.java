
import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Mainlistener implements Listener {

    public static List<String> Playerlist = new ArrayList();
    public static List<String> Spectatorlist = new ArrayList();

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        String pname = p.getName();
        p.setFoodLevel(20);
        p.setHealth(20D);
        Location spawnpoint = p.getWorld().getSpawnLocation();
        int x = (spawnpoint.getBlockX());
        int y = (spawnpoint.getBlockY() + 2);
        int z = (spawnpoint.getBlockZ());
        World w = spawnpoint.getWorld();
        Location spawn = new Location(w, x, y, z);
        p.teleport(spawn);
        p.sendMessage(QuestMain.gamename + "Welcome to The Quest");
        p.sendMessage(QuestMain.gamename + "Crafting choices:");
        p.sendMessage(QuestMain.gamename + ChatColor.AQUA + ChatColor.BOLD + "1." + ChatColor.RESET + " " + ChatColor.AQUA + "Golden Pants");
        p.sendMessage(QuestMain.gamename + ChatColor.AQUA + ChatColor.BOLD + "2." + ChatColor.RESET + " " + ChatColor.AQUA + "Jukebox");
        p.sendMessage(QuestMain.gamename + ChatColor.AQUA + ChatColor.BOLD + "3." + ChatColor.RESET + " " + ChatColor.AQUA + "Iron Chestplate");
        p.sendMessage(QuestMain.gamename + ChatColor.AQUA + ChatColor.BOLD + "4." + ChatColor.RESET + " " + ChatColor.AQUA + "Cake");
        p.sendMessage(QuestMain.gamename + ChatColor.AQUA + "Type /vote (then the number you want to vote for) to vote for your choice to craft for");
        p.setGameMode(GameMode.ADVENTURE);
        p.setScoreboard(ScoreboardManager.board);
        if (Playerlist.size() == 4) {
            p.sendMessage("game is full");
            SpectatorMode.SpectatorOn(p);
            Spectatorlist.add(pname);

        } else {
            if (Countdowns.LobbyTimer > 0) {
                p.sendMessage(QuestMain.gamename + "The game has already started, you are now a spectator!");
                SpectatorMode.SpectatorOn(p);
                Spectatorlist.add(pname);
            } else {
                Playerlist.add(pname);
                int playeramount = Playerlist.size();
                ScoreboardManager.players.setScore(playeramount);
                e.setJoinMessage(QuestMain.gamename + ChatColor.GOLD + ChatColor.BOLD + ChatColor.UNDERLINE + pname + ChatColor.RESET + ChatColor.AQUA + " has joined the game!");

            }
        }
    }

    @EventHandler
    public void PlayerMoveEvent(PlayerMoveEvent e) {
        if (QuestMain.GameProgress.equalsIgnoreCase("GameStarting")) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }

    @EventHandler
    public void respawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        if (!(Spectatorlist.contains(e.getPlayer().getName()))) {
            p.getInventory().setItem(0, new ItemStack(Material.COMPASS));
            p.setCompassTarget(p.getWorld().getSpawnLocation());
        }

    }

    @EventHandler
    public void plaerdeath(PlayerDeathEvent e) {
        String message = e.getDeathMessage();
        e.setDeathMessage(QuestMain.gamename + message);
    }

    @EventHandler
    public void BlockBreak(PlayerInteractEvent e) {
        if (Countdowns.LobbyTimer > 0) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }

    @EventHandler
    public void playerleave(PlayerQuitEvent e) {
        Playerlist.remove(e.getPlayer().getName());
    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent e) {
        if (Countdowns.LobbyTimer > 0) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }

    @EventHandler
    public void itemdrop(PlayerDropItemEvent e) {
        Item item = e.getItemDrop();
        ItemStack itemstack = item.getItemStack();
        ItemMeta itemmeta = itemstack.getItemMeta();
        if (itemmeta.getDisplayName().equalsIgnoreCase(ChatColor.AQUA + " Spawn Location")) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }

    @EventHandler
    public void CompassNo(InventoryClickEvent e) {
        ItemMeta itemmeta = e.getCurrentItem().getItemMeta();
        if (itemmeta.getDisplayName().equalsIgnoreCase(ChatColor.AQUA + " Spawn Location")) {
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }
}
