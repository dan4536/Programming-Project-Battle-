//PROGRAMMING PROJECT
package game;

import java.util.Random;

 public class Enemy {
    private String name;
      private int health;
      private int damage;
      private int experienceGain;
    private boolean dead = false;
   
    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public Enemy(boolean dead) {
        this.dead = dead;
    }

    public Enemy(String name, int health, int damage, int experienceGain) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.experienceGain=experienceGain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


    public void attacked(int damageAmount, int myHealth) {
        if (damageAmount >= this.health || myHealth<=0) {
           // this.health = 0;
            System.out.println(this.name + " is dead!");
            this.dead = true;
        } else {
            damageAmount-=10;
            Random rn=new Random();
            damageAmount+=rn.nextInt(10)+1;
            this.health -= damageAmount;

            System.out.println("The remaining life of " + this.name + " is: " + this.health);

       
        }
        
} 
    public int getExperienceGain(){
        return experienceGain;
    }

 
 }
