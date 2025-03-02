package cmd;

import cel.space.Celspace;
import cel.space.celutis;
import dimensions.systems.solar.mars.MarsGen;
import dimensions.systems.solar.venus.VenusGen;
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
            p.setResourcePack("");

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
                sender.sendMessage(ChatColor.GREEN + "Unloading world '" + arg + "'. This could take a bit...");
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
                sender.sendMessage(ChatColor.YELLOW + "   --> all     | Displays all available commands");
                sender.sendMessage(ChatColor.YELLOW + "   --> clearRp | Clears the resource pack set by this plugin");
                sender.sendMessage(ChatColor.YELLOW + "   --> goto    | lets you change between planets");
                sender.sendMessage(ChatColor.YELLOW + "   --> help    | Shows this list");
                sender.sendMessage(ChatColor.YELLOW + " - clearrp     | Clears the resource pack set by this plugin");
                sender.sendMessage(ChatColor.YELLOW + " - autoRp      | Automatically assigns you the right rp");
                sender.sendMessage(ChatColor.YELLOW + " - unload <w>  | Unloads the world w");
                return false;
            }
            if (arg.equalsIgnoreCase("all")) {
                sender.sendMessage(ChatColor.BLUE + "Celspace v." + Celspace.version + ChatColor.GOLD + " by cel20");
                sender.sendMessage(ChatColor.YELLOW + "Commands: ");
                sender.sendMessage(ChatColor.YELLOW + " - clearrp     | Clears the resource pack set by this plugin");
                sender.sendMessage(ChatColor.YELLOW + " - autoRp      | Automatically assigns you the right rp");
                sender.sendMessage(ChatColor.YELLOW + " - unload <w>  | Unloads the world w");
                sender.sendMessage(ChatColor.YELLOW + " - celspace    | Main celspace command");
                sender.sendMessage(ChatColor.YELLOW + "   --> all     | Displays all available commands");
                sender.sendMessage(ChatColor.YELLOW + "   --> clearRp | Clears the resource pack set by this plugin");
                sender.sendMessage(ChatColor.YELLOW + "   --> goto    | lets you change between planets");
                ////Merkur Venus Erde Mars Jupiter Saturn Uranus Neptun Pluto
                sender.sendMessage(ChatColor.BLUE + "           |-solar");
                sender.sendMessage(ChatColor.BLUE + "           |   |-mercury");
                sender.sendMessage(ChatColor.BLUE + "           |   |-venus");
                sender.sendMessage(ChatColor.BLUE + "           |   |-earth");
                sender.sendMessage(ChatColor.BLUE + "           |   |-mars");
                sender.sendMessage(ChatColor.BLUE + "           |   \\-pluto");
                sender.sendMessage(ChatColor.BLUE + "           |");
                sender.sendMessage(ChatColor.BLUE + "           \\-sanguinis");
                sender.sendMessage(ChatColor.BLUE + "               |-ignis");
                sender.sendMessage(ChatColor.BLUE + "               \\-rocky");
                sender.sendMessage(ChatColor.YELLOW + "   --> help    | Shows a abbreviation of this list");
                sender.sendMessage(ChatColor.RED + "Debug/Dev Commands:");
                sender.sendMessage(ChatColor.YELLOW + "   --> cw      | Clears the weather");
                sender.sendMessage(ChatColor.YELLOW + "   --> twm     | Creats a testworld with Mars Generator");
                sender.sendMessage(ChatColor.YELLOW + "   --> twv     | Creats a testworld with Venus Generator");
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

                } else if (arg2.equalsIgnoreCase("pluto")) {

                    p.sendMessage("Not implemented yet!");
                    //DimChanger.sendPlayer(p, DimChanger.TargetDimension.VENUS);

                }

                //Sanguinis System

                else if (arg2.equalsIgnoreCase("rocky")) {

                    DimChanger.sendPlayer(p, DimChanger.TargetDimension.ROCKY);

                } else if (arg2.equalsIgnoreCase("ignis")) {

                    DimChanger.sendPlayer(p, DimChanger.TargetDimension.IGNIS);

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


                //Now only testworld cmds
            }else if (arg.equalsIgnoreCase("twm")) {

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

            }else if (arg.equalsIgnoreCase("twv")) {

                final String wn = System.currentTimeMillis() + "";
                if (!celutis.doesWorldExist(wn)) {
                    p.sendMessage(ChatColor.RED + "Generation of Test World started...");
                    final WorldCreator worldCreator = new WorldCreator(wn);
                    worldCreator.generator(new VenusGen());
                    worldCreator.seed(Bukkit.getWorld("world").getSeed());
                    Bukkit.createWorld(worldCreator);
                }
                World targetWorld = Bukkit.getWorld(wn);
                if(targetWorld == null){

                    final WorldCreator worldCreator2 = new WorldCreator(wn);
                    worldCreator2.generator(new VenusGen());
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
