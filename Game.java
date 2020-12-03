//PROGRAMMING PROJECT
package game;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Game {
    public static int size = 0;

         
    public static void main(String[] args) {
       
        int myDamage = 10;
        
        Scanner sc = new Scanner(System.in);
        Ability Basic = new Ability("Basic Attack", 10,0,0,true,1);
        Ability Whirl = new Ability("Whirlwind Strike", 20,2,2,false,2);
        Ability Infernal = new Ability("Infernal Blaze", 50,3,3,false,3);
        Ability Slash = new Ability("Slash of hermes", 80,4,4,false,4);
        Ability Hell = new Ability("Hell's Damnation", 100,5,5,false,5);
        
        Enemy basicEnemy = new Enemy("Basic Enemy", 10, 10,20);
         Enemy basicEnemy2 = new Enemy("Basic Enemy", 10, 10,20);
          Enemy basicEnemy3 = new Enemy("Basic Enemy", 10, 10,20);
        Enemy advancedEnemy = new Enemy("Advanced enemy", 200, 20,100);
         Enemy basicEnemy4 = new Enemy("Basic Enemy", 10, 10,20);
        Enemy Lucifer = new Enemy("Lucifer", 400,35,90);
        Enemy Castelo = new Enemy("Castelo", 600, 50,110 );
        
        ArrayList<Enemy> enemyList = new ArrayList<>();
        enemyList.addAll(Arrays.asList(
                basicEnemy,
                advancedEnemy,
                Lucifer,
                Castelo
                
        ));
        
   
     
        size = enemyList.size();
      
        for (int i = 0; i < enemyList.size(); i++) {
            System.out.println((i + 1) + ". character: " + enemyList.get(i).getName());
          
        }
   
        
        
        System.out.println("Enter your name ");
        String myName = sc.nextLine();
        Character player = new Character(myName, 1000, myDamage);
        
        
        battle(basicEnemy, player, Basic, Whirl, Infernal,Slash,Hell);
        battle(basicEnemy2, player, Basic, Whirl, Infernal,Slash,Hell);
        battle(basicEnemy3, player, Basic, Whirl, Infernal,Slash,Hell);
        battle(advancedEnemy, player, Basic, Whirl, Infernal,Slash,Hell) ;
        battle(basicEnemy4, player, Basic, Whirl, Infernal,Slash,Hell);
        plot2(player);
        
       
        System.out.println("THE NEXT ENEMY COMES");
        System.out.println("THE NEXT ENEMY COMES");
        System.out.println("THE NEXT ENEMY COMES");
       
        
        
        

        }
    
    
    
    
    //BATTLE METHOD!!! 
    public static void battle(Enemy enemy,Character player,Ability ab1,Ability ab2,Ability ab3,Ability ab4,Ability ab5 ){
        boolean checkInput=false;
        
        Scanner sc=new Scanner(System.in);
        
        ArrayList<Ability> abilityList = new ArrayList<>();
        abilityList.addAll(Arrays.asList(
                ab1,
                ab2,
                ab3,
                ab4,
                ab5
        ));
        System.out.println( player.getName());
        System.out.println("Your HP: " + player.getHealth());
        System.out.println("Your attack power: " + player.getDamage());
        System.out.println();
        System.out.println();
        System.out.println("You were attacked by a: "+enemy.getName());
        System.out.println("HP: " + enemy.getHealth());
        System.out.println("Attack power: " + enemy.getDamage());
        System.out.println();
        while (!enemy.isDead() && !player.isDead()) {
               //need another loop to make sure the ability is not on cooldown
                 
                
                System.out.println("You attack with...");
                System.out.println();
                 for (int i = 0; i < abilityList.size(); i++) {
          
            System.out.print(i+1+".");
                if(i==0){
                   System.out.print (abilityList.get(i).getName());
                   System.out.println();
                }
                if(i>0&&abilityList.get(i).getAbilityStatus()){
                System.out.print (abilityList.get(i).getName());
                System.out.print(" cooldown: ");
                System.out.print(abilityList.get(i).getCooldownAmt());
                System.out.println();
                
                }else if(i!=0)
                 {System.out.println("Locked ability!");}
                //System.out.println("2. Whirlwind strike cooldown: "+(Whirl.getCooldown()-Whirl.getCooldownCounter()));
               // System.out.println("3. Infernal Blaze  cooldown: "+(Infernal.getCooldown()-Infernal.getCooldownCounter()));
               // System.out.println("4. Slash of hermes cooldown: "+(Slash.getCooldown()-Slash.getCooldownCounter()));
              //  System.out.println("5. Hell's damnation cooldown: "+(Hell.getCooldown()-Hell.getCooldownCounter()));
                
        }
                System.out.println("6. Use potion to heal 100 hp. You have "+ player.getPotion()+" potions in your bag");
                checkInput=false;
                
                
                while (checkInput==false){
                int choice = sc.nextInt();
                switch (choice) {
                case 1:
                    player.setDamage(10);
                    checkInput=true;
                    break;
                case 2:
                    if(ab2.getAbilityStatus())            {
                    if(ab2.getCooldownAmt()==0){
                    player.setDamage( ab2.getAbilityDamage());
                    ab2.resetCounter(); 
                    checkInput=true;
                        }else{
                    System.out.println("The ability is on cooldown, select another ability! ");
                         }
                    }
                    else
                        System.out.println("The ability is locked please select another ability");
                    
                    break;
                case 3:
                    if(ab3.getAbilityStatus())         {
                    if(ab3.getCooldownAmt()==0){
                    player.setDamage( ab3.getAbilityDamage());
                    ab3.resetCounter(); 
                    checkInput=true;
                        } else 
                        System.out.println("The ability is on cooldown, select another ability! ");
                    }
                        else
                        System.out.println("The ability is locked please select another ability");
                    break;
                case 4:
                     if(ab4.getAbilityStatus())        {
                     if(ab4.getCooldownAmt()==0){
                    player.setDamage( ab4.getAbilityDamage());
                    ab4.resetCounter(); 
                    checkInput=true;
                             } else{
                             System.out.println("The ability is on cooldown, select another ability! ");
                        }
                    }
                         else
                        System.out.println("The ability is locked please select another ability");
                    break;
                case 5:
                    if(ab5.getAbilityStatus())          {
                    if(ab5.getCooldownAmt()==0){
                    player.setDamage( ab5.getAbilityDamage());
                    ab5.resetCounter(); 
                    checkInput=true;
                        } 
                          else{
                            System.out.println("The ability is on cooldown, select another ability! ");
                         }
                    }
                         else
                        System.out.println("The ability is locked please select another ability");
                     break;
                case 6:
                    if(player.getPotion()>0){
                    
                    
                    player.heal();
                    System.out.println();
                    System.out.println("You attack with...");
                    System.out.println();
            for (int i = 0; i < abilityList.size(); i++) {
          
            System.out.print(i+1+".");
                if(i==0){
                   System.out.print (abilityList.get(i).getName());
                   System.out.println();
                }
                if(i>0&&abilityList.get(i).getAbilityStatus()&&player.getLevel()==i+1){
                System.out.print (abilityList.get(i).getName());
                System.out.print(" cooldown: ");
                System.out.print(abilityList.get(i).getCooldownAmt());
                System.out.println();
                
                }else if(i!=0)
                 {System.out.println("Locked ability!");}
             
                
        }
                    }
                    else{
                        System.out.println("You have no more potions ...");
                    }
                    
                default:
                    player.setDamage(10);;
                }
                
                }
                //ALL THE COUNTERS THAT DOES NOT MATCH ADD ONE TO THEM
                if(ab2.getCooldownAmt()>0){
                    ab2.addCoolCounter();
                }
                
                 if(ab3.getCooldownAmt()>0){
                    ab3.addCoolCounter();
                } 
                 if(ab4.getCooldownAmt()>0){
                    ab4.addCoolCounter();
                } 
                 if(ab5.getCooldownAmt()>0){
                    ab5.addCoolCounter();
                }
                
               
                 
                
                enemy.attacked(player.getDamage(), enemy.getHealth());
                player.attacked(enemy.getDamage(), player.getHealth());
            
                //characterList.get(whichCharacter).attack(characterList.get(whichCharacter).getDamage(), player.getHealth());
               //REMOVE THIS LATER
                if(enemy.isDead()){
                    player.addEnemy();
                    System.out.println("You recieved a potion from the battle");
                    player.addPotion();
                    player.addExperienceGain(enemy);
                    System.out.println("Your experience is "+player.getExperience());
                    switch(player.getExperience()){
                        case 60:player.levelUp();
                                System.out.println("YOU have unlocked a new ability!!");
                                player.unlockSkill(ab2);
                                break;
                        case 160:player.levelUp();
                                System.out.println("YOU have unlocked a new ability!!");
                                 player.unlockSkill(ab3);
                                 break;
                        case 280:player.levelUp();
                                System.out.println("YOU have unlocked a new ability!!");
                                 player.unlockSkill(ab4);
                                 break;
                        case 430:player.levelUp();
                                System.out.println("YOU have unlocked a new ability!!");
                                player.unlockSkill(ab5);
                                break;
                        default: break;
                    }
          //LOOP THAT CHECKS ARRAYLIST OF ABILITIES AND EXECUTES THE FUNCTION CHECK LEVEL
                }
                if(player.isDead()){
                if(player.getLife()>0){
                System.out.println("You lost a live. You have "+player.lossLife()+" live(s) remaining");
                player.resetHealth();
                System.out.print("Your health is back to full hp at "+player.getHealth()); 
                player.addPotion();
                player.addPotion();
                System.out.print("2 potions have been added. Remaining potions: "+player.getPotion());

               
                player.resurrect();
               
                }
                else
                {
                    System.out.println("GAME OVER! ");
                }
               }
                //REMOVE THIS LATER
            }
        
    
    }
     //BATTLE METHOD
    
    
    public static int random() {
        int szam = (int) (Math.random() * size);
        return szam;
    }

public static void plots(String plot){
        System.out.println(plot);
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
    public static void plot1(Character player){
        plots("When you first arrived to this world, you were gifted as the natural ruler of the world.");
        plots("People from all over the world came to visit you and gift you various possessions of a true King.");
        plots("However, the current living king Castelo, was not too pleased to hear of your birth." + "\n" +"He demanded the beheading of the newborn true King." + "\n" + "With the power of the people and loving parents, you were kept safe for a few months.");
    	plots("Castelo was losing his mind, thinking his position would be taken over by a child, " + "\n" + "a child sent from god himself, entrusted for ruling over the world and guiding people to their righteous path.");
    	plots("Castelo spent months searching for the child. But no luck." + "\n" + "So he resorted to black magic and summoned a demon. Not just any demon. A fallen angel who goes by the name of Lucifer.");
    	plots("Lucifer was Castelo’s right hand man when things turned nasty." + "\n" + "Castelo had sold his soul to the devil to keep his position for a couple of more years of ruling. Half his life was given to Lucifer.");
    	plots("Lucifer searched for you everywhere. Sensed the king’s aura around a small village. He picked up a trail that led him to a small barn.");
    	plots("He brought down hell on earth, he found you and your family. Your parents pleaded to the devil for your life.");
    	plots("Lucifer offered them a deal, to protect you until your adulthood for the lives of both of them.");
    	plots("Your parents did not hesitate. He captured their souls and teleported them to hell.");
    	plots("Leaving you ashtray, clueless for what had happened. Tossed you to a river. A fisherman picked you up half-alive. Saved your life." + "\n" + "From then on you lived with him. Your father like figure that taught you discipline, resilience and kindness.");
    	plots("17 years later.");
    	plots("You dream about something, the vision of the village massacre. Enraged with anger. Furious about what Lucifer and castelo did to you." + "\n" + "You awake and the door of your house was smashed open. There stood a demon that came for you.");
    	plots("The fight has just begun.");
    }

    public static void plot2(Character player){
        plots("Lucifer: At Last! My goons couldn’t finish you off. When I’m here, might as well have the pleasure of cutting you head off.");
        plots(player.getName()+": Lucifer, you bastard! You will pay for what you did to my parents.");
        plots("Lucifer: Little boy, I am tired of torturing your parents in hell. Why don’t I take you there once I kill you?");
    	plots(player.getName()+" Try me you sick freak! Release my parents once I defeat you.");
    	plots("Lucifer: Ruler of the world? PFFT! You are nothing more than a grain of rice. Draw you sword young one. Let’s see if you are all talk.");
    	plots(player.getName()+" Bring it on!");
    	plots("");    
    }

    public static void plot3(Character player){
        plots("Lucifer: Now…ARRGHH…I… See… Why… Castelo… wanted to…. Kill you so bad…");
    	plots("You: Bring back my parents, like you promised.");
    	plots("Lucifer: You fool! *cough* *cough* I… made no such promise… to you… Ha… Ha… You should ask Castelo… Where he kept them…*Spits blood*");
    	plots("Lucifer collapses and transcends into a black hole");
        plots("Furious than ever, you shouted in anger on the top of your lungs");
        plots("Stabbing the sword to the ground");
        plots("Waiting on the next demon to come");
    	plots("");
    }
    public static void plot4(Character player){
    	plots("Castelo: Ahh there you are… You’ve been reeking havoc everywhere you go haven’t you. Should have known you crossed a line when you slayed my right hand man");
    	plots("Castelo: Did you really think he took them to hell? Well he told you only half the truth.");
    	plots("Castelo: Your parents did go to hell… to a hell I created just for them. It has been 17 years since they were prisoned in that very place.");
    	plots("Castelo: They are inside my pandora’s box. Tormented by their worst memories over and over again. HAHAHA such poor souls that gave their life for an imbecilic like you.");
    	plots(player.getName()+" You waste space, you will pay!");
        plots("");
    }
    
    public static void plot5(Character player){
        plots("Castelo: H-h-how… could… this… be…" + "\n" + "Such power… given to… someone not worthy…" + "\n" + "should have… listened to the stars… they were right….");
        plots(player.getName()+" Quit yapping and give me that damn box you pathetic sack of shit.");
        plots("Castelo spits out blood");
        plots("Castelo: You fool… the box…. Holds… your parents….*cough* *cough* " + "\n" + "... but once you let them out… Earth will… be doomed.");
        plots(player.getName()+" What nonsense are you spilling? What evil? The only thing I care about is my parents that brought me to life." + "\n" + "My whole life I’ve been living a lie, my parents fighting everyday like it is their last. Do you really think I care about what little evil can do to this world?");
        plots("Castelo: Ha-ha-ha … I was… once like you… Young and naïve…" + "\n" + "I did not… know of the consequences… that was brought…. with every great decision… You know what… just kill me already… I want to see the world fucked up…HA HAHA");
        plots(player.getName()+" Maniac");
        plots("Without hesitation you slit Castelo’s head clean off and take the box out of his pocket.");
        plots("You wonder to yourself ...");
        plots("Is this the end?");
        plots("vengence at last but what will the box do to this world?");
    }
}
