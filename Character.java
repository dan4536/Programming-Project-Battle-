//PROGRAMMING PROJECT

package game;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
    public class Character {
    private String name;
    private int level=1;                      
    private int experience;                 
    private int health;
    private int maxHealth;
    private int lives=2;
    private int damage;                     
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
    
    //Attacked method
    //See player's health is greater than damage
    //If health greater
    //Damage player
    //Else player is dead
    public void attacked(int abilityDamage, int myHealth) {
        if ( abilityDamage>= this.health || myHealth<=0) {
           // this.health = 0;
            System.out.println("\t" +this.name + " is dead!");
            this.dead = true;
        } else {
            abilityDamage-=10;
            Random rn=new Random();
            abilityDamage+=rn.nextInt(10)+1;
            this.health -= abilityDamage;
            System.out.println();
           System.out.println(" \t>Enemy damage: "+abilityDamage);
            
        }
     }
    
    //Heal 100 hp to player
    public void heal(){
    System.out.print("\t>Your healed from "+getHealth()+" to ");
    
    if(health+100>maxHealth)
    health=maxHealth;
    else
    setHealth(getHealth()+100);
    
    System.out.print(getHealth());
    potion-=1;
    }
   
    //Level up player
    //Increase max HP
    public void levelUp(){
        
     level+=1; 
     System.out.println(); 
     System.out.println("\t<<<<LEVEL UP>>>> ");
     System.out.println(); 
     System.out.println("\t"+getName()+" is now Level "+getLevel());
     System.out.println("\tMax health increased from "+maxHealth+" to "+(maxHealth+30));
     maxHealth+=100;
     
        if(health+100>maxHealth)
        health=maxHealth;
        else
        setHealth(getHealth()+100);
        
        System.out.println();
        System.out.println("\t_______________________________________________________________");
     }
    
    //Unlock skill 
    //Display to user unlocked ability
      public void unlockSkill(Ability ability){
      if(ability.level==getLevel()){
          
         ability.unlockAbility();
         
         System.out.println("\tYou have unlocked a new ability");
         System.out.println("");
         System.out.println(" \tYou have unlocked  < "+ability.getName()+" >");
         System.out.println(" \t"+ability.getName()+": "+(ability.getAbilityDamage()-10)+"-"+ability.getAbilityDamage()+" damage");
         System.out.println("\t_______________________________________________________________");
         System.out.println();
        }
    }
      
      
     public void addExperienceGain(Enemy enemy){
      experience+=enemy.getExperienceGain();
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
    
    public int getMaxHealth(){
        return maxHealth;
    }
    
    public int getHealth() {
        return health;
    }
    
    public int getLevel() {
        return level;
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
     
     //Reset player's dead to false
     public void resurrect(){
     dead=false;
     System.out.println("\t>You ressurect from using the gift of god");
  }
  

  
}

