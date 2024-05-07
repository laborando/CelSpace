package cmd;

import Mars.MarsGen;
import cel.space.Main;
import cel.space.celutis;
import manage.DimChanger;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import cel.space.celutis;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.permissions.Permission;

import java.io.File;

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


        if (label.equalsIgnoreCase("mars")) {
            if(!(sender instanceof Player)){
                sender.sendMessage(ChatColor.RED + "This command can only be executed as a player!");
                return false;
            }
            if(!(sender.isOp())){
                sender.sendMessage(ChatColor.RED + "You don't have the permission to execute this command!");
                return false;
            }
            Player p = (Player) sender;

            DimChanger.sendPlayer(p, DimChanger.TargetDimension.MARS);


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

            p.setResourcePack("");p.setResourcePack("https://github.com/laborando/laborando/blob/main/public/mc/space/rp/mars.zip?raw=true");




        }else if (label.equalsIgnoreCase("celspace")) {


            if (!(sender instanceof Player p)) {
                sender.sendMessage(ChatColor.RED + "This command can only be executed as a player!");
                return false;
            }
            if (!(sender.isOp())) {
                sender.sendMessage(ChatColor.RED + "You don't have the permission to execute this command!");
                return false;
            }

            if (arg.equalsIgnoreCase("goto")) {

                if (arg2.equalsIgnoreCase("mars")) {

                    DimChanger.sendPlayer(p, DimChanger.TargetDimension.MARS);

                } else if (arg2.equalsIgnoreCase("earth")) {

                    DimChanger.sendPlayer(p, DimChanger.TargetDimension.OVERWORLD);

                } else if (arg2.equalsIgnoreCase("moon")) {

                    DimChanger.sendPlayer(p, DimChanger.TargetDimension.MOON);

                }

            }

        }


        return false;
    }

}
