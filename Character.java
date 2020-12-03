//PROGRAMMING PROJECT

package game;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
    public class Character {
    private String name;
    private int level=1;                      //This NEEDS TO BE UPDATED. Show Level in Character menu plus skills unlock as you progress
    private int experience;                 //This NEEDS TO BE UPDATED. Show experience in Character menu
    private int health;
    private int maxHealth;
    private int lives=1;
    private int damage;                     //This NEEDS TO BE UPDATED. DAMAGE INCREASES with level
    private int potion =1;                    
    private boolean dead = false;
    public int enemyKills;                
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
        maxHealth=health;
    }
    public int getExperience(){
    return experience;
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
     public int getLevel() {
        return level;
    }
     public void levelUp(){
     level+=1;
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
    System.out.print("Your health increased from "+getHealth()+" to ");
    if(health+100>maxHealth)
    health=maxHealth;
    else
    setHealth(getHealth()+100);
    System.out.print(getHealth());
    potion-=1;
    }
   
    public void addPotion(){
     potion+=1;
     }
    public int getPotion(){
    return potion;
    }
  public int lossLife(){
  lives-=1;
  return lives;
  }
  public int getLife(){
  return lives;
  }
  public void resetHealth(){
  health=maxHealth;
  }
  public void resurrect(){
  dead=false;
  }
  public void addExperienceGain(Enemy enemy){
      experience+=enemy.getExperienceGain();
  }
  public void unlockSkill(Ability ability){
      if(ability.level==getLevel()){
      ability.unlockAbility();
      System.out.println("");
       System.out.println("");
         System.out.println("You have unlocked the ability :"+ability.getName()+" Nice work!");
         if(ability.getAbilityStatus())
         {
             System.out.println("ability is UNLOCKED UNLOCKED and set to true");
         }
      }
  }
  public int getKills(){
  return enemyKills;
  }
}

