package me.PorterK.mmo;

import net.minecraft.server.v1_8_R3.CommandHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Kalob on 11/7/2015.
 */
public class MMOCommandHandler implements CommandExecutor {

    public MMOCommandHandler plugin;

    public boolean onCommand(CommandSender s, Command c, String commandLabel, String[] args){

        Player p = (Player )s;

        if(args[0].equalsIgnoreCase("mmo")){

            if (s.hasPermission("mmo.admin")) {

                if(args[1].equalsIgnoreCase("admin")){

                    p.sendMessage(ChatColor.DARK_RED + "You are an admin ;)");

                }

            }

            p.sendMessage(ChatColor.GOLD + "MMO Plugin created by PorterK");

        }

        return false;
    }

}
