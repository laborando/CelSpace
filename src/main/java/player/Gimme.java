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
        itemMeta.setDisplayName("Rocket");
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

    /*
    *
    *
    public static void addRecipe3(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "celspace_desc_3");
        Bukkit.removeRecipe(key);
        AddRecipes.map.put(3, key);
        final ItemStack itemStack = new ItemStack(Material.DIAMOND, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.RED + "Portable Air Provider");
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "bbb", "b@b", "bcb" });
        shapedRecipe.setIngredient('@', Material.NETHER_STAR);
        shapedRecipe.setIngredient('b', Material.DIAMOND);
        shapedRecipe.setIngredient('c', Material.BUCKET);

        Bukkit.getServer().addRecipe((Recipe)shapedRecipe);
    }
}

    *
    * */

}
