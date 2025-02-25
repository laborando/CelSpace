package manage;

import dimensions.solar.earth.MoonGen;
import dimensions.solar.mars.MarsGen;
import dimensions.solar.mercury.MercuryGen;
import dimensions.solar.venus.VenusGen;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
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
            Bukkit.getLogger().info("[Celspace] Login Location Saver: Save login for: " + e.getPlayer().getName() + "into target World: " + wn);
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
            }else if(wn.equals("venus")){
                e.setResult(PlayerLoginEvent.Result.KICK_OTHER);
                final WorldCreator worldCreator2 = new WorldCreator(wn);
                worldCreator2.generator(new VenusGen());
                worldCreator2.seed(Bukkit.getWorld("world").getSeed());
                Bukkit.createWorld(worldCreator2);
            }else{
                e.setResult(PlayerLoginEvent.Result.ALLOWED);
                dims.remove(e.getPlayer().getUniqueId().toString());
                e.getPlayer().sendMessage(ChatColor.RED + "Your world seemed to be unloaded!");
                Bukkit.getLogger().info("[Celspace] Login Location Saver: Player " + e.getPlayer().getName() + "seemed to load into an unloaded world( " +  wn + " ), but Celspace is not affiliated with this world!");
            }


            /*
            final WorldCreator worldCreator2 = new WorldCreator(wn);
            worldCreator2.generator(new MercuryGen());
            worldCreator2.seed(Bukkit.getWorld("world").getSeed());
            Bukkit.createWorld(worldCreator2);
             */







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
            final BukkitObjectOutputStream out = new BukkitObjectOutputStream(new GZIPOutputStream(new FileOutputStream(filePath)));
            out.writeObject(dims);
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

    @SuppressWarnings("unchecked") //dims = (HashMap<String, String>)in.readObject(); is unsafe, but not important to be checked
    public static void loadData(final String filePath) {
        try {
            final BukkitObjectInputStream in = new BukkitObjectInputStream(new GZIPInputStream(new FileInputStream(filePath)));
            dims = (HashMap<String, String>)in.readObject();
            in.close();
        }
        catch (ClassNotFoundException | IOException ex2) {
            System.out.println("Probably first time starting... Creating new File. Do not report the following unless it is happening for more than two times");
            dims = new HashMap<>();
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
