package cmd;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TabComp implements TabCompleter {

	public List<String> onTabComplete(final CommandSender sender, final Command command, final String alias, final String[] args) {

        if (command.getName().equalsIgnoreCase("celspace") && args.length == 1) {
            final List<String> completions = new ArrayList<String>();
            completions.add("goto");
            completions.add("clearRp");
            return completions;
        }else if (command.getName().equalsIgnoreCase("unload") && args.length == 1) {
            final List<String> completions = new ArrayList<String>();
            for (World world : Bukkit.getWorlds()) {
                completions.add(world.getName());
            }
            return completions;
        }else if (command.getName().equalsIgnoreCase("celspace")) {

            if(args[0].equalsIgnoreCase("goto")){

                final List<String> completions = new ArrayList<String>();
                completions.add("mars");
                completions.add("earth");
                completions.add("moon");
                completions.add("mercury");
                completions.add("venus");
                return completions;

            }

        }
        return null;
    }
	
}
