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

import java.util.Arrays;
import java.util.HashMap;

public class AddRecipes {

    static HashMap<Integer, NamespacedKey> map;

    static {
        AddRecipes.map = new HashMap<>();
    }


    public static void removeRecipe() {
        try {
            for (final NamespacedKey p : AddRecipes.map.values()) {
                Bukkit.removeRecipe(p);
            }
        }
        catch (Exception ignored) {

        }
    }
    public static void addRecipe0(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey(pluginint, "celspace_desc_0");
        AddRecipes.map.put(0, key);
        final ItemStack itemStack = new ItemStack(Material.MINECART, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName("Rocket");
        String[] lore = {ChatColor.RED + "- Click on ground to place" , ChatColor.RED + "- Needs Coal as fuel!"};
        itemMeta.setLore(Arrays.asList(lore));
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape("aza", "!@!", "bcb");
        shapedRecipe.setIngredient('@', Material.MINECART);
        shapedRecipe.setIngredient('!', Material.IRON_BLOCK);
        shapedRecipe.setIngredient('c', Material.DIAMOND);
        shapedRecipe.setIngredient('b', Material.IRON_INGOT);
        shapedRecipe.setIngredient('z', Material.END_ROD);
        Bukkit.getServer().addRecipe(shapedRecipe);
    }

    public static void addRecipe1(final Main pluginint) {

        final NamespacedKey key = new NamespacedKey(pluginint, "celspace_desc_1");
        AddRecipes.map.put(1, key);
        final ItemStack itemStack = new ItemStack(Material.DIAMOND_HELMET, 1);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName(ChatColor.RED + "Space Helmet");
        itemMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
        itemStack.setItemMeta(itemMeta);
        final ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape("b!b", "!@!", "a!a");
        shapedRecipe.setIngredient('@', Material.DIAMOND_HELMET);
        shapedRecipe.setIngredient('!', Material.GLASS);
        shapedRecipe.setIngredient('b', Material.IRON_BLOCK);

        Bukkit.getServer().addRecipe(shapedRecipe);
    }
    public static void addRecipe2(final Main pluginint) {
        final NamespacedKey key = new NamespacedKey((Plugin)pluginint, "celspace_desc_2");
        Bukkit.removeRecipe(key);
        AddRecipes.map.put(2, key);
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
