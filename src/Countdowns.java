
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
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
    public static int TeleportCheck = 1;
    ;
    public static int GameCountdown;
    public static Score cooldown;
    public static Score gamecountd;
    public static Location Spawn = Bukkit.getWorld("world").getSpawnLocation();
    public static World world = Bukkit.getWorld("world");

    public static void Cooldown() {
        Gamecooldown = 30;
        cooldown = ScoreboardManager.objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN + "Cooldown:"));
        ScoreboardManager.seconds.getScoreboard().resetScores(Bukkit.getOfflinePlayer(ChatColor.GREEN + "Game Timer:"));
        ScoreboardManager.seconds.getScoreboard().resetScores(Bukkit.getOfflinePlayer(ChatColor.GREEN + "Lobby Timer:"));
        Cooldown = Bukkit.getScheduler().scheduleSyncRepeatingTask((QuestMain.Main), new Runnable() {
            @Override
            public void run() {
                Gamecooldown--;

                String time = TimeFormat.formatIntoHHMMSS(GameTimer);
                String finaltime = (ChatColor.AQUA + "Time Left: " + time);
                ScoreboardManager.board.getObjective("Information").setDisplayName(finaltime);
                ScoreboardManager.seconds.getScoreboard().resetScores(Bukkit.getOfflinePlayer(ChatColor.GREEN + "Lobby Timer:"));
                if (Gamecooldown < 6) {
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 0, 20);
                    }
                    if (Gamecooldown == 0) {
                        Bukkit.broadcastMessage(QuestMain.gamename + "The cooldown period is now over !");
                        ScoreboardManager.seconds.getScoreboard().resetScores(Bukkit.getOfflinePlayer(ChatColor.GREEN + "Cooldown:"));
                        Bukkit.getScheduler().cancelTask(Cooldown);
                    }
                }
            }
        }, 0, 20);

    }

    public static void Gamecountdown() {
        GameTimer = 1200;


        ScoreboardManager.gametime = ScoreboardManager.objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN + "Game Timer:"));
        GameCountdown = Bukkit.getScheduler().scheduleSyncRepeatingTask((QuestMain.Main), new Runnable() {
            @Override
            public void run() {
                GameTimer--;
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
                            QuestMain.GameProgress = ("end");
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
                    if ((QuestMain.v1 > QuestMain.v2) || (QuestMain.v1 > QuestMain.v3) || (QuestMain.v1 > QuestMain.v4)) {
                        Bukkit.broadcastMessage(QuestMain.gamename + "Golden Pants have been chosen with " + QuestMain.v1 + " votes!");
                        finalvote = 1; //Golden Pants craft
                    } else if ((QuestMain.v2 > QuestMain.v1) || (QuestMain.v2 > QuestMain.v3) || (QuestMain.v3 > QuestMain.v4)) {
                        Bukkit.broadcastMessage(QuestMain.gamename + "Jukebox have been chosen with " + QuestMain.v2 + " votes!");
                        finalvote = 2;                      //Jukebox craft  
                    } else if ((QuestMain.v3 > QuestMain.v2) || (QuestMain.v3 > QuestMain.v4) || (QuestMain.v3 > QuestMain.v1)) {
                        Bukkit.broadcastMessage(QuestMain.gamename + "Iron Chestplate have been chosen with " + QuestMain.v3 + " votes!");
                        finalvote = 3;                      //Iron Chestplate  
                    } else if ((QuestMain.v4 > QuestMain.v2) || (QuestMain.v4 > QuestMain.v3) || (QuestMain.v4 > QuestMain.v1)) {
                        Bukkit.broadcastMessage(QuestMain.gamename + "Cake have been chosen with " + QuestMain.v4 + " votes!");
                        finalvote = 4;                        //Cake
                    } else {
                        Bukkit.broadcastMessage(QuestMain.gamename + "either no votes were casted, or vote count tied! So Golden Pants were chosen by default!");
                        finalvote = 1;
                    }
                    Bukkit.getScheduler().cancelTask(LobbyTask);
                    GameCountdown();
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

                    if (TeleportCheck == 1) {
                        int spawn1 = Spawn.getBlockZ() + 10;
                        int spawn1y = Spawn.getBlockY();
                        Location CT1 = new Location(world, Spawn.getBlockX(), spawn1y, spawn1);
                        CT1.getBlock().setType(Material.REDSTONE_BLOCK);
                        int spawn1yp = Spawn.getBlockY() + 1;
                        Location CTP1 = new Location(world, Spawn.getBlockX(), spawn1yp, spawn1);
                        p.teleport(CTP1);
                        TeleportCheck = TeleportCheck + 1;
                    } else if (TeleportCheck == 2) {
                        int spawn2 = Spawn.getBlockZ() - 10;
                        int spawn2y = Spawn.getBlockY();
                        Location CT2 = new Location(world, Spawn.getBlockX(), spawn2y, spawn2);
                        CT2.getBlock().setType(Material.REDSTONE_BLOCK);
                        int spawn1yp = Spawn.getBlockY() + 1;
                        Location CTP1 = new Location(world, Spawn.getBlockX(), spawn1yp, spawn2);
                        p.teleport(CTP1);
                        TeleportCheck = TeleportCheck + 1;
                    } else if (TeleportCheck == 3) {
                        int spawn3 = Spawn.getBlockX() + 10;
                        int spawn3y = Spawn.getBlockY();
                        Location CT3 = new Location(world, spawn3, spawn3y, Spawn.getBlockZ());
                        CT3.getBlock().setType(Material.REDSTONE_BLOCK);
                        int spawn1yp = Spawn.getBlockY() + 1;
                        Location CTP1 = new Location(world, spawn3, spawn1yp, Spawn.getBlockZ());
                        p.teleport(CTP1);
                        TeleportCheck = TeleportCheck + 1;
                    } else if (TeleportCheck == 4) {
                        int spawn4 = Spawn.getBlockX() - 10;
                        int spawn4y = Spawn.getBlockY();
                        Location CT4 = new Location(world, spawn4, spawn4y, Spawn.getBlockZ());
                        CT4.getBlock().setType(Material.REDSTONE_BLOCK);
                        int spawn1yp = Spawn.getBlockY() + 1;
                        Location CTP1 = new Location(world, spawn4, spawn1yp, Spawn.getBlockZ());
                        p.teleport(CTP1);
                        TeleportCheck = TeleportCheck + 1;
                    }
                    if (StartGameTimer == 0) {
                        QuestMain.GameProgress = ("inGame");
                        ItemStack compass = (new ItemStack(Material.COMPASS));
                        ItemMeta compassmeta = compass.getItemMeta();
                        compassmeta.setDisplayName(ChatColor.AQUA + " Spawn Location");
                        compass.setItemMeta(compassmeta);
                        p.getInventory().setItem(0, compass);
                        p.setCompassTarget(Spawn);
                        p.setFoodLevel(20);
                        p.setHealth(20D);
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 20, 0);
                        Bukkit.getScheduler().cancelTask(GameTask);
                        p.setGameMode(GameMode.SURVIVAL);
                    }
                }
                if (StartGameTimer == 0) {
                    Bukkit.broadcastMessage(QuestMain.gamename + "Go Go Go!");
                    BeaconStrike();
                    Gamecountdown();
                    Cooldown();
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
