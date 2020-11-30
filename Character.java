//PROGRAMMING PROJECT
package game;
import java.util.Random;
    public class Character {
    private String name;
    private int Level;                      //This NEEDS TO BE UPDATED. Show Level in Character menu plus skills unlock as you progress
    private int experience;                 //This NEEDS TO BE UPDATED. Show experience in Character menu
    private int health;
    private int damage;                     //This NEEDS TO BE UPDATED. DAMAGE INCREASES with level
    private int potion =1;                     //This NEEDS TO BE UPDATED. Does not trigger damage from enemy and resets to player's turn
    private boolean dead = false;
    public int enemyKills;                //THIS NEEDS TO BE UPDATED. For boos battle triggers. Can be removed if game is sequence based fights
    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public Character(boolean dead) {
        this.dead = dead;
    }

    public Character(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
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
    
    public void addEnemy(){                     //THIS NEEDS TO BE UPDATED
        enemyKills+=1;
    }

    public void attacked(int abilityDamage, int myHealth) {
        if ( abilityDamage>= this.health || myHealth<=0) {
           // this.health = 0;
            System.out.println(this.name + " is dead!");
            this.dead = true;
        } else {
            abilityDamage-=10;
            Random rn=new Random();
            abilityDamage+=rn.nextInt(10)+1;
            this.health -= abilityDamage;

            System.out.println("The remaining life of " + this.name + " is: " + this.health);

       
        }
     }
    public void heal(){
    setHealth(getHealth()+100);
    }
    
    public void addPotion(){
     potion+=1;
     }
    public int getPotion(){
    return potion;
    }
    
    }

