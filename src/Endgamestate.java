
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class Endgamestate implements Listener {

    public static Boolean gameend;

    @EventHandler
    public void GameChecker(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        String pname = p.getName();
        if (Countdowns.finalvote == 1) {
            if (p.getInventory().getItemInHand().getType().equals(Material.GOLD_LEGGINGS)) {
                if (e.getClickedBlock().getType().equals(Material.BEACON)) {
                    if (gameend = true) {
                        e.getPlayer().sendMessage(QuestMain.gamename + "the game has already finished!");
                        e.setCancelled(true);
                    } else {
                        QuestMain.GameProgress = ("end");
                        Bukkit.broadcastMessage(QuestMain.gamename + "Game Over");
                        Bukkit.broadcastMessage(QuestMain.gamename + ChatColor.RED + ChatColor.BOLD + pname + ChatColor.RESET + ChatColor.AQUA + " has won.");
                        int Timewon;
                        Timewon = Countdowns.GameTimer;
                        Timewon = (12000 - Timewon);
                        String timewin = TimeFormat.formatIntoHHMMSS(Timewon);
                        Bukkit.broadcastMessage(QuestMain.gamename + "They won in - " + timewin);
                        gameend = true;
                        Bukkit.getScheduler().cancelAllTasks();
                        for (Player rest : Bukkit.getOnlinePlayers()) {
                            p.getInventory().clear();
                            if (rest.getName().equalsIgnoreCase(pname)) {
                            } else {
                                rest.teleport(p);
                            }
                        }
                        for (String p1 : Mainlistener.Playerlist) {
                            Player p3 = Bukkit.getPlayer(p1);
                            p.getInventory().clear();
                        }
                    }
                }
            }
        }
        if (Countdowns.finalvote == 2) {
            if (p.getInventory().getItemInHand().getType().equals(Material.JUKEBOX)) {
                if (e.getClickedBlock().getType().equals(Material.BEACON)) {
                    if (gameend = true) {
                        e.getPlayer().sendMessage(QuestMain.gamename + "the game has already finished!");
                        e.setCancelled(true);
                    } else {
                        QuestMain.GameProgress = ("end");
                        Bukkit.broadcastMessage(QuestMain.gamename + "Game Over");
                        Bukkit.broadcastMessage(QuestMain.gamename + ChatColor.RED + ChatColor.BOLD + pname + ChatColor.RESET + ChatColor.AQUA + " has won.");
                        int Timewon;
                        Timewon = Countdowns.GameTimer;
                        Timewon = (12000 - Timewon);
                        String timewin = TimeFormat.formatIntoHHMMSS(Timewon);
                        Bukkit.broadcastMessage(QuestMain.gamename + "They won in - " + timewin);
                        gameend = true;
                        Bukkit.getScheduler().cancelAllTasks();
                        for (Player rest : Bukkit.getOnlinePlayers()) {
                            p.getInventory().clear();
                            if (rest.getName().equalsIgnoreCase(pname)) {
                            } else {
                                rest.teleport(p);
                            }
                        }
                        for (String p1 : Mainlistener.Playerlist) {
                            Player p3 = Bukkit.getPlayer(p1);
                            p.getInventory().clear();
                        }
                    }
                }
            }
        }
        if (Countdowns.finalvote == 3) {
            if (p.getInventory().getItemInHand().getType().equals(Material.IRON_CHESTPLATE)) {
                if (e.getClickedBlock().getType().equals(Material.BEACON)) {
                    if (gameend = true) {
                        e.getPlayer().sendMessage(QuestMain.gamename + "the game has already finished!");
                        e.setCancelled(true);
                    } else {
                        QuestMain.GameProgress = ("end");
                        Bukkit.broadcastMessage(QuestMain.gamename + "Game Over");
                        Bukkit.broadcastMessage(QuestMain.gamename + ChatColor.RED + ChatColor.BOLD + pname + ChatColor.RESET + ChatColor.AQUA + " has won.");
                        int Timewon;
                        Timewon = Countdowns.GameTimer;
                        Timewon = (12000 - Timewon);
                        String timewin = TimeFormat.formatIntoHHMMSS(Timewon);
                        Bukkit.broadcastMessage(QuestMain.gamename + "They won in - " + timewin);
                        gameend = true;
                        Bukkit.getScheduler().cancelAllTasks();
                        for (Player rest : Bukkit.getOnlinePlayers()) {
                            p.getInventory().clear();
                            if (rest.getName().equalsIgnoreCase(pname)) {
                            } else {
                                rest.teleport(p);
                            }
                        }
                        for (String p1 : Mainlistener.Playerlist) {
                            Player p3 = Bukkit.getPlayer(p1);
                            p.getInventory().clear();
                        }
                    }
                }
            }
        }
        if (Countdowns.finalvote == 4) {
            if (p.getInventory().getItemInHand().getType().equals(Material.CAKE)) {
                if (e.getClickedBlock().getType().equals(Material.BEACON)) {
                    if (gameend = true) {
                        e.getPlayer().sendMessage(QuestMain.gamename + "the game has already finished!");
                        e.setCancelled(true);
                    } else {
                        QuestMain.GameProgress = ("end");
                        Bukkit.broadcastMessage(QuestMain.gamename + "Game Over");
                        Bukkit.broadcastMessage(QuestMain.gamename + ChatColor.RED + ChatColor.BOLD + pname + ChatColor.RESET + ChatColor.AQUA + " has won.");
                        int Timewon;
                        Timewon = Countdowns.GameTimer;
                        Timewon = (12000 - Timewon);
                        String timewin = TimeFormat.formatIntoHHMMSS(Timewon);
                        Bukkit.broadcastMessage(QuestMain.gamename + "They won in - " + timewin);
                        gameend = true;
                        Bukkit.getScheduler().cancelAllTasks();
                        for (Player rest : Bukkit.getOnlinePlayers()) {
                            p.getInventory().clear();
                            if (rest.getName().equalsIgnoreCase(pname)) {
                            } else {
                                rest.teleport(p);
                            }
                        }
                        for (String p1 : Mainlistener.Playerlist) {
                            Player p3 = Bukkit.getPlayer(p1);
                            p.getInventory().clear();
                        }
                    }
                }
            }
        } else {
            //Something went wrong
        }
    }
}
