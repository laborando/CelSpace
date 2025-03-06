package packs;

import cel.space.Main;
import manage.DimChanger;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class RpConnected implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void event(final PlayerLoginEvent e) {

        Player p = e.getPlayer();
        new BukkitRunnable() {
            @Override
            public void run() {

                String wn = p.getWorld().getName();

                switch (wn) {
                    case "moon":
                        Load.loadResourceoack(p, DimChanger.TargetDimension.MOON);
                        break;
                    case "mercury":
                        Load.loadResourceoack(p, DimChanger.TargetDimension.MERKUR);
                        break;
                    case "venus":
                        Load.loadResourceoack(p, DimChanger.TargetDimension.VENUS);
                        break;
                    case "mars":
                        Load.loadResourceoack(p, DimChanger.TargetDimension.MARS);
                        break;
                    case "pluto":
                        Load.loadResourceoack(p, DimChanger.TargetDimension.PLUTO);
                        break;
                    default:
                        Load.loadResourceoack(p, DimChanger.TargetDimension.OVERWORLD);
                        break;
                }

            }
        }.runTaskLater(Main.getInstance(), Main.getInstance().getConfig().getInt("LoadRPDelayAfterJoin")* 20L + 20);
    }

}
