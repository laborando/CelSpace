package cmd;

import manage.DimChanger;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
            if(!(sender.isOp())){
                sender.sendMessage(ChatColor.RED + "You don't have the permission to execute this command!");
                return false;
            }

            p.setResourcePack("t");//p.setResourcePack("https://github.com/laborando/laborando/blob/main/public/mc/space/rp/mars.zip?raw=true");

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



            if (!(sender.isOp())) {
                sender.sendMessage(ChatColor.RED + "You don't have the permission to execute this command!");
                return false;
            }






            if (!(sender instanceof Player p)) {
                sender.sendMessage(ChatColor.RED + "This command can only be executed as a player!");
                return false;
            }
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

            }else if(arg.equalsIgnoreCase("testRp")){
                //Random Resource Pack to test if able to get resource packs from cf
                //p.setResourcePack("");p.setResourcePack("https://mediafilez.forgecdn.net/files/5297/551/MandalasGUI%2BDakmode_1.20.5.zip");
                //https://legacy.curseforge.com/minecraft/texture-packs/mandalas-gui-dark-mode/download
            }

        }


        return false;
    }

}
