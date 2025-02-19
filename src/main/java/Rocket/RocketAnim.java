package Rocket;

import cel.space.Celspace;
import dimensions.solar.mars.MarsGen;
import cel.space.Main;
import cel.space.celutis;
import dimensions.solar.earth.MoonGen;
import dimensions.solar.mercury.MercuryGen;
import dimensions.solar.venus.VenusGen;
import manage.DimChanger;
import org.bukkit.*;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import packs.Load;

public class RocketAnim {

    //        ___ Kritisch für mehrere Spieler :O
    //      /
     //     |
     //     \/
    static int durch = 0;

    public static void startRocket(Player p, DimChanger.TargetDimension td){

        Minecart m = celutis.getMinecartRiddenByPlayer(p);
        if(m == null){
            return;
        }
        if(!(p.getInventory().contains(new ItemStack(Material.COAL, 64)))){
            p.sendMessage(ChatColor.RED + "You need 64 Coal in your Inventory to fuel this rocket!");
            m.eject();
            return;
        }
        p.getInventory().removeItem(new ItemStack(Material.COAL, 64));


        durch = 0;


        new BukkitRunnable() {
            @Override
            public void run() {
                p.getWorld().spawnParticle(Particle.FLAME, p.getLocation().add(0, -1 * Celspace.rocketParticlesYDistanceFromMinecartEntitiy, 0), 20, 0.3, 0.2, 0.3);
                p.spawnParticle(Particle.FLAME, p.getLocation().add(0, -1.5, 0),  50, 0, 0,0);
                m.setVelocity(m.getVelocity().add(new Vector(0, 0.5, 0)));

                durch++;
                if(durch > 40){

                    executeDimChange(m, p, td);

                    this.cancel();
                }
            }
        }.runTaskTimer(Main.getInstance(), 0 /*<- init delay */, 1L /*<- interval */);

    }


    public static void executeDimChange(Minecart m, Player p, DimChanger.TargetDimension td){

        if(td.equals(DimChanger.TargetDimension.MARS)){

            final String wn = "source/structure/mars";
            if (!celutis.doesWorldExist(wn)) {
                p.sendMessage(ChatColor.RED + "Generation of Mars started...");
                final WorldCreator worldCreator = new WorldCreator(wn);
                worldCreator.generator(new MarsGen());
                worldCreator.seed(Bukkit.getWorld("world").getSeed());
                Bukkit.createWorld(worldCreator);
            }
            World targetWorld = Bukkit.getWorld(wn);
            if(targetWorld == null){

                final WorldCreator worldCreator2 = new WorldCreator(wn);
                worldCreator2.generator(new MarsGen());
                worldCreator2.seed(Bukkit.getWorld("world").getSeed());
                Bukkit.createWorld(worldCreator2);

            }
            p.sendMessage("Loading Ressource Pack for 'Mars'. Some features will only work if you are using Optifine!");
            Load.loadResourceoack(p, DimChanger.TargetDimension.MARS);
            targetWorld = Bukkit.getWorld(wn);
            Location l = targetWorld.getHighestBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockZ()).getLocation().add(0, Celspace.rocketEntryYDistanceToGround, 0);
            m.eject();
            m.teleport(l);
            p.teleport(l);
            m.addPassenger(p);
            p.closeInventory();

            //RESOURCE PACK

        }else if(td.equals(DimChanger.TargetDimension.OVERWORLD)){

            final String wn = "world";
            World targetWorld = Bukkit.getWorld(wn);
            if(targetWorld == null){
                Bukkit.getLogger().info("World 'world' was not found!");
            }
            p.sendMessage("Loading Ressource Pack for 'Earth'. Some features will only work if you are using Optifine!");
            Load.loadResourceoack(p, DimChanger.TargetDimension.OVERWORLD);
            targetWorld = Bukkit.getWorld(wn);
            Location l = targetWorld.getHighestBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockZ()).getLocation().add(0, Celspace.rocketEntryYDistanceToGround, 0);
            m.eject();
            m.teleport(l);
            p.teleport(l);
            m.addPassenger(p);
            p.closeInventory();

        }else if(td.equals(DimChanger.TargetDimension.MOON)){

            final String wn = "moon";
            if (!celutis.doesWorldExist(wn)) {
                p.sendMessage(ChatColor.RED + "Generation of Moon started...");
                final WorldCreator worldCreator = new WorldCreator(wn);
                worldCreator.generator(new MoonGen());
                worldCreator.seed(Bukkit.getWorld("world").getSeed());
                Bukkit.createWorld(worldCreator);
            }
            World targetWorld = Bukkit.getWorld(wn);
            if(targetWorld == null){

                final WorldCreator worldCreator2 = new WorldCreator(wn);
                worldCreator2.generator(new MoonGen());
                worldCreator2.seed(Bukkit.getWorld("world").getSeed());
                Bukkit.createWorld(worldCreator2);

            }
            p.sendMessage("Loading Ressource Pack for 'Moon'. Some features will only work if you are using Optifine!");
            Load.loadResourceoack(p, DimChanger.TargetDimension.MOON);
            targetWorld = Bukkit.getWorld(wn);
            Location l = targetWorld.getHighestBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockZ()).getLocation().add(0, Celspace.rocketEntryYDistanceToGround, 0);
            m.eject();
            m.teleport(l);
            p.teleport(l);
            m.addPassenger(p);
            p.closeInventory();

        }else if(td.equals(DimChanger.TargetDimension.MERKUR)){

            final String wn = "mercury";
            if (!celutis.doesWorldExist(wn)) {
                p.sendMessage(ChatColor.RED + "Generation of Mercury started...");
                final WorldCreator worldCreator = new WorldCreator(wn);
                worldCreator.generator(new MercuryGen());
                worldCreator.seed(Bukkit.getWorld("world").getSeed());
                Bukkit.createWorld(worldCreator);
            }
            World targetWorld = Bukkit.getWorld(wn);
            if(targetWorld == null){

                final WorldCreator worldCreator2 = new WorldCreator(wn);
                worldCreator2.generator(new MercuryGen());
                worldCreator2.seed(Bukkit.getWorld("world").getSeed());
                Bukkit.createWorld(worldCreator2);

            }
            p.sendMessage("Loading Ressource Pack for 'Mercuy'. Some features will only work if you are using Optifine!");
            Load.loadResourceoack(p, DimChanger.TargetDimension.MERKUR);
            targetWorld = Bukkit.getWorld(wn);
            Location l = targetWorld.getHighestBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockZ()).getLocation().add(0, Celspace.rocketEntryYDistanceToGround, 0);
            m.eject();
            m.teleport(l);
            p.teleport(l);
            m.addPassenger(p);
            p.closeInventory();

        }else if(td.equals(DimChanger.TargetDimension.VENUS)){
            final String wn = "venus";
            if (!celutis.doesWorldExist(wn)) {
                p.sendMessage(ChatColor.RED + "Generation of Venus started...");
                final WorldCreator worldCreator = new WorldCreator(wn);
                worldCreator.generator(new VenusGen());
                worldCreator.seed(Bukkit.getWorld("world").getSeed());
                Bukkit.createWorld(worldCreator);
            }
            World targetWorld = Bukkit.getWorld(wn);
            if(targetWorld == null){

                final WorldCreator worldCreator2 = new WorldCreator(wn);
                worldCreator2.generator(new VenusGen());
                worldCreator2.seed(Bukkit.getWorld("world").getSeed());
                Bukkit.createWorld(worldCreator2);

            }
            p.sendMessage("Loading Ressource Pack for 'Venus'. Some features will only work if you are using Optifine!");
            Load.loadResourceoack(p, DimChanger.TargetDimension.VENUS);
            targetWorld = Bukkit.getWorld(wn);
            Location l = targetWorld.getHighestBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockZ()).getLocation().add(0, Celspace.rocketEntryYDistanceToGround, 0);
            m.eject();
            m.teleport(l);
            p.teleport(l);
            m.addPassenger(p);
            p.closeInventory();

        }

    }

}
