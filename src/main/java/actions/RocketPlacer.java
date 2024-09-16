package actions;

import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RocketPlacer implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    private void event(final PlayerInteractEvent e) {

        if(e.getAction() == Action.RIGHT_CLICK_BLOCK){

            Player p = e.getPlayer();

            final ItemStack itemStack = new ItemStack(Material.MINECART, 1);
            final ItemMeta itemMeta = itemStack.getItemMeta();
            assert itemMeta != null;
            itemMeta.setDisplayName("Rocket");
            String[] lore = {ChatColor.RED + "- Click on ground to place" , ChatColor.RED + "- Needs Coal as fuel!"};
            itemMeta.setLore(Arrays.asList(lore));
            itemStack.setItemMeta(itemMeta);

            final ItemStack i = new ItemStack(Material.MINECART, 1);
            final ItemMeta im = i.getItemMeta();
            assert im != null;
            im.setDisplayName("Rocket");
            i.setItemMeta(im);



            if(!(p.getInventory().contains(itemStack) && p.getInventory().getItemInMainHand().equals(itemStack))){
                if((p.getInventory().contains(i)  && p.getInventory().getItemInMainHand().equals(i))) {
                    try {
                        p.getInventory().removeItem(i);

                        Location spawnLocation = e.getClickedBlock().getLocation().add(0, 1, 0);

                        Entity ent = spawnLocation.getWorld().spawnEntity(spawnLocation, EntityType.MINECART);

                        ent.setCustomName("Rocket");

                        e.setCancelled(true);

                    }catch (Exception ignored){}
                }

                    return;
            }

            try {
                p.getInventory().removeItem(itemStack);

                Location spawnLocation = e.getClickedBlock().getLocation().add(0, 1, 0);

                Entity ent = spawnLocation.getWorld().spawnEntity(spawnLocation, EntityType.MINECART);

                ent.setCustomName("Rocket");

                e.setCancelled(true);

            }catch (Exception ignored){}

        }

    }
}
