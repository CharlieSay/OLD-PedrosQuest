
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class Mainlistener implements Listener{
    
    @EventHandler
    public void PlayerJoin (PlayerJoinEvent e){
        Player p = e.getPlayer();
        String pname = p.getName();
        e.setJoinMessage(QuestMain.gamename + pname + " has joined the game!");
        p.sendMessage(QuestMain.gamename + "Welcome to The Quest");
        p.sendMessage(QuestMain.gamename + "Crafting choices:");
        p.sendMessage(QuestMain.gamename + ChatColor.AQUA + ChatColor.BOLD + "1." + ChatColor.RESET + " " + ChatColor.AQUA +  "Golden Pants");
        p.sendMessage(QuestMain.gamename + ChatColor.AQUA + ChatColor.BOLD + "2." + ChatColor.RESET + " " +  ChatColor.AQUA +  "Jukebox");
        p.sendMessage(QuestMain.gamename + ChatColor.AQUA + ChatColor.BOLD + "3." + ChatColor.RESET + " " +  ChatColor.AQUA +  "Iron Chestplate");
        p.sendMessage(QuestMain.gamename + ChatColor.AQUA + ChatColor.BOLD + "4." + ChatColor.RESET + " " +  ChatColor.AQUA + "Cake");
        p.sendMessage(QuestMain.gamename + ChatColor.AQUA + "Type /vote (then the number you want to vote for) to vote for your choice to craft for");        
        p.setGameMode(GameMode.SURVIVAL);
    }
    
    @EventHandler
    public void PlayerMoveEvent (PlayerMoveEvent e){
        if (QuestMain.GameProgress.equalsIgnoreCase("GameStarting")){
            e.setCancelled(true);
        }else{
            e.setCancelled(false);
        }
    }
    
    @EventHandler
    public void BlockBreak (BlockBreakEvent e){
        if (QuestMain.GameProgress.equalsIgnoreCase("lobby")){
            e.setCancelled(true);
        }else{
            e.setCancelled(false);
        }
    }
   
}
