package enviroment;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import java.util.HashMap;

public class Mobs implements Listener {

    private static final HashMap<String, Boolean> wld = new HashMap<>();

    public static void innitAntiMob(){
        wld.put("world", false);
        wld.put("world_the_end", false);
        wld.put("world_nether", false);
        wld.put("moon",  true);
        wld.put("mars",  true);
        wld.put("venus",  true);
        wld.put("mercury", true);
    }

    @EventHandler(priority = EventPriority.NORMAL)
    private void event(final CreatureSpawnEvent e) {
        if(wld.get(e.getLocation().getWorld().getName().toLowerCase()))
            e.setCancelled(true);
    }

}
