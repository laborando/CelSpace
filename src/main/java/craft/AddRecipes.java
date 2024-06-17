package craft;

import cel.space.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

public class AddRecipes {

    static HashMap<Integer, NamespacedKey> map;

    static {
        AddRecipes.map = new HashMap<Integer, NamespacedKey>();
    }


    public static void removeRecipe() {
        try {
            for (final NamespacedKey p : AddRecipes.map.values()) {
                Bukkit.removeRecipe(p);
            }
        }
        catch (Exception ex) {}
    }
    public static void addRecipe1(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_1");
        Bukkit.removeRecipe(key);
        AddRecipes.map.put(1, key);
        final ItemStack itemStack = new ItemStack(Material.DIAMOND_HELMET, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.RED + "Space Helmet");
        itemMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "b!b", "!@!", "a!a" });
        shapedRecipe.setIngredient('@', Material.DIAMOND_HELMET);
        shapedRecipe.setIngredient('!', Material.GLASS);
        shapedRecipe.setIngredient('b', Material.IRON_BLOCK);

        Bukkit.getServer().addRecipe((Recipe)shapedRecipe);
    }
    public static void addRecipe2(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_2");
        Bukkit.removeRecipe(key);
        AddRecipes.map.put(1, key);
        final ItemStack itemStack = new ItemStack(Material.MINECART, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.RED + "Rocket");
        itemMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "b!b", "!@!", "a@a" });
        shapedRecipe.setIngredient('@', Material.MINECART);
        shapedRecipe.setIngredient('!', Material.DIAMOND);
        shapedRecipe.setIngredient('b', Material.REDSTONE_BLOCK);

        Bukkit.getServer().addRecipe((Recipe)shapedRecipe);
    }
    public static void addRecipe3(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "opitems_desc_3");
        Bukkit.removeRecipe(key);
        AddRecipes.map.put(1, key);
        final ItemStack itemStack = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.RED + "Thermo Chestplate");
        itemMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(new String[] { "bbb", "b@b", "bbb" });
        shapedRecipe.setIngredient('@', Material.DIAMOND_CHESTPLATE);
        shapedRecipe.setIngredient('b', Material.WHITE_WOOL);

        Bukkit.getServer().addRecipe((Recipe)shapedRecipe);
    }
}
