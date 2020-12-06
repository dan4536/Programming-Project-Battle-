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
    
    
    //Attack player method
    //See enemy's health is greater than damage
    //If health greater
    //Damage enemy
    //Else enemy is dead
    public void attacked(int damageAmount, int myHealth) {
        if (damageAmount >= this.health || myHealth<=0) {
           // this.health = 0;
            System.out.println("\t"+this.name + " is dead!");
         
            System.out.println("\t======================ENEMY KILLED=============================");
            this.dead = true;
        } else {
            damageAmount-=10;
            Random rn=new Random();
            damageAmount+=rn.nextInt(10)+1;
            this.health -= damageAmount;
            System.out.println("\t>Your damage: "+damageAmount);
        }
        
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


    public int getExperienceGain(){
        return experienceGain;
    }

 
 }
