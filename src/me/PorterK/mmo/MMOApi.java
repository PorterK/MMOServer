package me.PorterK.mmo;

import me.PorterK.mmo.me.PorterK.mmo.Classes.Classes;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by Kalob on 11/7/2015.
 */
public class MMOApi {

    MySQL sql;

    public void connectToDatabase(){

        MySQL sql = new MySQL("host", "port", "database", "user", "password");

        try{
            sql.open();
        }catch(Exception e){

            Bukkit.getLogger().log(Level.SEVERE, "Could not connect to SQL database!");

        }

    }

    public boolean checkPlayerHasClass(Player p){

        try {

            if (sql.isConnected()) {

                ResultSet res = sql.query("SELECT * FROM users WHERE player='" + p.getName() + "'");
                if(res != null){

                    String c = res.getString("ClassType");

                    return c != null;

                }else return false;

            }else{
                connectToDatabase();

                ResultSet res = sql.query("SELECT * FROM users WHERE player='" + p.getName() + "'");
                if(res != null){

                    String c = res.getString("ClassType");

                    return c != null;

                }else return false;
            }
        }catch(Exception e){

            e.printStackTrace();

        }
        return false;
    }

    public String checkPlayerClass(Player p){

        String classType = "";

        try{

            if(checkPlayerHasClass(p)) {

                if (sql.isConnected()) {

                    ResultSet res = sql.query("SELECT * FROM users WHERE player='" + p.getName() + "'");

                    classType = res.getString("ClassType");
                } else {

                    connectToDatabase();

                    ResultSet res = sql.query("SELECT * FROM users WHERE player='" + p.getName() + "'");

                    classType = res.getString("ClassType");

                }

            }else{

                Bukkit.getLogger().log(Level.SEVERE, "checkPlayerClass(" + p.getName() + ") failed. ERROR: Player has no class");

            }

        }catch(Exception e){

            e.printStackTrace();

        }

        return classType;
    }

    public int checkPlayerLevel(Player p){

        int level = 0;

        try{

            if(checkPlayerHasClass(p)) {

                if (sql.isConnected()) {

                    ResultSet res = sql.query("SELECT * FROM users WHERE player='" + p.getName() + "'");

                    level = res.getInt("Level");
                } else {

                    connectToDatabase();

                    ResultSet res = sql.query("SELECT * FROM users WHERE player='" + p.getName() + "'");

                    level = res.getInt("Level");

                }

            }else{

                Bukkit.getLogger().log(Level.SEVERE, "chackPlayerLevel(" + p.getName() + ") failed. ERROR: Player has no class");

            }

        }catch(Exception e){

            e.printStackTrace();

        }

        return level;
    }

    public int random(int min, int max)
    {
        return (int) (min + (Math.random() * (max - min) + 1));
    }


    public void addItem(Material m, Inventory i, String name, String lore, Integer price)
    {
        ItemStack a = new ItemStack(m, 1);

        ItemMeta b = a.getItemMeta();

        List<String> c = new ArrayList<String>();

        c.add(lore);
        c.add(ChatColor.GREEN + "" + price + " emeralds!");

        b.setDisplayName(ChatColor.GOLD + name);

        b.setLore(c);

        a.setItemMeta(b);

        i.addItem(a);
    }

    public void openClassSelect(Player p)
    {
        Inventory classShop = Bukkit.getServer().createInventory(null, 54, ChatColor.GOLD + "Choose Your Class!");

        for (Classes c : Classes.values())
        {
            addItem(c.getDisplay(), classShop, c.getName(), c.getDesc(), 0);
        }

        p.openInventory(classShop);
    }

}
