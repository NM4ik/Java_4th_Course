package ru.nm4ik.Entity;

import ru.nm4ik.Server.GameServer;

import java.util.List;

public class EntityMonster extends Entity {
    private double damage;

    public EntityMonster(String title, int xPos, int zPos, int age, double maxHealth, double health, double damage) {
        super(title, xPos, zPos, age, maxHealth, health);
        this.damage = damage;
    }

    @Override
    public void update() {
        super.update();
        List<Entity> entities = GameServer.getInstance().getWorld().getEntitiesNearEntity(this, 20);
        if (entities.size() > 0) {
            Entity target = entities.get(0);
            if (target.getxPos() > this.xPos)
                this.xPos++;
            else if (target.getxPos() < this.xPos)
                this.xPos--;
            if (target.getzPos() > this.zPos)
                this.zPos++;
            else if (target.getzPos() < this.zPos)
                this.zPos--;


            if(Math.sqrt(Math.pow((target.getxPos() - xPos), 2) + Math.pow(target.getzPos() - zPos, 2)) <= 2){
                entities.get(0).attackEntityFrom(this, this.damage);
            }
        }
    }

    @Override
    public String toString() {
        return "EntityMonster{" +
                "title='" + title + '\'' +
                ", xPos=" + xPos +
                ", zPos=" + zPos +
                ", age=" + age +
                ", maxHealth=" + maxHealth +
                ", health=" + health +
                ", damage=" + damage +
                '}';
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }
}
