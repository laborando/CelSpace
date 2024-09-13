package Rocket;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.event.world.PortalCreateEvent;

public class EntryListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final VehicleEnterEvent e) {

        //GOTO REQUEST

        if(e.getVehicle().getType().equals(EntityType.MINECART) && e.getVehicle().getName().equals("Rocket")){

            if(!(e.getEntered() instanceof Player p)){return;}

            p.setInvisible(true);

            DestinyChooser.chooseDest(p);

        }
    }


    @EventHandler(priority = EventPriority.HIGH)
    public void event(final VehicleExitEvent e) {

        if(e.getVehicle().getType().equals(EntityType.MINECART) && e.getVehicle().getName().equals("Rocket")){

            if(!(e.getExited() instanceof Player p)){return;}

            p.setInvisible(false);

        }
    }


}
