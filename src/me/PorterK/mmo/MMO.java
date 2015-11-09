package me.PorterK.mmo;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by Kalob on 11/7/2015.
 */
public class MMO extends JavaPlugin{


    public MMOCommandHandler CommandExecutor = new MMOCommandHandler();

        public void onEnable(){

            Bukkit.getLogger().log(Level.INFO, ChatColor.RED + "Custom plugin by PorterK enabled...");

            getCommand("mmo").setExecutor(CommandExecutor);

            MySQL sql = new MySQL("host", "port", "database", "user", "password");

            try{
                sql.open();
            }catch(Exception e){

                Bukkit.getLogger().log(Level.SEVERE, "Could not connect to SQL database!");

            }

        }

        public void onDisable(){

            Bukkit.getLogger().log(Level.INFO, ChatColor.RED + "Custom plugin by PorterK disabled...");

        }
}
