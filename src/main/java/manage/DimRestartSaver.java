package manage;

import dimensions.earth.MoonGen;
import dimensions.mars.MarsGen;
import dimensions.mercury.MercuryGen;
import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.*;
import java.util.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class DimRestartSaver implements Listener {

    private static HashMap<String, String> dims = new HashMap<>();

    @EventHandler(priority = EventPriority.HIGHEST)
    private void event(final PlayerLoginEvent e){

        if(!dims.containsKey(e.getPlayer().getUniqueId().toString())){return;}

        String wn = dims.get(e.getPlayer().getUniqueId().toString());

        World targetWorld = Bukkit.getWorld(wn);
        if(targetWorld == null){
            e.setKickMessage(ChatColor.RED + "Your world is still unloaded! We are currently starting the world! \n Please try to reconnect in a minute!");
        }else{
            dims.remove(e.getPlayer().getUniqueId().toString());
            return;
        }



            if(wn.equals("mars")){
                e.setResult(PlayerLoginEvent.Result.KICK_OTHER);
                final WorldCreator worldCreator2 = new WorldCreator(wn);
                worldCreator2.generator(new MarsGen());
                worldCreator2.seed(Bukkit.getWorld("world").getSeed());
                Bukkit.createWorld(worldCreator2);
            }else if(wn.equals("moon")){
                e.setResult(PlayerLoginEvent.Result.KICK_OTHER);
                final WorldCreator worldCreator2 = new WorldCreator(wn);
                worldCreator2.generator(new MoonGen());
                worldCreator2.seed(Bukkit.getWorld("world").getSeed());
                Bukkit.createWorld(worldCreator2);
            }else if(wn.equals("mercury")){
                e.setResult(PlayerLoginEvent.Result.KICK_OTHER);
                final WorldCreator worldCreator2 = new WorldCreator(wn);
                worldCreator2.generator(new MercuryGen());
                worldCreator2.seed(Bukkit.getWorld("world").getSeed());
                Bukkit.createWorld(worldCreator2);
            }else{
                e.setResult(PlayerLoginEvent.Result.ALLOWED);
                if(dims.containsKey(e.getPlayer().getUniqueId().toString()))
                    dims.remove(e.getPlayer().getUniqueId().toString());
                e.getPlayer().sendMessage(ChatColor.RED + "Your world seemed to be unloaded!");
            }



            final WorldCreator worldCreator2 = new WorldCreator(wn);
            worldCreator2.generator(new MercuryGen());
            worldCreator2.seed(Bukkit.getWorld("world").getSeed());
            Bukkit.createWorld(worldCreator2);







        //Sichergestellt






    }

    @EventHandler(priority = EventPriority.HIGHEST)
    private void event(final PlayerQuitEvent e){
        String uuid = e.getPlayer().getUniqueId().toString();
        String w = e.getPlayer().getWorld().getName();

        dims.put(uuid, w);

    }

    public static void saveData(final String filePath) {
        try {
            final BukkitObjectOutputStream out = new BukkitObjectOutputStream((OutputStream)new GZIPOutputStream(new FileOutputStream(filePath)));
            out.writeObject((Object)dims);
            out.close();
        }
        catch (IOException e) {
            File f = new File(filePath);
            try {
                if(!f.createNewFile()) {
                    e.printStackTrace();
                }
            } catch (IOException e2) {

                e2.printStackTrace();
            }
        }
    }

    public static void loadData(final String filePath) {
        try {
            final BukkitObjectInputStream in = new BukkitObjectInputStream((InputStream)new GZIPInputStream(new FileInputStream(filePath)));
            dims = (HashMap<String, String>)in.readObject();
            in.close();
        }
        catch (ClassNotFoundException | IOException ex2) {
            System.out.println("Probably first time starting... Creating new File. Do not report the following unless it is happening for more than two times");
            dims = new HashMap<String, String>();
            File f = new File(filePath);
            try {
                if(!f.createNewFile()) {
                    ex2.printStackTrace();
                }
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }

}
