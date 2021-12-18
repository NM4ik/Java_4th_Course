package ru.nm4ik.Server;

import ru.nm4ik.Entity.EntityGuard;
import ru.nm4ik.Entity.EntityMonster;
import ru.nm4ik.Entity.EntityPlayer;

import java.util.ArrayList;
import java.util.Arrays;

public class GameServer {
    private World world;
    private int updateCounter = 0;
    private static GameServer instance;


    public void updateServer() {
        if (world != null) {
            updateCounter++;
            world.updateWorld();
        }
    }


    public static void main(String[] args) {
        GameServer gameServer = new GameServer();
        for (int i = 0; i < 40; i++) {
            instance.updateServer();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(instance);
        }

        System.out.printf("Конец игры: ");
    }


    public GameServer() {
        instance = this;

        world = new World(
                new ArrayList<>(Arrays.asList(
                        new EntityPlayer("2", -8, 9, 0, 100, 100, 2),
                        new EntityMonster("monster1", 12, 12, 0, 100, 100, 20),
                        new EntityGuard("guard1", 14, 14, 0, 100, 100),
                        new EntityPlayer("player5", 18, 18, 0, 100, 100, 0),
                        new EntityPlayer("6", 1, -2, 0, 100, 100, 3)
                ))
        );
    }

    @Override
    public String toString() {
        return "GameServer{" +
                "world=" + world +
                ", updateCounter=" + updateCounter +
                '}';
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public int getUpdateCounter() {
        return updateCounter;
    }

    public void setUpdateCounter(int updateCounter) {
        this.updateCounter = updateCounter;
    }

    public static GameServer getInstance() {
        return instance;
    }
}
