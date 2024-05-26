package cel.space;

import Rocket.DestinyChooser;
import Rocket.EntryListener;
import Rocket.RocketSavety;
import cmd.TabComp;
import cmd.Exe;
import manage.DimChecker;
import manage.RpChecker;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.Messenger;
import sec.PlayerClientChecker;
import sec.RenameListener;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public final class Main extends JavaPlugin implements Listener {
    private static Main instance;
    private static  List<String> blockedWorlds = new ArrayList<>();
    @Override
    public void onEnable() {

        instance = this;

        blockedWorlds.add("moon");
        blockedWorlds.add("mars");

        this.getCommand("mars").setExecutor(new Exe());
        this.getCommand("rp1").setExecutor(new Exe());
        this.getCommand("clearrp").setExecutor(new Exe());
        this.getCommand("celspace").setExecutor(new Exe());

        this.getCommand("mars").setTabCompleter(new TabComp());
        this.getCommand("celspace").setTabCompleter(new TabComp());

        this.getServer().getPluginManager().registerEvents(this, this);
        this.getServer().getPluginManager().registerEvents(new RpChecker(), this);
        this.getServer().getPluginManager().registerEvents(new DimChecker(), this);
        this.getServer().getPluginManager().registerEvents(new RenameListener(), this);
        this.getServer().getPluginManager().registerEvents(new EntryListener(), this);
        this.getServer().getPluginManager().registerEvents(new DestinyChooser(), this);
        this.getServer().getPluginManager().registerEvents(new RocketSavety(), this);

        
        gravity.GravityHandler.innitGravity();

    }

    @Override
    public void onDisable() {



    }

    public static Main getInstance() {
        return instance;
    }



    @EventHandler(priority = EventPriority.HIGH)
    public void event(final CreatureSpawnEvent e) {

        try {
            if (blockedWorlds.contains(e.getLocation().getWorld().getName())) {
                if(e.getSpawnReason()==CreatureSpawnEvent.SpawnReason.NATURAL || e.getSpawnReason()== CreatureSpawnEvent.SpawnReason.NETHER_PORTAL || e.getSpawnReason()== CreatureSpawnEvent.SpawnReason.PATROL){

                    e.setCancelled(true);

                }
            }
        }catch (NullPointerException ignored){}



    }

}
