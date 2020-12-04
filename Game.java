//PROGRAMMING PROJECT
package game;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Game {
    public static int size = 0;

         
    public static void main(String[] args) {
       
        
        Scanner sc = new Scanner(System.in);
        Ability Basic = new Ability("Basic Attack", 15,0,0,true,1);
        Ability Whirl = new Ability("Whirlwind Strike", 30,2,2,false,2);
        Ability Infernal = new Ability("Infernal Blaze", 50,3,3,false,3);
        Ability Slash = new Ability("Slash of hermes", 70,4,4,false,4);
        Ability Hell = new Ability("Hell's Damnation", 100,5,5,false,5);
        
        Enemy basicEnemy = new Enemy("Demon", 40, 10,10);
        Enemy basicEnemy2 = new Enemy("Assasin", 60, 15,20);
        Enemy basicEnemy3 = new Enemy("Ramiel", 80, 20,30);
        Enemy advancedEnemy = new Enemy("Asmodeus", 200, 40,60);
        Enemy advancedEnemy2 = new Enemy("Dagon",240, 40,60);
        Enemy advancedEnemy3 = new Enemy("Azazeal",280, 50,80);
        Enemy Lucifer = new Enemy("Lucifer", 200,60,90);
        Enemy Castelo = new Enemy("Castelo", 780, 75,100 );
        
        ArrayList<Enemy> enemyList = new ArrayList<>();
        enemyList.addAll(Arrays.asList(
                basicEnemy,
                basicEnemy2,
                basicEnemy3,
                Lucifer,
                advancedEnemy,
                advancedEnemy2,
                advancedEnemy3,
                Castelo
                
        ));
     
        size = enemyList.size();
      
        //for (int i = 0; i < enemyList.size(); i++) {
          //  System.out.println((i + 1) + ". character: " + enemyList.get(i).getName());
          
        //}
        
        introduction();
        System.out.println("\tEnter your name ");
        String myName = sc.nextLine();
        Character player = new Character(myName, 250, 15);
        plot1(player);
         for (int i = 0; i < enemyList.size(); i++) {
             
             if(!player.isDead()){
                if(i==3)
                plot2(player);
                if(i==7)
                 plot4(player);
                battle(enemyList.get(i), player, Basic, Whirl, Infernal,Slash,Hell);
                if(i==3&&!player.isDead())
                plot3(player);
                if(i==7&&!player.isDead()){               
                    System.out.println("_____________________________________________________________");
                    plot5(player);
                    System.out.println("Congratulations you have finished the game! But is it over?...");
                }                
              
                 
            }
         }

        
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
       
        System.out.println("\t===============================================================");
        System.out.println();
        System.out.println( "\t"+player.getName());
        System.out.println("\tYour HP: " + player.getHealth());
        System.out.println("\tLives: "+player.getLife());
        System.out.println("\tYour LV: " + player.getLevel());
        System.out.println("\tYour Potions:"+player.getPotion());
        System.out.println();
        System.out.println("\t#######"+enemy.getName()+" has appeared #######");
        System.out.println("\tHP: " + enemy.getHealth());
        System.out.println("\tAttack power: " +(enemy.getDamage()-10)+"-"+enemy.getDamage());
        System.out.println();
        
        //Start of the battle loop
        //The loop goes over and over again 
        //Until player or enemy is dead
        while (!enemy.isDead() && !player.isDead()) {
               
                
                
                
                //Using the boolean variable checkInput
                //to see whether user input is valid
                //If user input fails 
                //Loop over until valid input from 
                //1-6 only
                checkInput=false;
                while (checkInput==false)                                   {
                    
                System.out.println();
                System.out.println("\tWhat would you like to do?");
                System.out.println();
                
                 //Print out the ability list for user input prompt
                //Loops through the arraylist
                //The ability with unlocked = true will have 
                //Name and cooldown amount printed
                //else 
                //Ability locked 
                 for (int i = 0; i < abilityList.size(); i++) {
          
                System.out.print("\t"+(i+1)+".");
                if(i==0){
                   System.out.print (abilityList.get(i).getName());
                   System.out.println();
                }
                if(i>0&&abilityList.get(i).getAbilityStatus()){
                System.out.print (abilityList.get(i).getName());
                if(abilityList.get(i).getCooldownAmt()!=0){
                System.out.print(" cooldown: ");
                System.out.print(abilityList.get(i).getCooldownAmt());
                }
                System.out.println();
                
                }else if(i!=0){
                    System.out.print("Locked ability!");
                    System.out.println();
                 }
               
        }
                System.out.println("\t6.Use potion to heal 100 hp. You have "+ player.getPotion()+" potions in your bag");
                
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
                    break;
                        }
                    else{
                    System.out.println("\tThe ability is on cooldown, select another ability! ");
                        break;
                         }
                    }
                    else
                        System.out.println("\tThe ability is locked please select another ability");
                        
                   
                    
                case 3:
                    if(ab3.getAbilityStatus())         {
                    if(ab3.getCooldownAmt()==0){
                    player.setDamage( ab3.getAbilityDamage());
                    ab3.resetCounter(); 
                    checkInput=true;
                    break;
                        } else 
                        System.out.println("\tThe ability is on cooldown, select another ability! ");
                        break;
                    }
                        else
                        System.out.println("\tThe ability is locked please select another ability");
                      
                    break;
                case 4:
                     if(ab4.getAbilityStatus())        {
                     if(ab4.getCooldownAmt()==0){
                    player.setDamage( ab4.getAbilityDamage());
                    ab4.resetCounter(); 
                    checkInput=true;
                    break;
                             } else{
                             System.out.println("\tThe ability is on cooldown, select another ability! ");
                            break;
                        
                        }
                    }
                         else
                        System.out.println("\tThe ability is locked please select another ability");
                       
                   
                    break;
                case 5:
                    if(ab5.getAbilityStatus())          {
                    if(ab5.getCooldownAmt()==0){
                    player.setDamage( ab5.getAbilityDamage());
                    ab5.resetCounter(); 
                    checkInput=true;
                    break;
                        } 
                          else{
                            System.out.println("\tThe ability is on cooldown, select another ability! ");
                            break;
                     
                         }
                    }
                         else
                        System.out.println(" \tThe ability is locked please select another ability");
                       
                   
                     break;
                case 6:
                    if(player.getPotion()>0){
                    player.heal();
                    }
                    else{
                        System.out.println("\tYou have no more potions ");
                    }
                   
                default:
                    if(choice!=1&&choice!=2&&choice!=3&&choice!=4&&choice!=5&&choice!=6){
                    System.out.println("\tInput is not valid please enter from numbers 1-6 only");
                    } 
                    System.out.println();
                  
                  
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
                //need to WORK ON THIS
                if(!player.isDead()){
                enemy.attacked(player.getDamage(), enemy.getHealth());
                }
                if(!enemy.isDead())
                player.attacked(enemy.getDamage(), player.getHealth());
                
                System.out.println();
                if(!player.isDead())
                System.out.println("\t"+player.getName()+"'s health: "+player.getHealth());
                if(!enemy.isDead()&&!player.isDead())
                System.out.println("\t"+enemy.getName()+"'s health: "+enemy.getHealth());
                
                //characterList.get(whichCharacter).attack(characterList.get(whichCharacter).getDamage(), player.getHealth());
               //REMOVE THIS LATER
                if(enemy.isDead()){
                    player.addEnemy();
                    System.out.println("\tYou recieved a potion from the battle");
                    player.addPotion();
                    player.addExperienceGain(enemy);
                    System.out.print("\tYour experience is "+player.getExperience());
                    if(player.getLevel()==1){
                        System.out.print("/60");
                    }
                    if(player.getLevel()==2){
                        System.out.print("/150");
                    }                    
                    if(player.getLevel()==3){
                        System.out.print("/270");
                    }
                    if(player.getLevel()==4){
                        System.out.print("/350");
                    }
                    System.out.println();
                    //resets cooldown counter after battle
                    for(int i=0;i<abilityList.size();i++){
                    abilityList.get(i).resetCoolCounter();
                    }
                    //Check experience to level up and unlock ability
                    switch(player.getExperience()){
                        case 60:player.levelUp();
                                
                                player.unlockSkill(ab2);
                                break;
                        case 150:player.levelUp();
                               
                                 player.unlockSkill(ab3);
                                 break;
                        case 270:player.levelUp();
                               
                                 player.unlockSkill(ab4);
                                 break;
                        case 350:player.levelUp();
                               
                                player.unlockSkill(ab5);
                                break;
                        default: break;
                    }
          //LOOP THAT CHECKS ARRAYLIST OF ABILITIES AND EXECUTES THE FUNCTION CHECK LEVEL
                }
                if(player.isDead()){
                if(player.getLife()>0){
                System.out.println();
                System.out.println("\tYou lost a live. You have "+player.lossLife()+" live(s) remaining");
                player.resetHealth();
                
                System.out.println("\tYour health is back to full hp at "+player.getHealth()); 
                player.addPotion();
                player.addPotion();
                System.out.println("\t2 potions have been added. Remaining potions: "+player.getPotion());
                 for(int i=0;i<abilityList.size();i++){
                    abilityList.get(i).resetCoolCounter();
                    }
                player.resurrect();
               
                }
                else
                {
                    System.out.println("\t===============GAME OVER!========================= ");
                    break;
                }
               }
              
            }
        
    
    }
     //BATTLE METHOD
    
    
    public static int random() {
        int szam = (int) (Math.random() * size);
        return szam;
    }

public static void plots(String plot){
        System.out.println("\t"+plot);
        Scanner sc = new Scanner(System.in);
       
        sc.nextLine();
    }
public static void introduction(){
    plots("Welcome to Hell's Damnation where you will have to fight your way up to the top, press enter to continue");
    plots("You will have your first ability which is basic attack");
    plots("And as you progress and level up");
    plots("New abilities will be unlocked as well as potion gains");
    plots("This is a input based game with numbers mostly");
    plots("The inputs are from numbers 1-6");
    plots("1-5 is used for attack and abilities");
    plots("6 is used to heal 100 hp ");
    plots("The gift of god is used to ressurect the player from the dead to full hp and 2 potions");
    plots("You have 2 lives(gift of god), use them wisely");
    plots ("The game will begin now");
    plots("Good Luck !! :)");
    plots("================================================================");
    System.out.println();
    System.out.println();
    System.out.println();
   
}
    public static void plot1(Character player){
        plots("When you first arrived to this world, you were gifted as the natural ruler of the world.");
        plots("People from all over the world came to visit you and gift you various possessions of a true King.");
        plots("However, the current living king Castelo, was not too pleased to hear of your birth." + "\n\t" +"He demanded the beheading of the newborn true King." + "\n\t" + "With the power of the people and loving parents, you were kept safe for a few months.");
    	plots("Castelo was losing his mind, thinking his position would be taken over by a child, " + "\n\t" + "a child sent from god himself, entrusted for ruling over the world and guiding people to their righteous path.");
    	plots("Castelo spent months searching for the child. But no luck." + "\n\t" + "So he resorted to black magic and summoned a demon. Not just any demon. A fallen angel who goes by the name of Lucifer.");
    	plots("Lucifer was Castelo’s right hand man when things turned nasty." + "\n\t" + "Castelo had sold his soul to the devil to keep his position for a couple of more years of ruling. Half his life was given to Lucifer.");
    	plots("Lucifer searched for you everywhere. Sensed the king’s aura around a small village. He picked up a trail that led him to a small barn.");
    	plots("He brought down hell on earth, he found you and your family. Your parents pleaded to the devil for your life.");
    	plots("Lucifer offered them a deal, to protect you until your adulthood for the lives of both of them.");
    	plots("Your parents did not hesitate. He captured their souls and teleported them to hell.");
    	plots("Leaving you ashtray, clueless for what had happened. Tossed you to a river. A fisherman picked you up half-alive. Saved your life." + "\n\t" + "From then on you lived with him. Your father like figure that taught you discipline, resilience and kindness.");
    	plots("17 years later.");
    	plots("You dream about something, the vision of the village massacre. Enraged with anger. Furious about what Lucifer and castelo did to you." + "\n\t" + "You awake and the door of your small house was smashed open. There stood a demon that came for you.");
        plots("You make eye contact with the demon");
        plots("The demon spoke in latin");
        plots("Demon: Deprecor vos, sancti\n\t" +
                "\tangeli. Quomodo haec anima intus inclusa tenetur et angustiatur et non vede  neque lumine,\n\t" +
                "\t ne aqueliquem refrigerium non habet,sic anima, mentes, corpus Collecticii, quem peperit Agnella,\n\t" +
                "\t  teneatur, ardeat, destabescat. Usque ad infernum semper dicite Collecticium, quem peperet\n\t" +
                "\t Agnella. ");
        plots("You could not move a muscle");
        plots("Against your will you move towards the demon");
        plots("The demon opens a portal");
        plots("You follow into the purple vortex");
        plots("As pass through and step your next foot down");
        plots("You look up and see the fierypits and lava rivers");
        plots("Screamings of people in torment");
        plots("Realising that you have step foot in Hell");
        plots("The demon's spell wears off");
        plots("You think to yourself, 'I have to kill him' ");
    	plots("The fight has just begun.");
    }

    public static void plot2(Character player){
        plots("As you defeated Ramiel, someone approaches");
        plots("He gets closer");
        plots("A red faced individul with horns ");
        plots("None other than the king of hell..");
        plots("Lucifer Morningstar");
        plots("Lucifer: At Last! My goons couldn’t finish you off. When I’m here, might as well have the pleasure of cutting you head off.");
        plots(player.getName()+": Lucifer, you bastard! You will pay for what you did to my parents.");
        plots("Lucifer: Little boy, I am tired of torturing your parents in hell. Why don’t I take you there once I kill you?");
    	plots(player.getName()+": Try me you sick freak! Release my parents once I defeat you.");
    	plots("Lucifer: Ruler of the world? PFFT! You are nothing more than a grain of rice. Draw you sword young one. Let’s see if you are all talk.");
    	plots(player.getName()+" Bring it on!");
    	   
    }

    public static void plot3(Character player){
        plots("Lucifer: Now…ARRGHH…I… See… Why… Castelo… wanted to…. Kill you so bad…");
    	plots("You: Bring back my parents, like you promised.");
    	plots("Lucifer: You fool! *cough* *cough* I… made no such promise… to you… Ha… Ha… You should ask Castelo… Where he kept them…*Spits blood*");
    	plots("Lucifer collapses and transcends into a black hole");
        plots("Furious than ever, you shouted in anger on the top of your lungs");
        plots("Stabbing the sword to the ground");
        plots("Waiting on the next demon to come");
        plots("The ruler of Hell was defeated");
        plots("The underworld kingdom started to question Lucifer's positon");
        plots("The princes of Hell got the news");
        plots("Asmodeus, Dagon and Azazeal ");
        plots("The next in line for the king's throne");
        plots("Was coming for you");
    	
    }
    public static void plot4(Character player){
    	plots("Castelo: Ahh there you are… You’ve been reeking havoc everywhere you go haven’t you. Should have known you crossed a line when you slayed my right hand man");
    	plots("Castelo: Did you really think he took them to hell? Well he told you only half the truth.");
    	plots("Castelo: Your parents did go to hell… to a hell I created just for them. It has been 17 years since they were prisoned in that very place.");
    	plots("Castelo: They are inside my pandora’s box. Tormented by their worst memories over and over again. HAHAHA such poor souls that gave their life for an imbecilic like you.");
    	plots(player.getName()+": You waste space, you will pay!");

    }
    
    public static void plot5(Character player){
        plots("Castelo: H-h-how… could… this… be…" + "\n\t" + "Such power… given to… someone not worthy…" + "\n\t" + "should have… listened to the stars… they were right….");
        plots(player.getName()+": Quit yapping and give me that damn box you pathetic sack of shit.");
        plots("Castelo spits out blood");
        plots("Castelo: You fool… the box…. Holds… your parents….*cough* *cough* " + "\n\t" + "... but once you let them out… Earth will… be doomed.");
        plots(player.getName()+": What nonsense are you spilling? What evil? The only thing I care about is my parents that brought me to life." + "\n\t" + "My whole life I’ve been living a lie, my parents fighting everyday like it is their last. Do you really think I care about what little evil can do to this world?");
        plots("Castelo: Ha-ha-ha … I was… once like you… Young and naïve…" + "\n\t" + "I did not… know of the consequences… that was brought…. with every great decision… You know what… just kill me already… I want to see the world fucked up…HA HAHA");
        plots(player.getName()+": Maniac");
        plots("Without hesitation you slit Castelo’s head clean off and take the box out of his pocket.");
        plots("You wonder to yourself ...");
        plots("Is this the end?");
        plots("Vengence at last but what will the box do to this world?");
    }
}
