package sec;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.world.PortalCreateEvent;

public class RenameListener implements Listener {

    @EventHandler
    public void event(InventoryClickEvent e) {



        Player player = (Player) e.getWhoClicked();
        if (e.getCurrentItem() == null) {
            return;
        }
        if (e.getCurrentItem().getType() == Material.AIR) {
            return;
        }
        if (e.getInventory().getType() == InventoryType.ANVIL) {
            if(e.getSlotType() == InventoryType.SlotType.RESULT) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("Rocket") && e.getCurrentItem().getType().equals(Material.MINECART)) {
                    e.setCancelled(true);
                    player.sendMessage("Renaming a minecart to 'Rocket' is disabled!");
                }
            }
        }
    }

}
