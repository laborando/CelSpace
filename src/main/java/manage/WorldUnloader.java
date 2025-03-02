package manage;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.world.PortalCreateEvent;

import java.util.logging.Level;

public class WorldUnloader implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void event(final PlayerTeleportEvent e) {

        if(!e.getFrom().getWorld().equals(e.getTo().getWorld())){

            World w = e.getFrom().getWorld();

            if(w.getPlayers().isEmpty()){

                Bukkit.getLogger().log(Level.INFO, "[Celspace] All Players left world, now unloading: " + w.getName() + ". (This can be disabled in the config)");
                Bukkit.getServer().unloadWorld(e.getFrom().getWorld(), true);

            }
        }

    }

}
