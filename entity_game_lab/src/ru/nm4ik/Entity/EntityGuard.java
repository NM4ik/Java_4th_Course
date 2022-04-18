package ru.nm4ik.Entity;

import ru.nm4ik.Server.GameServer;

import java.util.List;

public class EntityGuard extends Entity {
    public EntityGuard(String title, int xPos, int zPos, int age, double maxHealth, double health) {
        super(title, xPos, zPos, age, maxHealth, health);
    }

    public void update(){
        super.update();
        List<Entity> entities = GameServer.getInstance().getWorld().getEntitiesNearEntity(this, 20);
        if (entities.size() > 0) {
            if (entities.get(0).getxPos() > this.xPos)
                this.xPos++;
            else if (entities.get(0).getxPos() < this.xPos)
                this.xPos--;
            if (entities.get(0).getzPos() > this.zPos)
                this.zPos++;
            else if (entities.get(0).getzPos() < this.zPos)
                this.zPos--;
        }
    }

    @Override
    public String toString() {
        return "EntityGuard{" +
                "title='" + title + '\'' +
                ", xPos=" + xPos +
                ", zPos=" + zPos +
                ", age=" + age +
                ", maxHealth=" + maxHealth +
                ", health=" + health +
                '}';
    }
}
