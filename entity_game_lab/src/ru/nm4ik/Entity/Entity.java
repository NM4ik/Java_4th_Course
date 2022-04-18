package ru.nm4ik.Entity;

public abstract class Entity {
    protected String title;
    protected int xPos;
    protected int zPos;
    protected int age; //quantity survive update
    protected double maxHealth; //max of health points
    protected double health; // number of lives

    public Entity(String title, int xPos, int zPos, int age, double maxHealth, double health) {
        this.title = title;
        this.xPos = xPos;
        this.zPos = zPos;
        this.age = age;
        this.maxHealth = maxHealth;
        this.health = health;
    }

    public void update() {
        age++;
    }

    public boolean attackEntityFrom(Entity entity, double damage) {
        if (this.health <= 0)
            return true;
        this.health -= damage;
        if (this.health <= 0) {
            System.out.println(entity.getTitle() + " kill " + this.title);
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "Entity{" +
                "title='" + title + '\'' +
                ", xPos=" + xPos +
                ", zPos=" + zPos +
                ", age=" + age +
                ", maxHealth=" + maxHealth +
                ", health=" + health +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getzPos() {
        return zPos;
    }

    public void setzPos(int zPos) {
        this.zPos = zPos;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }
}
