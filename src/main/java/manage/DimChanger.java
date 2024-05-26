package manage;

import dimensions.mars.MarsGen;
import cel.space.celutis;
import dimensions.earth.MoonGen;
import org.bukkit.*;
import org.bukkit.entity.Player;

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



        ;

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

            p.sendMessage("Loading Ressource Pack for 'Mars'. Some features will only work if you are using Optifine!");;
            p.setResourcePack("https://github.com/laborando/laborando/blob/main/public/mc/space/rp/mars.zip?raw=true");

        }else if(t == TargetDimension.OVERWORLD){

            final String wn = "world";
            World targetWorld = Bukkit.getWorld(wn);
            Location l = targetWorld.getHighestBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockZ()).getLocation();
            p.teleport(l);

            //RESOURCE PACK

            p.sendMessage("Loading Ressource Pack for 'Earth'. Some features will only work if you are using Optifine!");;
            p.setResourcePack("");

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

            p.sendMessage("Loading Ressource Pack for 'Mars'. Some features will only work if you are using Optifine!");;
            p.setResourcePack("https://github.com/laborando/laborando/blob/main/public/mc/space/rp/moon.zip?raw=true");

        }


    }

}
