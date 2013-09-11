
import java.util.ArrayList;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandProcessing extends JavaPlugin {

    private List<String> VoteCheck = new ArrayList<String>();
    public static int v1;
    public static int v2;
    public static int v3;
    public static int v4;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player p = (Player) sender;
        String player = p.getName();
        if (commandLabel.equalsIgnoreCase("vote") || (commandLabel.equalsIgnoreCase("v"))) {
            if (VoteCheck.contains(player)) {
                p.sendMessage(QuestMain.gamename + "You have already voted!");
            } else {
                if (QuestMain.GameProgress.equalsIgnoreCase("lobby")) {
                    if (args.length == 1) {
                        if (args[0].equalsIgnoreCase("1")) {
                            v1++;
                            VoteCheck.add(player);
                        } else if (args[0].equalsIgnoreCase("2")) {
                            v2++;
                            VoteCheck.add(player);
                        } else if (args[0].equalsIgnoreCase("3")) {
                            v3++;
                            VoteCheck.add(player);
                        } else if (args[0].equalsIgnoreCase("4")) {
                            v4++;
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

///////////////////////////
        return false; //Dopey
///////////////////////////    
    }
}
