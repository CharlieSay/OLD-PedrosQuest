
import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class Mainlistener implements Listener {

    public static List<String> Playerlist = new ArrayList();

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        String pname = p.getName();
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
            
        } else {
            Playerlist.add(pname);
            int playeramount = Playerlist.size();
            ScoreboardManager.players.setScore(playeramount);
            e.setJoinMessage(QuestMain.gamename + ChatColor.GOLD + ChatColor.BOLD + ChatColor.UNDERLINE + pname + ChatColor.RESET + ChatColor.AQUA + " has joined the game!");
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
    public void respawn(PlayerRespawnEvent e){
        Player p = e.getPlayer();
        p.getInventory().setItem(0,  new ItemStack(Material.COMPASS));
        p.setCompassTarget(p.getWorld().getSpawnLocation());
    }
    
    @EventHandler
    public void plaerdeath(PlayerDeathEvent e){
        String message = e.getDeathMessage();
        e.setDeathMessage(QuestMain.gamename + message);
    }

    @EventHandler
    public void BlockBreak(BlockBreakEvent e) {
        if (QuestMain.GameProgress.equalsIgnoreCase("lobby")) {
            e.setCancelled(true);
        }if (QuestMain.GameProgress.equalsIgnoreCase("end")){
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }

    @EventHandler
    public void playerleave(PlayerQuitEvent e){
        Playerlist.remove(e.getPlayer().getName());
    }
    
    @EventHandler
    public void onHit(EntityDamageByEntityEvent e) {
        if (QuestMain.GameProgress.equalsIgnoreCase("lobby")) {
            e.setCancelled(true);
        }if (QuestMain.GameProgress.equalsIgnoreCase("end")){
            e.setCancelled(true);
        } else {
            e.setCancelled(false);
        }
    }
    
    @EventHandler
    public void Damage(EntityDamageEvent e){
            if (QuestMain.GameProgress.equalsIgnoreCase("lobby")) {
                e.setCancelled(true);
            }if (QuestMain.GameProgress.equalsIgnoreCase("end")){
                e.setCancelled(true);
            } else {
                e.setCancelled(false);
            }            
        
    }
}
