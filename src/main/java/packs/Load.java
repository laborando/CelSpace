package packs;

import manage.DimChanger;
import org.bukkit.entity.Player;

public class Load {

    public static void loadResourceoack(Player p, DimChanger.TargetDimension td){

        if(td.equals(DimChanger.TargetDimension.OVERWORLD)){
            //5431893
            p.sendMessage("Requesting client to change texture pack...");
            p.sendMessage("Pack: Earth v0.1");
            p.setResourcePack("https://mediafilez.forgecdn.net/files/5431/893/Earth.zip");
        }else if(td.equals(DimChanger.TargetDimension.MARS)){
            //5431893
            p.setResourcePack("https://mediafilez.forgecdn.net/files/5431/893/Earth.zip");
        }else if(td.equals(DimChanger.TargetDimension.MERKUR)){
            //5431893
            p.setResourcePack("https://mediafilez.forgecdn.net/files/5431/893/Earth.zip");
        }else if(td.equals(DimChanger.TargetDimension.MOON)){
            //5431893
            p.setResourcePack("https://mediafilez.forgecdn.net/files/5431/893/Earth.zip");
        }else if(td.equals(DimChanger.TargetDimension.VENUS)){
            //5431893
            p.setResourcePack("https://mediafilez.forgecdn.net/files/5431/893/Earth.zip");
        }

    }

}
