package sec;

import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.nio.charset.StandardCharsets;

public class PlayerClientChecker implements PluginMessageListener {
    @Override
    public void onPluginMessageReceived(String channel, Player p, byte[] msg) {

        //Future: Check for Optifine?!

        p.sendMessage("Your client brand seems to be: " + new String(msg, StandardCharsets.UTF_8).substring(1));
    }
}