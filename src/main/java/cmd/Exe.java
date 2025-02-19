package cmd;

import cel.space.Celspace;
import cel.space.celutis;
import dimensions.solar.mars.MarsGen;
import manage.DimChanger;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import player.Gimme;

public class Exe implements CommandExecutor {


    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {


        String arg = null;
        try {
            arg = args[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            arg = "";
        }
        String arg2 = null;
        try {
            arg2 = args[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            arg2 = "";
        }



        //MARS ENDE | RESSOURCE PACK TEST

        if (label.equalsIgnoreCase("clearrp")) {
            if(!(sender instanceof Player p)){
                sender.sendMessage(ChatColor.RED + "This command can only be executed as a player!");
                return false;
            }
            p.sendMessage("Clearing Server-set Resource Pack...");
            p.setResourcePack("");//p.setResourcePack("https://github.com/laborando/laborando/blob/main/public/mc/space/rp/mars.zip?raw=true");

        }else if (label.equalsIgnoreCase("unload")) {

            if (!(sender.isOp())) {
                sender.sendMessage(ChatColor.RED + "You don't have the permission to execute this command!");
                return false;
            }

            if(arg.equals("")){
                sender.sendMessage("Usage: /celspace unload <worldname>");
                return false;
            }

            try {
                Bukkit.getServer().unloadWorld(arg, true);
                sender.sendMessage(ChatColor.GREEN + "World '" + arg + "' should now be unloaded!");
            }catch (Exception e){
                sender.sendMessage("This was not possible: \n" + e.getMessage());
            }

        }else if (label.equalsIgnoreCase("celspace")) {

            if(arg.equalsIgnoreCase("")){
                sender.sendMessage(ChatColor.BLUE + "Celspace v." + Celspace.version + ChatColor.GOLD + " by cel20");
                sender.sendMessage(ChatColor.YELLOW + "No subcommand! For help execute /celspace help");
                return false;
            }

            if (arg.equalsIgnoreCase("help")) {
                sender.sendMessage(ChatColor.BLUE + "Celspace v." + Celspace.version + ChatColor.GOLD + " by cel20");
                sender.sendMessage(ChatColor.YELLOW + "Commands: ");
                sender.sendMessage(ChatColor.YELLOW + " - celspace    | Main celspace command");
                sender.sendMessage(ChatColor.YELLOW + "   --> help    | Shows this list");
                sender.sendMessage(ChatColor.YELLOW + "   --> clearRp | Clears the resource pack set by this plugin");
                sender.sendMessage(ChatColor.YELLOW + "   --> goto    | lets you change between planets");
                sender.sendMessage(ChatColor.YELLOW + " - clearrp     | Clears the resource pack set by this plugin");
                sender.sendMessage(ChatColor.YELLOW + " - autoRp      | Automatically assigns you the right rp");
                return false;
            }



            if (arg.equalsIgnoreCase("clearRp")) {
                if (!(sender instanceof Player p)) {
                    sender.sendMessage(ChatColor.RED + "This command can only be executed as a player!");
                    return false;
                }
                p.setResourcePack("");
            }


            if (!(sender.isOp())) {
                sender.sendMessage(ChatColor.RED + "You don't have the permission to execute this command!");
                return false;
            }






            if (!(sender instanceof Player p)) {
                sender.sendMessage(ChatColor.RED + "This command can only be executed as a player!");
                return false;
            }

            if(arg.equalsIgnoreCase("items")){
                Gimme.gimmeThatSpaceStuff((Player) sender);
            }

            //Ab hier: nur noch commands, die nur für players sind

            if (arg.equalsIgnoreCase("goto")) {

                if (arg2.equalsIgnoreCase("mars")) {

                    DimChanger.sendPlayer(p, DimChanger.TargetDimension.MARS);

                } else if (arg2.equalsIgnoreCase("earth")) {

                    DimChanger.sendPlayer(p, DimChanger.TargetDimension.OVERWORLD);

                } else if (arg2.equalsIgnoreCase("moon")) {

                    DimChanger.sendPlayer(p, DimChanger.TargetDimension.MOON);

                } else if (arg2.equalsIgnoreCase("mercury")) {

                    DimChanger.sendPlayer(p, DimChanger.TargetDimension.MERKUR);

                } else if (arg2.equalsIgnoreCase("venus")) {

                    DimChanger.sendPlayer(p, DimChanger.TargetDimension.VENUS);

                }

            }else if (arg.equalsIgnoreCase("cw")) {
                p.getWorld().setStorm(false);
                p.getWorld().setThundering(false);
                p.sendMessage("Weather should now be clear");
            }else if (arg.equalsIgnoreCase("ki")) {
                p.sendMessage("Testing appending itemname");
                ItemMeta tmpIm = p.getItemInHand().getItemMeta();
                tmpIm.setDisplayName(p.getItemInHand().getItemMeta().getDisplayName() + "test+");
                p.getItemInHand().setItemMeta(tmpIm);

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "give cel20 minecraft:minecart[ minecraft:custom_name=Rocket]");

            }else if (arg.equalsIgnoreCase("tw")) {

                final String wn = System.currentTimeMillis() + "";
                if (!celutis.doesWorldExist(wn)) {
                    p.sendMessage(ChatColor.RED + "Generation of Test World started...");
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

            }


        }


        return false;
    }

}
