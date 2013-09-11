
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreboardManager extends JavaPlugin {

    public static org.bukkit.scoreboard.ScoreboardManager manager = Bukkit.getScoreboardManager();
    public static Score seconds;
    public static Score cooldown;
    public static Score players;
    public static Scoreboard board;
    public static Score explosioncountdown;

    public static void Creation() {
        board = manager.getNewScoreboard();
        Team main = board.registerNewTeam("Players");
        Objective objective = board.registerNewObjective("test", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("Stats");
        seconds = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN + "Lobby Timer:")); //Get a fake offline player
        cooldown = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN + "Cooldown:")); //Get a fake offline player
        players = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN + "Players:")); //Get a fake offline player
    }
}
