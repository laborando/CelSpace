package Rocket;

import manage.DimChanger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DestinyChooser implements Listener {

    public static void chooseDest(Player p){

        if(!(p.getInventory().contains(new ItemStack(Material.COAL, 64)))){
            p.sendMessage(ChatColor.RED + "You need 64 Coal in your Inventory to fuel this rocket!");
            return;
        }

        final Inventory gui = Bukkit.createInventory(null, 27, new StringBuilder().append(ChatColor.BOLD).append(ChatColor.GOLD).append("Please choose your destiny").toString());

        final ItemStack Empty = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE, 1);
        final ItemMeta Emptym = Empty.getItemMeta();
        Emptym.setDisplayName(new StringBuilder().append(ChatColor.GOLD).append(ChatColor.BOLD).append("").toString());
        Emptym.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        Emptym.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        Empty.setItemMeta(Emptym);
        for(int zae = 0; zae<27; zae++){
            gui.setItem(zae, Empty);
        }



        //Merkur Venus Erde Mars Jupiter Saturn Uranus Neptun Pluto

        //Merkur
        final ItemStack Mercury = new ItemStack(Material.ENDER_EYE, 1);
        final ItemMeta Mercurym = Mercury.getItemMeta();
        Mercurym.setDisplayName(new StringBuilder().append(ChatColor.GOLD).append(ChatColor.BOLD).append("Mercury").toString());
        Mercurym.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        Mercurym.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        Mercury.setItemMeta(Mercurym);
        gui.setItem(0, Mercury);

        //Venus
        final ItemStack Venus = new ItemStack(Material.ENDER_EYE, 1);
        final ItemMeta Venusm = Venus.getItemMeta();
        Venusm.setDisplayName(new StringBuilder().append(ChatColor.GOLD).append(ChatColor.BOLD).append("Venus").toString());
        Venusm.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        Venusm.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        Venus.setItemMeta(Venusm);
        gui.setItem(1, Venus);

        //Earth
        final ItemStack Earth = new ItemStack(Material.ENDER_EYE, 1);
        final ItemMeta Earthm = Earth.getItemMeta();
        Earthm.setDisplayName(new StringBuilder().append(ChatColor.GOLD).append(ChatColor.BOLD).append("Earth").toString());
        Earthm.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        Earthm.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        Earth.setItemMeta(Earthm);
        gui.setItem(2, Earth);

        //MARS
        final ItemStack Mars = new ItemStack(Material.ENDER_EYE, 1);
        final ItemMeta Marsm = Mars.getItemMeta();
        Marsm.setDisplayName(new StringBuilder().append(ChatColor.GOLD).append(ChatColor.BOLD).append("Mars").toString());
        Marsm.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        Marsm.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        Mars.setItemMeta(Marsm);
        gui.setItem(3, Mars);

        //Jupiter
        final ItemStack Jupiter = new ItemStack(Material.ENDER_EYE, 1);
        final ItemMeta Jupiterm = Jupiter.getItemMeta();
        Jupiterm.setDisplayName(new StringBuilder().append(ChatColor.GOLD).append(ChatColor.BOLD).append("Jupiter").toString());
        Jupiterm.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        Jupiterm.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        Jupiter.setItemMeta(Jupiterm);
        gui.setItem(4, Jupiter);

        //Saturn
        final ItemStack Saturn = new ItemStack(Material.ENDER_EYE, 1);
        final ItemMeta Saturnm = Saturn.getItemMeta();
        Saturnm.setDisplayName(new StringBuilder().append(ChatColor.GOLD).append(ChatColor.BOLD).append("Saturn").toString());
        Saturnm.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        Saturnm.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        Saturn.setItemMeta(Saturnm);
        gui.setItem(5, Saturn);

        //Uranus
        final ItemStack Uranus = new ItemStack(Material.ENDER_EYE, 1);
        final ItemMeta Uranusm = Uranus.getItemMeta();
        Uranusm.setDisplayName(new StringBuilder().append(ChatColor.GOLD).append(ChatColor.BOLD).append("Uranus").toString());
        Uranusm.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        Uranusm.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        Uranus.setItemMeta(Uranusm);
        gui.setItem(6, Uranus);

        //Neptune
        final ItemStack Neptune = new ItemStack(Material.ENDER_EYE, 1);
        final ItemMeta Neptunem = Neptune.getItemMeta();
        Neptunem.setDisplayName(new StringBuilder().append(ChatColor.GOLD).append(ChatColor.BOLD).append("Neptune").toString());
        Neptunem.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        Neptunem.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        Neptune.setItemMeta(Neptunem);
        gui.setItem(7, Neptune);

        //Pluto
        final ItemStack Pluto = new ItemStack(Material.ENDER_EYE, 1);
        final ItemMeta Plutom = Pluto.getItemMeta();
        Plutom.setDisplayName(new StringBuilder().append(ChatColor.GOLD).append(ChatColor.BOLD).append("Pluto").toString());
        Plutom.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        Plutom.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        Pluto.setItemMeta(Plutom);
        gui.setItem(8, Pluto);


        //ERSTE REIHE ENDE; ZWEITE REIHE MONDE

        final ItemStack Moon = new ItemStack(Material.ENDER_EYE, 1);
        final ItemMeta Moonm = Moon.getItemMeta();
        Moonm.setDisplayName(new StringBuilder().append(ChatColor.GOLD).append(ChatColor.BOLD).append("Moon").toString());
        Moonm.addEnchant(Enchantment.SILK_TOUCH, 1, true);
        Moonm.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        Moon.setItemMeta(Moonm);
        gui.setItem(11, Moon);



        //Open INV
        p.openInventory(gui);

    }


    //CLICK

    @EventHandler(priority = EventPriority.HIGH)
    public void onInventoryClick(final InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getCurrentItem() == null) {
            return;
        }
        if (e.getCurrentItem().getType() == Material.AIR) {
            return;
        }
        if (e.getCurrentItem().getType() == Material.LIGHT_GRAY_STAINED_GLASS_PANE && e.getCurrentItem().containsEnchantment(Enchantment.SILK_TOUCH)) {
            e.setCancelled(true);
        }

            if (e.getCurrentItem().getType() == Material.ENDER_EYE && e.getCurrentItem().containsEnchantment(Enchantment.SILK_TOUCH)) {
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD +""+ ChatColor.BOLD + "Mars")){
                    e.setCancelled(true);
                    if(p.getWorld().equals(Bukkit.getWorld("mars"))){
                        p.sendMessage("You are already on Mars!");
                    }else{
                        p.sendMessage("Going to Mars!");
                        p.closeInventory();
                        RocketAnim.startRocket(p, DimChanger.TargetDimension.MARS);
                    }
                }
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD +""+ ChatColor.BOLD + "Earth")){
                    e.setCancelled(true);
                    if(p.getWorld().equals(Bukkit.getWorld("world"))){
                        p.sendMessage("You are already on Earth!");
                    }else{
                        p.sendMessage("Going to Earth!");
                        p.closeInventory();
                        RocketAnim.startRocket(p, DimChanger.TargetDimension.OVERWORLD);
                    }
                }if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD +""+ ChatColor.BOLD + "Moon")){
                    e.setCancelled(true);
                    if(p.getWorld().equals(Bukkit.getWorld("moon"))){
                        p.sendMessage("You are already on Moon!");
                    }else{
                        p.sendMessage("Going to the Moon!");
                        p.closeInventory();
                        RocketAnim.startRocket(p, DimChanger.TargetDimension.MOON);
                    }
                }

        }
    }
}
