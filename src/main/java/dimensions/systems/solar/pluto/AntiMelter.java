package dimensions.systems.solar.pluto;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;
public class AntiMelter implements Listener {

    @EventHandler
    public void event(BlockFadeEvent e) {

        if (e.getBlock().getWorld().getName().equalsIgnoreCase("pluto")) {

            switch (e.getBlock().getType()){
                case ICE:
                case BLUE_ICE:
                case FROSTED_ICE:
                case PACKED_ICE:
                case LEGACY_PACKED_ICE:
                case LEGACY_ICE:
                case LEGACY_FROSTED_ICE:
                case SNOW_BLOCK:
                    e.setCancelled(true);
            }

        }
    }

}

