package Rocket;

import cel.space.celutis;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;

public class RocketSavety implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final EntityDamageEvent e) {

        if(!(e.getEntity() instanceof Player p)){return;}

        if(e.getCause().equals(EntityDamageEvent.DamageCause.FALL)){
            Minecart m = celutis.getMinecartRiddenByPlayer(p);
            if(!(m == null)){
                if(m.getCustomName().equals("Rocket")){
                    e.setCancelled(true);
                }
            }
        }


    }



}
