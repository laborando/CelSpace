package actions;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class RocketPlacer implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    private void event(final PlayerInteractEvent e) {

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {


            Player p = e.getPlayer();

            final ItemStack itemStack = new ItemStack(Material.MINECART, 1);
            final ItemMeta itemMeta = itemStack.getItemMeta();
            assert itemMeta != null;
            itemMeta.setDisplayName(ChatColor.RED + "Rocket");
            String[] lore = {ChatColor.RED + "- Click on ground to place", ChatColor.RED + "- Needs Coal as fuel!"};
            itemMeta.setLore(Arrays.asList(lore));
            itemStack.setItemMeta(itemMeta);

            final ItemStack i = new ItemStack(Material.MINECART, 1);
            final ItemMeta im = i.getItemMeta();
            assert im != null;
            im.setDisplayName(ChatColor.RED + "Rocket");
            i.setItemMeta(im);


            if ((p.getInventory().contains(itemStack) && p.getInventory().getItemInMainHand().equals(itemStack))) {
                try {
                    placeRocket(itemStack, e, p);
                } catch (Exception niceException) {
                    throw new RuntimeException(niceException);
                }
            }else if ((p.getInventory().contains(i) && p.getInventory().getItemInMainHand().equals(i))) {
                    try {
                        placeRocket(i, e, p);
                    } catch (Exception niceException) {
                        throw new RuntimeException(niceException);
                    }
                }

            }


        }

        public static void placeRocket(ItemStack i, PlayerInteractEvent e, Player p){
            if(!(p.getGameMode() == GameMode.CREATIVE))
                p.getInventory().removeItem(i);

            Location spawnLocation = e.getClickedBlock().getLocation().add(0, 1, 0);

            Entity ent = spawnLocation.getWorld().spawnEntity(spawnLocation, EntityType.MINECART);

            ent.setCustomNameVisible(false);
            ent.setCustomName(ChatColor.RED + "Rocket");

            e.setCancelled(true);
        }


}
