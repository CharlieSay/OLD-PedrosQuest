
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class QuestMain extends JavaPlugin {

    private List<String> VoteCheck = new ArrayList<String>();
    public static int v1;
    public static int v2;
    public static int v3;
    public static int v4;
    public static String GameProgress;
    public static QuestMain Main;
    public static String gamename = ("" + ChatColor.GOLD + " [Pedro's Quest] " + ChatColor.AQUA);
    public static List<String> devmode = new ArrayList();
    public static Location beacon;
    
    @Override
    public void onEnable() {
        Countdowns.Gamecooldown = 30;
        Endgamestate.gameend = false;
        Main = this;
        World current = Bukkit.getWorld("world");
        current.setTime(0);
        Sphere.Sphere(current.getSpawnLocation(), 15);
        GameProgress = ("lobby");
        Bukkit.getPluginManager().registerEvents(new Mainlistener(), this);
        Bukkit.getPluginManager().registerEvents(new Endgamestate(), this);
        ScoreboardManager.Creation();
        Countdowns.LobbyCountdown();
        beacon = (current.getSpawnLocation().getBlock().getLocation().add(0, 1, 0));
        current.getBlockAt(beacon).setType(Material.BEACON);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (!(sender instanceof Player)){
            
        }if (sender instanceof Player){
        Player p = (Player) sender;
        String player = p.getName();
        if (commandLabel.equalsIgnoreCase("vote") || (commandLabel.equalsIgnoreCase("v"))) {
            if (VoteCheck.contains(player)) {
                p.sendMessage(QuestMain.gamename + "You have already voted!");
            } else {
                if (Countdowns.LobbyTimer > 0) {
                    if (args.length == 1) {
                        if (args[0].equalsIgnoreCase("1")) {
                            v1++;
                            p.sendMessage(QuestMain.gamename + "You voted for " + ChatColor.RED + "Golden Leggins " + ChatColor.AQUA + "it now has " + ChatColor.RED
                                    + v1 + ChatColor.AQUA + " votes.");
                            VoteCheck.add(player);
                        } else if (args[0].equalsIgnoreCase("2")) {
                            v2++;
                            p.sendMessage(QuestMain.gamename + "You voted for " + ChatColor.RED + "Jukebox " + ChatColor.AQUA + "it now has " + ChatColor.RED
                                    + v2 + ChatColor.AQUA + " votes.");                            
                            VoteCheck.add(player);
                        } else if (args[0].equalsIgnoreCase("3")) {
                            v3++;
                            p.sendMessage(QuestMain.gamename + "You voted for " + ChatColor.RED + "Iron Chestplate " + ChatColor.AQUA + "it now has " + ChatColor.RED
                                    + v3 + ChatColor.AQUA + " votes.");                            
                            VoteCheck.add(player);
                        } else if (args[0].equalsIgnoreCase("4")) {
                            v4++;
                            p.sendMessage(QuestMain.gamename + "You voted for " + ChatColor.RED + "Cake " + ChatColor.AQUA + "it now has " + ChatColor.RED
                                    + v4 + ChatColor.AQUA + " votes.");                            
                            VoteCheck.add(player);
                        } else {
                            p.sendMessage(QuestMain.gamename + "Wrong usage of command!");
                            p.sendMessage(QuestMain.gamename + "Do /v OR /vote followed by the number you want to vote for.");
                        }
                    } else {
                        p.sendMessage(QuestMain.gamename + "Wrong usage of command!");
                        p.sendMessage(QuestMain.gamename + "Do /v OR /vote followed by the number you want to vote for.");
                    }
                } else {
                    p.sendMessage(QuestMain.gamename + "Voting is no longer active!");
                }
            }
        }
      }
///////////////////////////
        return false; //Dopey
///////////////////////////    
    }    
}
