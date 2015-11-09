package me.PorterK.mmo;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import javax.xml.bind.Marshaller;

/**
 * Created by Kalob on 11/7/2015.
 */
public class MMOListener implements Listener {

    MMOApi api = new MMOApi();

    public void onPlayerLogin(PlayerJoinEvent e){

        Player p = e.getPlayer();

        if(api.checkPlayerHasClass(p)){

            p.sendMessage(ChatColor.GOLD + "Welcome to PVPPros! You are a level " + "<> " + ChatColor.AQUA + api.checkPlayerClass(p));

        }

    }

}
