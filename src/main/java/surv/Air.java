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

public class Air {

    private static final HashMap<String, Boolean> hasAir = new HashMap<>();


    public static void startAirHandler(Main p){

        hasAir.put("world", true);
        hasAir.put("world_the_end", true);
        hasAir.put("world_nether", true);
        hasAir.put("moon", false);
        hasAir.put("mars", false);
        hasAir.put("mercury", false);
        hasAir.put("venus", false);
        hasAir.put("pluto", false);
        hasAir.put("ignis", false);
        hasAir.put("rocky", false);

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {

                    boolean amp = true;
                    try {
                        amp = hasAir.get(player.getWorld().getName());
                    }catch (NullPointerException ignored){}
                    if(!amp){

                        ItemStack is = player.getInventory().getHelmet();
                        if(is == null){
                            is = new ItemStack(Material.DIAMOND, 1);
                        }

                        ItemMeta im = is.getItemMeta();
                        Material t = is.getType();

                        if(im == null){
                            im = new ItemStack(Material.DIAMOND, 1).getItemMeta();
                        }

                    if((t.equals(Material.DIAMOND_HELMET) && im.getDisplayName().equals(ChatColor.RED + "Space Helmet")) || ((player.getGameMode()== GameMode.CREATIVE) ||(player.getGameMode()==GameMode.SPECTATOR))) {
                    }else{

                        final ItemStack itemStack = new ItemStack(Material.DIAMOND, 1);
                        final ItemMeta itemMeta = itemStack.getItemMeta();
                        assert itemMeta != null;
                        itemMeta.setDisplayName(ChatColor.RED + "Portable Air Provider");
                        itemStack.setItemMeta(itemMeta);


                        if(!player.getInventory().containsAtLeast(itemStack, 1)){
                            player.damage(1);
                            player.sendTitle("", ChatColor.RED + "No oxygen", 3, 20, 3);
                        }
                    }
                    }
                }
            }
        }.runTaskTimer(Main.getInstance(), 0 /*<- init delay */, 20L*2 /*<- interval */);


    }


}
