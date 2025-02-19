package cel.space;

import Rocket.DestinyChooser;
import Rocket.EntryListener;
import Rocket.RocketSavety;
import actions.RocketDestroyer;
import actions.RocketPlacer;
import cmd.TabComp;
import cmd.Exe;
import craft.AddRecipes;
import enviroment.Weater;
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
import packs.Load;
import packs.RpConnected;
import sec.RenameListener;

import java.util.ArrayList;
import java.util.List;

public final class Main extends JavaPlugin implements Listener {
    private static Main instance;
    private static final List<String> blockedWorlds = new ArrayList<>();
    @Override
    public void onEnable() {


        double now = System.currentTimeMillis();

        Bukkit.getLogger().info("Starting CelSpace v." + Celspace.version + " using Texture Packs of Version " + Load.rpVer + " ...");

        instance = this;

        final FileConfiguration config = this.getConfig();

        //Config
        List<String> cnf = new ArrayList<>();
        cnf.add("This is the configuration file for CelSpace!");
        cnf.add("The following options should only be changed, if necessary!");
        config.options().setHeader(cnf);
        config.addDefault("performanceMode", false);
        config.addDefault("rocketCrafting", true);
        config.addDefault("SpaceArmorCrafting", true);
        config.addDefault("DisableReconnectResourcePackEnforce", false);
        config.addDefault("LoadRPDelayAfterJoin", 2);
        config.addDefault("enableFalseWeather", false);
        config.addDefault("enableThermoDamage", false);
        config.addDefault("AllowPortables", false);
        config.addDefault("rocketEntryYDistanceToGround", 50);
        config.addDefault("rocketParticlesYDistanceFromMinecartEntitiy", 1.5);

        config.options().copyDefaults(true);
        this.saveConfig();

        Celspace.rocketParticlesYDistanceFromMinecartEntitiy = config.getDouble("rocketParticlesYDistanceFromMinecartEntitiy");
        Celspace.rocketEntryYDistanceToGround = config.getInt("rocketEntryYDistanceToGround");

        //Add Worlds, where mob spawning is blocked
        blockedWorlds.add("moon");
        blockedWorlds.add("ars");
        blockedWorlds.add("mercury");
        blockedWorlds.add("venus");

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
        this.getServer().getPluginManager().registerEvents(new RocketPlacer(), this);
        this.getServer().getPluginManager().registerEvents(new RocketDestroyer(), this);


        //ConfigReact
        if(!config.getBoolean("DisableReconnectResourcePackEnforce")) {
            this.getServer().getPluginManager().registerEvents(new RpConnected(), this);
        }

        if (config.getBoolean("enableThermoDamage")) {

            surv.Thermo.startThermoHandler(this);

        }

        //enableFalseWeather
        if(!config.getBoolean("enableFalseWeather")) {
            Weater.innitWeather();
            this.getServer().getPluginManager().registerEvents(new Weater(), this);
        }

        //inits
        gravity.GravityHandler.innitGravity();
        surv.Air.startAirHandler(getInstance());


        if(config.getBoolean("performanceMode")) {
            //For later
            Bukkit.broadcastMessage("Performance Mode on");
        }


        if(config.getBoolean("rocketCrafting")) {
            AddRecipes.addRecipe0(getInstance());
        }
        //SpaceArmorCrafting
        if(config.getBoolean("SpaceArmorCrafting")) {
            AddRecipes.addRecipe1(getInstance());
            AddRecipes.addRecipe2(getInstance());
        }

        //AllowPortables
        if(config.getBoolean("AllowPortables")) {
            AddRecipes.addRecipe3(getInstance());
        }

        DimRestartSaver.loadData(this.getDataFolder() + "/dimensionPlayerData");

        //Ende
        double startTime = System.currentTimeMillis() - now;
        Bukkit.getLogger().info("[Celspace] Started in: " + startTime + "ms!");
    }

    @Override
    public void onDisable() {

        DimRestartSaver.saveData(this.getDataFolder() + "/dimensionPlayerData");
        AddRecipes.removeRecipe();

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
