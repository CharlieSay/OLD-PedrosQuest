
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class SpectatorMode extends JavaPlugin implements Listener{
        
    public static void SpectatorOn(Player p){
    for (Player hide : Bukkit.getOnlinePlayers())
        hide.hidePlayer(p);
    p.setGameMode(GameMode.CREATIVE);
    
    }
}