import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Countdowns {
    
    public static int LobbyTask;
    public static int LobbyTimer;
    public static int GameTimer;
    public static int GameTask;
    public static int finalvote;
    public static boolean Freeze = false;
    public static Location Spawn = Bukkit.getWorld("world").getSpawnLocation();    
    public static World world = Bukkit.getWorld("world");
    
    public static void LobbyCountdown(){
        LobbyTimer = 60;
        LobbyTask = Bukkit.getScheduler().scheduleSyncRepeatingTask((QuestMain.Main), new Runnable(){
        
            @Override
            public void run(){
                LobbyTimer = LobbyTimer - 1;
                for (Player p : Bukkit.getOnlinePlayers()){
                    p.setLevel(LobbyTimer);
                    p.setFoodLevel(20);
                }if (LobbyTimer == 30){
                    Bukkit.broadcastMessage(QuestMain.gamename + "30 seconds of lobby remain!");
                }else if(LobbyTimer == 10){
                    Bukkit.broadcastMessage(QuestMain.gamename + "10 seconds of lobby remain!");
                }else if (LobbyTimer == 0){
                    Bukkit.getScheduler().cancelTask(LobbyTask);
                    QuestMain.GameProgress = ("GameStarting");
                    Bukkit.broadcastMessage(QuestMain.gamename + "The game is now starting!");
                    Bukkit.broadcastMessage(QuestMain.gamename + "You will be teleported back to the Spawn Point!");
                    if ((CommandProcessing.v1 > CommandProcessing.v2) || (CommandProcessing.v1 > CommandProcessing.v3) || (CommandProcessing.v1 > CommandProcessing.v4)){
                        Bukkit.broadcastMessage(QuestMain.gamename + "Golden Pants have been chosen with " + CommandProcessing.v1 + " votes!");
                        finalvote = 1; //Golden Pants craft
                    }else if ((CommandProcessing.v2 > CommandProcessing.v1) || (CommandProcessing.v2 > CommandProcessing.v3) || (CommandProcessing.v3 > CommandProcessing.v4)){
                        Bukkit.broadcastMessage(QuestMain.gamename + "Jukebox have been chosen with " + CommandProcessing.v2 + " votes!");
                        finalvote = 2;                      //Jukebox craft  
                    }else if ((CommandProcessing.v3 > CommandProcessing.v2) || (CommandProcessing.v3 > CommandProcessing.v4) || (CommandProcessing.v3 > CommandProcessing.v1)){
                        Bukkit.broadcastMessage(QuestMain.gamename + "Iron Chestplate have been chosen with " + CommandProcessing.v3 + " votes!");
                        finalvote = 3;                        
                    }else if ((CommandProcessing.v4 > CommandProcessing.v2) || (CommandProcessing.v4 > CommandProcessing.v3) || (CommandProcessing.v4 > CommandProcessing.v1)){
                        Bukkit.broadcastMessage(QuestMain.gamename + "Cake have been chosen with " + CommandProcessing.v4 + " votes!");
                        finalvote = 4;                        
                    }else{
                        Bukkit.broadcastMessage(QuestMain.gamename + "either no votes were casted, or vote count tied! So Golden Pants were chosen by default!");
                        finalvote = 1;
                    }
                    Bukkit.getScheduler().cancelTask(LobbyTask);
                    GameCountdown();
                    for (Player p : Bukkit.getOnlinePlayers()){
                        World world = p.getWorld();
                        double Z = world.getSpawnLocation().getZ();
                        double x = world.getSpawnLocation().getX();
                        double y = world.getSpawnLocation().getY();
                  //      p.teleport(new Location("world",Z,x,y));
                    }
                }
            }
        }, 0, 20);
    
    }
    
    public static void GameCountdown(){
        GameTimer = 11;
        Freeze = true;
        GameTask = Bukkit.getScheduler().scheduleSyncRepeatingTask((QuestMain.Main), new Runnable(){
            
            @Override
            public void run(){
                GameTimer--;
                for (Player p : Bukkit.getOnlinePlayers()){
                    p.setLevel(GameTimer);
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
                if (GameTimer == 0){
                    p.setLevel(GameTimer);
                    p.setFoodLevel(20);
                    p.setHealth(20D);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 20, 0);
                    Bukkit.getScheduler().cancelTask(GameTask);
                            }
                        }
                if (GameTimer ==0){
                    Bukkit.broadcastMessage(QuestMain.gamename + "Go Go Go!");
                    Byte blockData = 0x0;
                    world.spawnFallingBlock(world.getSpawnLocation(), Material.BEACON, blockData);
                }        
            }
            
        }, 0, 20);
         
    }
    
}
