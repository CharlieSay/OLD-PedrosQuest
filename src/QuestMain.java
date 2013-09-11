
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class QuestMain extends JavaPlugin {
    
    public static String GameProgress;
    public static QuestMain Main;
    public static String gamename = ("" + ChatColor.GOLD + " [The Quest] " + ChatColor.AQUA);
    
    @Override
    public void onEnable(){
        Main = this;
        GameProgress = ("lobby");
        Bukkit.getPluginManager().registerEvents(new Mainlistener(), this);
        Bukkit.getPluginManager().registerEvents(new Endgamestate(), this);
        Countdowns.LobbyCountdown();
        ScoreboardManager.Creation();
        World current = Bukkit.getWorld("world");
        current.getSpawnLocation().getBlock().setType(Material.BEACON);
    }

}
