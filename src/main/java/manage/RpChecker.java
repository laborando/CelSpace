package manage;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import packs.Load;

public class RpChecker implements Listener {


    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerTeleportEvent e) {
        if (e.getTo().getWorld().getName().equals("world") || e.getTo().getWorld().getName().equals("world_the_end") || e.getTo().getWorld().getName().equals("world_nether")){
            Load.loadResourceoack(e.getPlayer(), DimChanger.TargetDimension.OVERWORLD);
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void event(final PlayerJoinEvent e) {

        e.getPlayer().sendMessage("This Server is using CelSpace. Please accept incoming texturepacks and use Optifine or suitable substitutes.");
        e.getPlayer().sendMessage("For more information execute: '/celspace client'");

    }
}
