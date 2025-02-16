package player;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Gimme {

    public static void gimmeThatSpaceStuff(Player p)
    {

        ItemStack itemStack = new ItemStack(Material.MINECART, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName(ChatColor.RED + "Rocket");
        String[] lore = {ChatColor.RED + "- Click on ground to place" , ChatColor.RED + "- Needs Coal as fuel!"};
        itemMeta.setLore(Arrays.asList(lore));
        itemStack.setItemMeta(itemMeta);

        p.getInventory().addItem(itemStack);

        itemStack = new ItemStack(Material.DIAMOND_HELMET, 1);
        itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName(ChatColor.RED + "Space Helmet");
        itemMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
        itemStack.setItemMeta(itemMeta);

        p.getInventory().addItem(itemStack);

        itemStack = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.RED + "Thermo Chestplate");
        itemMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
        itemStack.setItemMeta(itemMeta);

        p.getInventory().addItem(itemStack);

        itemStack = new ItemStack(Material.DIAMOND, 1);
        itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.RED + "Portable Air Provider");
        itemStack.setItemMeta(itemMeta);

        p.getInventory().addItem(itemStack);
    }



}
