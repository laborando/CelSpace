package sec;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.io.UnsupportedEncodingException;

public class PlayerClientChecker implements PluginMessageListener {
    @Override
    public void onPluginMessageReceived(String channel, Player p, byte[] msg) {

        //Future: Check for Optifine?!

        try {
            p.sendMessage("Your client brand seems to be: " + new String(msg, "UTF-8").substring(1));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}