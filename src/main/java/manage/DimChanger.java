package manage;

import cel.space.celutis;
import dimensions.systems.sanguinis.ignis.IgnisGen;
import dimensions.systems.sanguinis.rocky.RockyGen;
import dimensions.systems.solar.earth.MoonGen;
import dimensions.systems.solar.mars.MarsGen;
import dimensions.systems.solar.mercury.MercuryGen;
import dimensions.systems.solar.pluto.PlutoGen;
import dimensions.systems.solar.venus.VenusGen;
import org.bukkit.*;
import org.bukkit.entity.Player;
import packs.Load;

public class DimChanger {

    public enum TargetDimension{
        MERKUR,//Merkur Venus Erde Mars Jupiter Saturn Uranus Neptun Pluto
        VENUS,
        OVERWORLD,
        MARS,
        JUPITER,
        SATURN,
        URANUS,
        NEPTUN,
        PLUTO,
        MOON, //THE moon

        IGNIS,
        ROCKY,

        ORBIT_OVERWORLD,
        ORBIT_MARS,
        ORBIT_MERCUR

    }

    public static void sendPlayer(Player p, TargetDimension t){
        if(t == TargetDimension.MARS){

            final String wn = "mars";
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
            targetWorld = Bukkit.getWorld(wn);
            Location l = targetWorld.getHighestBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockZ()).getLocation();
            p.teleport(l);

            //RESOURCE PACK

            p.sendMessage("Loading Ressource Pack for 'Mars'.");
            Load.loadResourceoack(p, TargetDimension.MARS);
        }else if(t == TargetDimension.OVERWORLD){

            final String wn = "world";
            World targetWorld = Bukkit.getWorld(wn);
            Location l = targetWorld.getHighestBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockZ()).getLocation();
            p.teleport(l);

            //RESOURCE PACK

            p.sendMessage("Loading Ressource Pack for 'Earth'.");
            Load.loadResourceoack(p, TargetDimension.OVERWORLD);



        }else if(t == TargetDimension.MOON){

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
            targetWorld = Bukkit.getWorld(wn);
            Location l = targetWorld.getHighestBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockZ()).getLocation();
            p.teleport(l);

            //RESOURCE PACK

            p.sendMessage("Loading Ressource Pack for 'Moon'.");
            Load.loadResourceoack(p, TargetDimension.MOON);

        }else if(t == TargetDimension.MERKUR){

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
            targetWorld = Bukkit.getWorld(wn);
            Location l = targetWorld.getHighestBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockZ()).getLocation();
            p.teleport(l);

            //RESOURCE PACK

            p.sendMessage("Loading Ressource Pack for 'Mercury'.");
            Load.loadResourceoack(p, TargetDimension.MERKUR);
        }else if(t == TargetDimension.VENUS){

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
            targetWorld = Bukkit.getWorld(wn);
            Location l = targetWorld.getHighestBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockZ()).getLocation();
            p.teleport(l);

            //RESOURCE PACK

            p.sendMessage("Loading Ressource Pack for 'Venus'.");
            Load.loadResourceoack(p, TargetDimension.VENUS);
        }else if(t == TargetDimension.PLUTO){

            final String wn = "pluto";
            if (!celutis.doesWorldExist(wn)) {
                p.sendMessage(ChatColor.RED + "Generation of Pluto started...");
                final WorldCreator worldCreator = new WorldCreator(wn);
                worldCreator.generator(new PlutoGen());
                worldCreator.seed(Bukkit.getWorld("world").getSeed());
                Bukkit.createWorld(worldCreator);
            }
            World targetWorld = Bukkit.getWorld(wn);
            if(targetWorld == null){

                final WorldCreator worldCreator2 = new WorldCreator(wn);
                worldCreator2.generator(new PlutoGen());
                worldCreator2.seed(Bukkit.getWorld("world").getSeed());
                Bukkit.createWorld(worldCreator2);

            }
            targetWorld = Bukkit.getWorld(wn);
            Location l = targetWorld.getHighestBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockZ()).getLocation();
            p.teleport(l);

            //RESOURCE PACK

            p.sendMessage("Loading Ressource Pack for 'Pluto'.");
            Load.loadResourceoack(p, TargetDimension.PLUTO);
        }
        
        

        //SANGUINIS SYSTEM

        else if(t == TargetDimension.ROCKY){

            final String wn = "rocky";
            if (!celutis.doesWorldExist(wn)) {
                p.sendMessage(ChatColor.RED + "Generation of Rocky started...");
                final WorldCreator worldCreator = new WorldCreator(wn);
                worldCreator.generator(new RockyGen());
                worldCreator.seed(Bukkit.getWorld("world").getSeed());
                Bukkit.createWorld(worldCreator);
            }
            World targetWorld = Bukkit.getWorld(wn);
            if(targetWorld == null){

                final WorldCreator worldCreator2 = new WorldCreator(wn);
                worldCreator2.generator(new RockyGen());
                worldCreator2.seed(Bukkit.getWorld("world").getSeed());
                Bukkit.createWorld(worldCreator2);

            }
            targetWorld = Bukkit.getWorld(wn);
            Location l = targetWorld.getHighestBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockZ()).getLocation();
            p.teleport(l);

            //RESOURCE PACK

            p.sendMessage("Loading Ressource Pack for 'Rocky'.");
            Load.loadResourceoack(p, TargetDimension.OVERWORLD);
        }else if(t == TargetDimension.IGNIS){

            final String wn = "ignis";
            if (!celutis.doesWorldExist(wn)) {
                p.sendMessage(ChatColor.RED + "Generation of Ignis started...");
                final WorldCreator worldCreator = new WorldCreator(wn);
                worldCreator.generator(new IgnisGen());
                worldCreator.seed(Bukkit.getWorld("world").getSeed());
                Bukkit.createWorld(worldCreator);
            }
            World targetWorld = Bukkit.getWorld(wn);
            if(targetWorld == null){

                final WorldCreator worldCreator2 = new WorldCreator(wn);
                worldCreator2.generator(new IgnisGen());
                worldCreator2.seed(Bukkit.getWorld("world").getSeed());
                Bukkit.createWorld(worldCreator2);

            }
            targetWorld = Bukkit.getWorld(wn);
            Location l = targetWorld.getHighestBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockZ()).getLocation();
            p.teleport(l);

            //RESOURCE PACK

            p.sendMessage("Loading Ressource Pack for 'Ignis'.");
            Load.loadResourceoack(p, TargetDimension.OVERWORLD);
        }


    }

}
