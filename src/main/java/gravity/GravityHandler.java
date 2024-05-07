package gravity;

import cel.space.Main;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
                    }
                }
            }
        }.runTaskTimer(Main.getInstance(), 0 /*<- init delay */, 20L*2 /*<- interval */);

    }

}
