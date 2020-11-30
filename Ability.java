//PROGRAMMING PROJECT
package game;

public class Ability {
    private String name;
    private int abilityDamage;
    //ADDED
    private int cooldown;
    private int cooldownCounter;
    //ADDED
    public Ability(String name, int abilityDamage, int cooldown, int cooldownCounter) {
        this.name = name;
        this.abilityDamage = abilityDamage;
        this.cooldown=cooldown;
        this.cooldownCounter=cooldownCounter;
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
    //ADDED
    
    public void setAbilityDamage(int weaponDamage) {
        this.abilityDamage = weaponDamage;
    }
}