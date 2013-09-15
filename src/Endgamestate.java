
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class Endgamestate implements Listener {

    @EventHandler
    public void GameChecker(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        String pname = p.getName();
        if (Countdowns.finalvote == 1) {
            if (p.getInventory().getItemInHand().getType().equals(Material.GOLD_LEGGINGS)) {
                if (e.getClickedBlock().getType().equals(Material.BEACON)) {
                    Bukkit.broadcastMessage(QuestMain.gamename + "Game Over");
                    Bukkit.broadcastMessage(QuestMain.gamename + pname + " has won.");
                    int Timewon;               
                    Timewon = Countdowns.GameTimer;
                    Timewon = (12000 - Timewon);                    
                    String timewin = TimeFormat.formatIntoHHMMSS(Timewon);
                    Bukkit.broadcastMessage(QuestMain.gamename + " they won in - " + timewin);
                    for (Player rest : Bukkit.getOnlinePlayers()) {
                        if (rest.getName().equalsIgnoreCase(pname)) {
                        } else {
                            rest.teleport(p);
                            Bukkit.getScheduler().cancelAllTasks();
                        }
                    }
                }
            }
        }
        if (Countdowns.finalvote == 2) {
            if (p.getInventory().getItemInHand().getType().equals(Material.JUKEBOX)) {
                if (e.getClickedBlock().getType().equals(Material.BEACON)) {
                    Bukkit.broadcastMessage(QuestMain.gamename + "Game Over");
                    Bukkit.broadcastMessage(QuestMain.gamename + pname + " has won.");
                    int Timewon;               
                    Timewon = Countdowns.GameTimer;
                    Timewon = (12000 - Timewon);                    
                    String timewin = TimeFormat.formatIntoHHMMSS(Timewon);
                    Bukkit.broadcastMessage(QuestMain.gamename + " they won in - " + timewin);                    
                    for (Player rest : Bukkit.getOnlinePlayers()) {
                        if (rest.getName().equalsIgnoreCase(pname)) {
                        } else {
                            rest.teleport(p);
                            Bukkit.getScheduler().cancelAllTasks();
                        }
                    }
                }
            }
        }
        if (Countdowns.finalvote == 3) {
            if (p.getInventory().getItemInHand().getType().equals(Material.IRON_CHESTPLATE)) {
                if (e.getClickedBlock().getType().equals(Material.BEACON)) {
                    Bukkit.broadcastMessage(QuestMain.gamename + "Game Over");
                    Bukkit.broadcastMessage(QuestMain.gamename + pname + " has won.");
                    int Timewon;               
                    Timewon = Countdowns.GameTimer;
                    Timewon = (12000 - Timewon);                    
                    String timewin = TimeFormat.formatIntoHHMMSS(Timewon);
                    Bukkit.broadcastMessage(QuestMain.gamename + " they won in - " + timewin);                    
                    for (Player rest : Bukkit.getOnlinePlayers()) {
                        if (rest.getName().equalsIgnoreCase(pname)) {
                        } else {
                            rest.teleport(p);
                            Bukkit.getScheduler().cancelAllTasks();
                        }
                    }
                }
            }
        }
        if (Countdowns.finalvote == 4) {
            if (p.getInventory().getItemInHand().getType().equals(Material.CAKE)) {
                if (e.getClickedBlock().getType().equals(Material.BEACON)) {
                    Bukkit.broadcastMessage(QuestMain.gamename + "Game Over");
                    Bukkit.broadcastMessage(QuestMain.gamename + pname + " has won.");
                    int Timewon;               
                    Timewon = Countdowns.GameTimer;
                    Timewon = (12000 - Timewon);                    
                    String timewin = TimeFormat.formatIntoHHMMSS(Timewon);
                    Bukkit.broadcastMessage(QuestMain.gamename + " they won in - " + timewin);                    
                    for (Player rest : Bukkit.getOnlinePlayers()) {
                        if (rest.getName().equalsIgnoreCase(pname)) {
                        } else {
                            rest.teleport(p);
                            Bukkit.getScheduler().cancelAllTasks();
                        }
                    }
                }
            }
        } else {
            //Something went wrong
        }
    }
}
