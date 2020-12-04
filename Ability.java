//PROGRAMMING PROJECT
package game;

public class Ability {
    private String name;
    private int abilityDamage;
    private int cooldown;
    private int cooldownCounter;
    public int level;
    boolean unlocked;
  
    public Ability(String name, int abilityDamage, int cooldown, int cooldownCounter, boolean unlocked, int level) {
        this.name = name;
        this.abilityDamage = abilityDamage;
        this.cooldown=cooldown;
        this.cooldownCounter=cooldownCounter;
        this.unlocked=unlocked;
        this.level=level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAbilityDamage() {
        return abilityDamage;
    }
    
    //ADDED
    public int getCooldown(){
        return cooldown;
    }
    
    public int getCooldownCounter(){
        return cooldownCounter;
    }
    public void addCoolCounter(){
        cooldownCounter+=1;
    }
    public void resetCounter(){
    cooldownCounter=0;
    }
   
    
    public void setAbilityDamage(int weaponDamage) {
        this.abilityDamage = weaponDamage;
    }
    
     public void displayAbility(){
     System.out.println(" "+name);
    }
     
     public boolean getAbilityStatus(){
     return unlocked;
    }
     
     public void unlockAbility(){
     this.unlocked=true;
    }
     
     public int getCooldownAmt(){
         return cooldown-cooldownCounter;
    }
     
     public void resetCoolCounter(){
     cooldownCounter=cooldown;
    }
}