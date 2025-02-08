package enviroment;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

import java.util.ArrayList;
import java.util.List;

/*
Needs testing
 */

public class Weater  implements Listener {

    static List<String> nwwl = new ArrayList<>();

    @EventHandler(priority = EventPriority.NORMAL)
    private void event(final WeatherChangeEvent e) {

        if(nwwl.contains(e.getWorld().getName().toLowerCase())){

            e.setCancelled(true);

            if(e.getWorld().hasStorm()){
                e.setCancelled(false);
            }

        }



    }

    public static void innitWeather(){

        nwwl.add("moon");
        nwwl.add("mars");
        nwwl.add("venus");
        nwwl.add("mercury");


        /*new BukkitRunnable() {
            @Override
            public void run() {
                for (String s : nwwl) {
                    try {
                        try {

                            Objects.requireNonNull(Bukkit.getWorld(s)).setStorm(false);
                            Objects.requireNonNull(Bukkit.getWorld(s)).setThundering(false);

                        } catch (Exception ignored) {}
                    }catch (Error alsoIgnored){}
                }
            }
       }.runTaskTimer(Main.getInstance(), 20, 20L*1);
*/
    }
}
