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
        String wn = p.getWorld().getName();
        new BukkitRunnable() {
            @Override
            public void run() {
                switch (wn) {
                    case "moon":
                        Load.loadResourceoack(p, DimChanger.TargetDimension.MOON);
                    case "mercury":
                        Load.loadResourceoack(p, DimChanger.TargetDimension.MERKUR);
                    case "venus":
                        Load.loadResourceoack(p, DimChanger.TargetDimension.VENUS);
                    case "mars":
                        Load.loadResourceoack(p, DimChanger.TargetDimension.MARS);
                    default:
                        Load.loadResourceoack(p, DimChanger.TargetDimension.OVERWORLD);
                }

            }
        }.runTaskLater(Main.getInstance(), Main.getInstance().getConfig().getInt("LoadRPDelayAfterJoin")* 20L + 20);
    }

    public static void autoAssignRp(Player p){
        switch (p.getWorld().getName()) {
            case "moon":
                Load.loadResourceoack(p, DimChanger.TargetDimension.MOON);
            case "mercury":
                Load.loadResourceoack(p, DimChanger.TargetDimension.MERKUR);
            case "venus":
                Load.loadResourceoack(p, DimChanger.TargetDimension.VENUS);
            case "mars":
                Load.loadResourceoack(p, DimChanger.TargetDimension.MARS);
            default:
                Load.loadResourceoack(p, DimChanger.TargetDimension.OVERWORLD);
        }
    }
}
