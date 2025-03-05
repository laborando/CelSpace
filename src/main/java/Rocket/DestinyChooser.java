package Rocket;

import gui.rocket.SolarChooser;
import manage.DimChanger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/// **
///Only fordwardn choosDest to right ones for now
public class DestinyChooser {

    public static void chooseDest(Player p) {

        //Für jetzt: Direkte Weiterleitung an den SolarChooser:
        SolarChooser.chooseDest(p);

    }

}
