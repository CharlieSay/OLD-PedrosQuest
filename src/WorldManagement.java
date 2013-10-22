
import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;

public class WorldManagement {
    
    public static World world; //init this in onenable with "new world()" blah blah ...
 
    public void onDisable(){
        rollback(world.getName());
        for(CMap cm : Vars.Maps){
            rollback(cm.getWorld().getName());
        }
       
        for(Player p : Bukkit.getOnlinePlayers()){
            p.kickPlayer("Restarting this is an error please report that you where kicked");
        }
    }
 
    public void unloadMap(String mapname){
        if(Bukkit.getServer().unloadWorld(Bukkit.getServer().getWorld(mapname), false)){
            Bukkit.getLogger().log(Level.INFO, "Successfully unloaded {0}", mapname);
        }else{
            Bukkit.getLogger().log(Level.SEVERE, "COULD NOT UNLOAD {0}", mapname);
        }
    }
    public void loadMap(String mapname){
        Bukkit.getServer().createWorld(new WorldCreator(mapname));
    }
    public void rollback(String mapname){
        unloadMap(mapname);
        loadMap(mapname);
    }
    
}
