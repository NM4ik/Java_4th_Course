package ru.nm4ik.Server;

import ru.nm4ik.Entity.*;

import java.util.*;


public class World {
    private List<Entity> entities;

    public World(List<Entity> entities) {
        this.entities = entities;
    }

    public void updateWorld() {
        for (int i = 0; i < entities.size(); i++)
            entities.get(i).update();
        entities.removeIf(entity -> entity.getHealth() <= 0);
    }

    public List<Entity> getEntitiesInRegion(int x, int z, double range) {
        List<Entity> inRegionEntities = new ArrayList<>();
        for (Entity e : entities) {
            if (e != null) {
                if (Math.sqrt(Math.pow((x - e.getxPos()), 2) + Math.pow(z - e.getzPos(), 2)) <= range && e instanceof EntityPlayer) {
                    {
                        inRegionEntities.add(e);
                    }
                }
            }
        }
        return inRegionEntities;
    }

    public List<Entity> getEntitiesNearEntity(Entity entity, double range) {
        return getEntitiesInRegion(entity.getxPos(), entity.getzPos(), range);
    }

    public List<Entity> getGuardiansInRegion(int x, int z, double range) {
        List<Entity> getGuardiansInRegion = new ArrayList<>();
        for (Entity e : entities) {
            if (e instanceof EntityGuard) {
                if (Math.sqrt(Math.pow((x - e.getxPos()), 2) + Math.pow(z - e.getzPos(), 2)) <= range) {
                    {
                        getGuardiansInRegion.add(e);
                    }
                }
            }
        }
        return getGuardiansInRegion;
    }

    public List<Entity> getGuardiansNearEntity(Entity entity, double range) {
        return getGuardiansInRegion(entity.getxPos(), entity.getzPos(), range);
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    @Override
    public String toString() {
        return "World{" +
                "entities=" + entities +
                '}';
    }
}
