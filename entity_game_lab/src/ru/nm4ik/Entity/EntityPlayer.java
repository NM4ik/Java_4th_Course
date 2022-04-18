package ru.nm4ik.Entity;
import ru.nm4ik.Server.GameServer;


public class EntityPlayer extends Entity {
    private int exp;

    public EntityPlayer(String title, int xPos, int zPos, int age, double maxHealth, double health, int exp) {
        super(title, xPos, zPos, age, maxHealth, health);
        this.exp = exp;
    }

    public void update() {
        super.update();
        if (GameServer.getInstance().getUpdateCounter() % 2 == 0 && this.health < this.maxHealth && this.health > 0) {
            this.health++;
        }
    }
    @Override
    public boolean attackEntityFrom(Entity entity, double damage) {
        for (Entity e : GameServer.getInstance().getWorld().getEntities())
            if (e instanceof EntityGuard && this.findRange(e.getxPos(), e.getzPos()) <= 2) {
                return e.attackEntityFrom(entity, damage);
            }

        if (super.attackEntityFrom(entity, damage))
            return true;
        else {
            if (entity.attackEntityFrom(this, this.calculateDamage())) {
                exp++;
                return true;
            } else
                return false;
        }
    }

    public double findRange(double x, double z) {
        return Math.sqrt(Math.pow((x - xPos), 2) + Math.pow((z - zPos), 2));
    }

    public double calculateDamage(){
        return 3 + exp / 2;
    }


    @Override
    public String toString() {
        return "EntityPlayer{" +
                "title='" + title + '\'' +
                ", xPos=" + xPos +
                ", zPos=" + zPos +
                ", age=" + age +
                ", maxHealth=" + maxHealth +
                ", health=" + health +
                ", exp=" + exp +
                '}';
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
