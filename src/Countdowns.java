
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Score;

public class Countdowns {

    public static int LobbyTask;
    public static int LobbyTimer;
    public static int StartGameTimer;
    public static int GameTask;
    public static int finalvote;
    public static int GameTimer;
    public static int Cooldown;
    public static int Gamecooldown;
    public static int GameCountdown;
    public static Location Spawn = Bukkit.getWorld("world").getSpawnLocation();
    public static World world = Bukkit.getWorld("world");

    public static void Cooldown() {
        Gamecooldown = 30;
        Score cooldown;
        cooldown = ScoreboardManager.objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN + "Cooldown:"));
        cooldown.setScore(Gamecooldown);
        Cooldown = Bukkit.getScheduler().scheduleSyncRepeatingTask((QuestMain.Main), new Runnable() {
            @Override
            public void run() {
                Gamecooldown--;
                if (Gamecooldown < 6) {
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0, 20);
                    }
                    if (Gamecooldown == 0) {
                        Bukkit.broadcastMessage(QuestMain.gamename + "The cooldown period is now over !");
                        Bukkit.getScheduler().cancelTask(Cooldown);
                    }
                }
            }
        }, 0, 20);

    }

    public static void Gamecountdown() {
        GameTimer = 900;
        GameCountdown = Bukkit.getScheduler().scheduleSyncRepeatingTask((QuestMain.Main), new Runnable() {
            @Override
            public void run() {
                GameTimer--;
                Score gamecountd;
                gamecountd = ScoreboardManager.objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN + "Game Timer:"));
                gamecountd.setScore(GameTimer);
                if (GameTimer < 61) {
                    if (GameTimer == 60) {
                        Bukkit.broadcastMessage(QuestMain.gamename + "There is only 1 minute remaining !");
                    }
                    if (GameTimer < 11) {
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0, 20);
                        }
                        if (GameTimer == 0) {
                            Bukkit.broadcastMessage(QuestMain.gamename + "Game over, there are no winners!");
                            Bukkit.getScheduler().cancelAllTasks();
                        }
                    }
                }

            }
        }, 0, 20);

    }

    public static void LobbyCountdown() {
        LobbyTimer = 60;
        LobbyTask = Bukkit.getScheduler().scheduleSyncRepeatingTask((QuestMain.Main), new Runnable() {
            @Override
            public void run() {
                LobbyTimer = LobbyTimer - 1;
                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.setFoodLevel(20);
                    ScoreboardManager.seconds.setScore(LobbyTimer);
                }
                if (LobbyTimer == 30) {
                    Bukkit.broadcastMessage(QuestMain.gamename + "30 seconds of lobby remain!");
                } else if (LobbyTimer == 10) {
                    Bukkit.broadcastMessage(QuestMain.gamename + "10 seconds of lobby remain!");
                } else if (LobbyTimer == 0) {
                    Bukkit.getScheduler().cancelTask(LobbyTask);
                    QuestMain.GameProgress = ("GameStarting");
                    Bukkit.broadcastMessage(QuestMain.gamename + "The game is now starting!");
                    Bukkit.broadcastMessage(QuestMain.gamename + "You will be teleported back to the Spawn Point!");
                    if ((CommandProcessing.v1 > CommandProcessing.v2) || (CommandProcessing.v1 > CommandProcessing.v3) || (CommandProcessing.v1 > CommandProcessing.v4)) {
                        Bukkit.broadcastMessage(QuestMain.gamename + "Golden Pants have been chosen with " + CommandProcessing.v1 + " votes!");
                        finalvote = 1; //Golden Pants craft
                    } else if ((CommandProcessing.v2 > CommandProcessing.v1) || (CommandProcessing.v2 > CommandProcessing.v3) || (CommandProcessing.v3 > CommandProcessing.v4)) {
                        Bukkit.broadcastMessage(QuestMain.gamename + "Jukebox have been chosen with " + CommandProcessing.v2 + " votes!");
                        finalvote = 2;                      //Jukebox craft  
                    } else if ((CommandProcessing.v3 > CommandProcessing.v2) || (CommandProcessing.v3 > CommandProcessing.v4) || (CommandProcessing.v3 > CommandProcessing.v1)) {
                        Bukkit.broadcastMessage(QuestMain.gamename + "Iron Chestplate have been chosen with " + CommandProcessing.v3 + " votes!");
                        finalvote = 3;                      //Iron Chestplate  
                    } else if ((CommandProcessing.v4 > CommandProcessing.v2) || (CommandProcessing.v4 > CommandProcessing.v3) || (CommandProcessing.v4 > CommandProcessing.v1)) {
                        Bukkit.broadcastMessage(QuestMain.gamename + "Cake have been chosen with " + CommandProcessing.v4 + " votes!");
                        finalvote = 4;                        //Cake
                    } else {
                        Bukkit.broadcastMessage(QuestMain.gamename + "either no votes were casted, or vote count tied! So Golden Pants were chosen by default!");
                        finalvote = 1;
                    }
                    Bukkit.getScheduler().cancelTask(LobbyTask);
                    GameCountdown();
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        World world = p.getWorld();
                        p.teleport(world.getSpawnLocation());
                    }
                }
            }
        }, 0, 20);

    }

    public static void GameCountdown() {
        StartGameTimer = 11;
        GameTask = Bukkit.getScheduler().scheduleSyncRepeatingTask((QuestMain.Main), new Runnable() {
            @Override
            public void run() {
                StartGameTimer--;
                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.setLevel(StartGameTimer);
                    p.playSound(p.getLocation(), Sound.ORB_PICKUP, 20, 0);
//                    int TeleportCheck = 0;
//                    if (TeleportCheck == 1){
//                        int spawn1 = Spawn.getBlockZ() + 10;
//                        Location CT1 = new Location(world, Spawn.getBlockX(), Spawn.getBlockY(), spawn1);
//                        CT1.getBlock().setType(Material.REDSTONE_BLOCK);
//                        p.teleport(CT1);
//                    }else if (TeleportCheck == 2){
//                        int spawn2 = Spawn.getBlockZ() - 10;
//                        Location CT2 = new Location(world, Spawn.getBlockX(), Spawn.getBlockY(), spawn2);
//                        CT2.getBlock().setType(Material.REDSTONE_BLOCK);
//                        p.teleport(CT2);                        
//                    }else if (TeleportCheck == 3){
//                        int spawn3 = Spawn.getBlockX() + 10;
//                        Location CT3 = new Location(world, spawn3, Spawn.getBlockY(), Spawn.getBlockZ());
//                        CT3.getBlock().setType(Material.REDSTONE_BLOCK);
//                        p.teleport(CT3);                        
//                    }else if (TeleportCheck == 4){
//                        int spawn4 = Spawn.getBlockX() - 10;
//                        Location CT4 = new Location(world, spawn4, Spawn.getBlockY(), Spawn.getBlockZ());
//                        CT4.getBlock().setType(Material.REDSTONE_BLOCK);
//                        p.teleport(CT4);                        
//                    }
                    if (StartGameTimer == 0) {
                        QuestMain.GameProgress = ("inGame");
                        p.setFoodLevel(20);
                        p.setHealth(20D);
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 20, 0);
                        Bukkit.getScheduler().cancelTask(GameTask);
                        Gamecountdown();
                        p.setGameMode(GameMode.SURVIVAL);
                    }
                }
                if (StartGameTimer == 0) {
                    Bukkit.broadcastMessage(QuestMain.gamename + "Go Go Go!");
                    BeaconStrike();
                }
            }
        }, 0, 20);

    }

    private static void BeaconStrike() {
        int BeaconStrike;
        BeaconStrike = Bukkit.getScheduler().scheduleSyncRepeatingTask((QuestMain.Main), new Runnable() {
            @Override
            public void run() {
                if (QuestMain.GameProgress.equalsIgnoreCase("inGame")) {
                    world.strikeLightningEffect(QuestMain.beacon);
                } else {
                }
            }
        }, 0, 600);

    }
}
