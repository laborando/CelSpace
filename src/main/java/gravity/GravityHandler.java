package gravity;

import cel.space.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class GravityHandler{

    private static HashMap<String, Integer> grav = new HashMap<>();

    public static void innitGravity(){

        grav.put("world", 0);
        grav.put("world_the_end", 0);
        grav.put("world_nether", 0);
        grav.put("moon", 4);
        grav.put("mars", 2);

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    int amp = grav.get(player.getWorld().getName());
                    if(!(amp==0)){
                        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 45, amp, true, false, false));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 45, amp/5, true, false, false));
                    }
                }
            }
        }.runTaskTimer(Main.getInstance(), 0 /*<- init delay */, 20L*2 /*<- interval */);

    }

}
