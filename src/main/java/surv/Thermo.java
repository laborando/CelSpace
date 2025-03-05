package surv;

import cel.space.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class Thermo {

    private static final HashMap<String, Boolean> needsThermo = new HashMap<>();


    public static void startThermoHandler(Main p){

        needsThermo.put("world", true);
        needsThermo.put("world_the_end", true);
        needsThermo.put("world_nether", true);
        needsThermo.put("moon", false);
        needsThermo.put("mars", false);
        needsThermo.put("mercury", false);
        needsThermo.put("venus", false);
        needsThermo.put("pluto", false);
        needsThermo.put("ignis", false);
        needsThermo.put("rocky", false);

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {

                    boolean amp = true;
                    try {
                        amp = needsThermo.get(player.getWorld().getName());
                    }catch (NullPointerException ignored){}
                    if(!amp){

                        ItemStack is = player.getInventory().getChestplate();
                        if(is == null){
                            is = new ItemStack(Material.DIAMOND, 1);
                        }

                        ItemMeta im = is.getItemMeta();
                        Material t = is.getType();

                        if(im == null){
                            im = new ItemStack(Material.DIAMOND, 1).getItemMeta();
                        }

                    if((t.equals(Material.DIAMOND_HELMET) && im.getDisplayName().equals(ChatColor.RED + "Thermo Chestplate")) || ((player.getGameMode()== GameMode.CREATIVE) ||(player.getGameMode()==GameMode.SPECTATOR))) {
                    }else{

                        player.damage(1);
                        player.sendTitle("", ChatColor.RED + "You don't have any protective gear against these harsh temperatures!", 3, 20, 3);
                    }
                    }
                }
            }
        }.runTaskTimer(Main.getInstance(), 0 /*<- init delay */, 20L*2 /*<- interval */);


    }


}
