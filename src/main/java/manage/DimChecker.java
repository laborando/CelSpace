package manage;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.PortalCreateEvent;

import java.util.ArrayList;
import java.util.List;

public class DimChecker implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PortalCreateEvent e) {

        List<String> blockedWorlds = new ArrayList<>();

        blockedWorlds.add("mars");
        blockedWorlds.add("moon");
        blockedWorlds.add("mercury");

        if (blockedWorlds.contains(e.getWorld().getName())) {

            e.setCancelled(true);

        }
    }


}
