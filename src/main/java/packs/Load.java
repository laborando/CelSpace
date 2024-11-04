package packs;

import manage.DimChanger;
import org.bukkit.entity.Player;

public class Load {

    public static String rpVer = "v0.2";

    public static void loadResourceoack(Player p, DimChanger.TargetDimension td){



        if(td.equals(DimChanger.TargetDimension.OVERWORLD)){
            p.sendMessage("Changing texturepacket to " + td.name());
            //v0.2
            p.setResourcePack("https://mediafilez.forgecdn.net/files/5756/153/earth.zip");
        }else if(td.equals(DimChanger.TargetDimension.MARS)){
            p.sendMessage("Changing texturepacket to " + td.name());
            //v0.2
            p.setResourcePack("https://mediafilez.forgecdn.net/files/5756/162/mars.zip");
        }else if(td.equals(DimChanger.TargetDimension.MERKUR)){
            p.sendMessage("Changing texturepacket to " + td.name());
            //v0.2
            p.setResourcePack("https://mediafilez.forgecdn.net/files/5756/176/mercury.zip");
        }else if(td.equals(DimChanger.TargetDimension.MOON)){
            p.sendMessage("Changing texturepacket to " + td.name());
            //v0.2
            p.setResourcePack("https://mediafilez.forgecdn.net/files/5756/179/moon.zip");
        }else if(td.equals(DimChanger.TargetDimension.VENUS)){
            p.sendMessage("Changing texturepacket to " + td.name());
            //v0.2
            p.setResourcePack("https://mediafilez.forgecdn.net/files/5756/184/venus.zip");
        }

    }

}
