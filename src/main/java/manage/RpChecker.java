package manage;

import org.bukkit.Bukkit;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.ArrayList;
import java.util.List;

public class RpChecker implements Listener {


    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerTeleportEvent e) {
        if (e.getTo().getWorld().getName().equals("world") || e.getTo().getWorld().getName().equals("world_the_end") || e.getTo().getWorld().getName().equals("world_nether")){
            e.getPlayer().setResourcePack("");
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerJoinEvent e) {

        e.getPlayer().sendMessage("This Server is using CelSpace. Please accept incoming Texturepacks and use Optifine or another Client capable of using CEM and CIT!");
        e.getPlayer().sendMessage("If your are not using Optifine or another sufficient Client, the Texturepack will NOT work!");

    }
}
