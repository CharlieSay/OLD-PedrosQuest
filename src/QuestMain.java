
import com.sk89q.worldedit.WorldEdit;
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
    public static Location beacon;

    @Override
    public void onEnable() {
        Main = this;
        World current = Bukkit.getWorld("world");
        Sphere.Sphere(current.getSpawnLocation(), 20);
        GameProgress = ("lobby");
        Bukkit.getPluginManager().registerEvents(new Mainlistener(), this);
        Bukkit.getPluginManager().registerEvents(new Endgamestate(), this);
        ScoreboardManager.Creation();
        Countdowns.LobbyCountdown();
        beacon = (current.getSpawnLocation().getBlock().getLocation().add(0, 1, 0));
        current.getBlockAt(beacon).setType(Material.BEACON);
    }
}
