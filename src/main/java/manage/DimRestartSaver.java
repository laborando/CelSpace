package manage;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;

import java.util.EventListener;
import java.util.List;

public class DimRestartSaver implements Listener {

    @EventHandler
    private void event(final PlayerLoginEvent e){

        System.out.println(e.getPlayer().getLocation().getWorld());

    }

}
