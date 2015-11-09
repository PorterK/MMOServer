package me.PorterK.mmo.me.PorterK.mmo.Classes;

import org.bukkit.Material;

import java.lang.*;

/**
 * Created by Kalob on 11/7/2015.
 */
public enum Classes {

    Warrior(Warrior.class, "Warrior", "You are a warrior!", Material.IRON_CHESTPLATE, 100, 25);

    private Class<? extends ClassType> type;
    private String name;
    private String desc;
    private Material display;
    private int health;
    private int maxLevel;

    Classes(Class<? extends ClassType> type, String name, String desc, Material display, int health, int maxLevel){

        this.type = type;
        this.name = name;
        this.desc = desc;
        this.display = display;
        this.health = health;
        this.maxLevel = maxLevel;

    }

    public String getName() {
        return name;
    }
    public String getDesc(){
        return desc;
    }
    public Material getDisplay(){
        return display;
    }
    public int getHealth(){
        return health;
    }
    public int getMaxLevel(){
        return maxLevel;
    }

}
