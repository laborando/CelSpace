package cel.space;

import Rocket.DestinyChooser;
import Rocket.EntryListener;
import Rocket.RocketSavety;
import cmd.TabComp;
import cmd.Exe;
import craft.AddRecipes;
import manage.DimChecker;
import manage.DimRestartSaver;
import manage.RpChecker;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import sec.RenameListener;

import java.util.ArrayList;
import java.util.List;

public final class Main extends JavaPlugin implements Listener {
    private static Main instance;
    private static  List<String> blockedWorlds = new ArrayList<>();
    @Override
    public void onEnable() {

        double now = System.currentTimeMillis();

        Bukkit.getLogger().info("Starting CelSpace...");

        instance = this;

        final FileConfiguration config = this.getConfig();


        //Config
        List<String> cnf = new ArrayList<>();
        cnf.add("This is the configuration file for CelSpace!");
        cnf.add("The following options should only be changed, if necessary!");
        config.options().setHeader(cnf);
        config.addDefault("performanceMode", false);
        config.options().copyDefaults(true);
        this.saveConfig();

        //Add Worlds, where mob spawning is blocked
        blockedWorlds.add("moon");
        blockedWorlds.add("mars");
        blockedWorlds.add("mercury");

        //CMD
        this.getCommand("clearrp").setExecutor(new Exe());
        this.getCommand("celspace").setExecutor(new Exe());
        this.getCommand("unload").setExecutor(new Exe());

        this.getCommand("celspace").setTabCompleter(new TabComp());
        this.getCommand("unload").setTabCompleter(new TabComp());

        //Listeners
        this.getServer().getPluginManager().registerEvents(this, this);
        this.getServer().getPluginManager().registerEvents(new RpChecker(), this);
        this.getServer().getPluginManager().registerEvents(new DimChecker(), this);
        this.getServer().getPluginManager().registerEvents(new RenameListener(), this);
        this.getServer().getPluginManager().registerEvents(new EntryListener(), this);
        this.getServer().getPluginManager().registerEvents(new DestinyChooser(), this);
        this.getServer().getPluginManager().registerEvents(new RocketSavety(), this);
        this.getServer().getPluginManager().registerEvents(new DimRestartSaver(), this);


        //inits
        gravity.GravityHandler.innitGravity();
        surv.Air.startAirHandler(getInstance());



        //Save rejoin
        //TODO: Save rejoin

        if(config.getBoolean("performanceMode")) {
            //For later
            Bukkit.broadcastMessage("Performance Mode on");
        }

        DimRestartSaver.loadData(this.getDataFolder() + "/dimensionPlayerData");
        AddRecipes.addRecipe1(getInstance());
        AddRecipes.addRecipe2(getInstance());
        AddRecipes.addRecipe3(getInstance());



        //Ende
        double startTime = System.currentTimeMillis() - now;
        Bukkit.getLogger().info("Started in: " + startTime + "ms!");
    }

    @Override
    public void onDisable() {

        AddRecipes.removeRecipe();

        Bukkit.getLogger().info("Saving Data...");
        DimRestartSaver.saveData(this.getDataFolder() + "/dimensionPlayerData");
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
