package actions;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class RocketDestroyer implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    private void event(final VehicleDestroyEvent e) {

        if (e.getVehicle() instanceof Minecart) {

            if(e.getVehicle().getName().equalsIgnoreCase("cel.celspace.entity.Rocket-cutomModel-customName-HasThisLongNameBecauseItHasToBeSoLongSorry")){


                final ItemStack itemStack = new ItemStack(Material.MINECART, 1);
                final ItemMeta itemMeta = itemStack.getItemMeta();
                assert itemMeta != null;
                itemMeta.setDisplayName(ChatColor.RED + "Rocket");
                String[] lore = {ChatColor.RED + "- Click on ground to place" , ChatColor.RED + "- Needs Coal as fuel!"};
                itemMeta.setLore(Arrays.asList(lore));
                itemStack.setItemMeta(itemMeta);

                e.getVehicle().getWorld().dropItemNaturally(e.getVehicle().getLocation(), itemStack);

                e.setCancelled(true);

                e.getVehicle().remove();

            }else if(e.getVehicle().getName().equalsIgnoreCase(ChatColor.RED + "Rocket")){


                final ItemStack itemStack = new ItemStack(Material.MINECART, 1);
                final ItemMeta itemMeta = itemStack.getItemMeta();
                assert itemMeta != null;
                itemMeta.setDisplayName(ChatColor.RED + "Rocket");
                String[] lore = {ChatColor.RED + "- Click on ground to place" , ChatColor.RED + "- Needs Coal as fuel!"};
                itemMeta.setLore(Arrays.asList(lore));
                itemStack.setItemMeta(itemMeta);

                e.getVehicle().getWorld().dropItemNaturally(e.getVehicle().getLocation(), itemStack);

                e.setCancelled(true);

                e.getVehicle().remove();

            }

        }

    }
}
