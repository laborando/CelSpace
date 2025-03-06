package packs;

import manage.DimChanger;
import org.bukkit.entity.Player;

public class Load {

    public static String rpVer = "v0.3";

    public static void loadResourceoack(Player p, DimChanger.TargetDimension td){



        if(td.equals(DimChanger.TargetDimension.OVERWORLD)){
            p.sendMessage("Changing texturepacket to " + td.name());
            //v0.2
            p.setResourcePack("https://mediafilez.forgecdn.net/files/6267/774/earth.zip");
        }else if(td.equals(DimChanger.TargetDimension.MARS)){
            p.sendMessage("Changing texturepacket to " + td.name());
            //v0.2
            p.setResourcePack("https://mediafilez.forgecdn.net/files/6267/768/mars.zip");
        }else if(td.equals(DimChanger.TargetDimension.MERKUR)){
            p.sendMessage("Changing texturepacket to " + td.name());
            //v0.2
            p.setResourcePack("https://mediafilez.forgecdn.net/files/6267/735/mercury.zip");
        }else if(td.equals(DimChanger.TargetDimension.MOON)){
            p.sendMessage("Changing texturepacket to " + td.name());
            //v0.2
            p.setResourcePack("https://mediafilez.forgecdn.net/files/6267/784/moon.zip");
        }else if(td.equals(DimChanger.TargetDimension.VENUS)){
            p.sendMessage("Changing texturepacket to " + td.name());
            //v0.2
            p.setResourcePack("https://mediafilez.forgecdn.net/files/6267/782/venus.zip");
        }else if(td.equals(DimChanger.TargetDimension.PLUTO)){
            p.sendMessage("Changing texturepacket to " + td.name());
            //v0.2
            p.setResourcePack("https://mediafilez.forgecdn.net/files/6268/457/pluto.zip");
        }

    }

}
