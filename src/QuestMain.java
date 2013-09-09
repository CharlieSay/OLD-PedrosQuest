
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public class QuestMain extends JavaPlugin {
    
    public static String GameProgress;
    public static QuestMain Main;
    public static String gamename = ("" + ChatColor.GOLD + " [The Quest] " + ChatColor.AQUA);
    
    @Override
    public void onEnable(){
        Main = this;
        Countdowns.Freeze = false;
        GameProgress = ("lobby");
        Bukkit.getLogger().info("Enabled");
        Bukkit.getPluginManager().registerEvents(new Mainlistener(), this);
        Countdowns.LobbyCountdown();
        World current = Bukkit.getWorld("world");
        Byte data = 0x0;
        current.spawnFallingBlock(current.getSpawnLocation(), Material.BEACON, data);
    }
    
}
