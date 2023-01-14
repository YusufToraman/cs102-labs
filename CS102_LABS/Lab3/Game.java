package Lab3;
import java.util.Scanner;
public class Game {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a Race \n1)Human\n2)Elf\n3)Dwarfs\n4)Halflings");
        int choice = sc.nextInt();
        int auto = sc.nextInt();
        Character user = new Character(1);
        if(choice == 1){
            boolean isAuto = false;
            boolean hasDied;
            String typeUser = "";
            user = new Humans(user.lv);
            System.out.println("Choose a class \n1)Fighter\n2)Rogue\n3)Mage");
            choice = sc.nextInt();
            System.out.println("Dou you want to play automatically (Y = 1 or N = 0)");
            auto = sc.nextInt();
            int tmp = choice;
            Character bot = createBot(user.lv);
            String typeBot = botClass();
            while(user.currentHp > 0){
                hasDied = false;
                System.out.println("Your stats");   user.printStats();
                System.out.println("Bot's stats");  bot.printStats();
                if(tmp == 1){
                    typeUser = "fighter";
                    System.out.println("Your turn\n1)Attack\n2)Defend\n3)Struggle\n4)Slash\n5)Burst"); 
                }
                else if(tmp == 2){
                    typeUser = "rogue";
                    System.out.println("Your turn\n1)Attack\n2)Defend\n3)Struggle\n4)Shoot Arrow\n5)Quick Attack"); 
                }
                else if(tmp == 3){
                    typeUser = "mage";
                    System.out.println("Your turn\n1)Attack\n2)Defend\n3)Struggle\n4)Fire\n5)Blizzard\n6)Thunder"); 
                }
                if(auto == 1){
                    isAuto = true;
                }
                if(user.speed >= bot.speed){
                    userTurn(user, bot, choice, typeUser, typeBot, isAuto);
                    if(bot.currentHp <= 0){
                        System.out.println("\nYou have killed the bot " + bot);
                        bot = createBot(user.lv);
                        typeBot = botClass();
                        user.newStats();
                        hasDied = true;
                        System.out.println("Do you want to change your character (0 for YES -1 For NO)");
                        choice = sc.nextInt();
                        if(choice == 0){
                            if(typeUser.equals("fighter")){
                                System.out.println("2)Rogue\n3)Mage");
                                tmp = sc.nextInt();
                            }
                            if(typeUser.equals("rogue")){
                                System.out.println("1)Fighter\n3)Mage");
                                tmp = sc.nextInt();
                            }
                            if(typeUser.equals("mage")){
                                System.out.println("1)Fighter\n2)Rogue");
                                tmp = sc.nextInt();
                            }
                        }
                    }
                    if(!hasDied){
                        System.out.println("Bot's turn"); 
                        if(typeBot.equalsIgnoreCase("fighter")){
                            botFighter(user, bot, typeUser);
                        }
                        if(typeBot.equalsIgnoreCase("rogue")){
                            botRogue(user, bot, typeUser);
                        }
                        if(typeBot.equalsIgnoreCase("mage")){
                            botMage(user, bot, typeUser);
                        }
                    }
                }
                else{
                    if(!hasDied){
                        System.out.println("Bot's turn"); 
                        if(typeBot.equalsIgnoreCase("fighter")){
                            botFighter(user, bot, typeUser);
                        }
                        if(typeBot.equalsIgnoreCase("rogue")){
                            botRogue(user, bot, typeUser);
                        }
                        if(typeBot.equalsIgnoreCase("mage")){
                            botMage(user, bot, typeUser);
                        }
                    }
                    userTurn(user, bot, choice, typeUser, typeBot, isAuto);
                    if(bot.currentHp <= 0){
                        System.out.println("\nYou have killed the bot " + bot);
                        bot = createBot(user.lv);
                        typeBot = botClass();
                        user.newStats();
                        hasDied = true;
                        System.out.println("Do you want to change your character (0 for YES -1 For NO)");
                        choice = sc.nextInt();
                        if(choice == 0){
                            if(typeUser.equals("fighter")){
                                System.out.println("2)Rogue\n3)Mage");
                                tmp = sc.nextInt();
                            }
                            if(typeUser.equals("rogue")){
                                System.out.println("1)Fighter\n3)Mage");
                                tmp = sc.nextInt();
                            }
                            if(typeUser.equals("mage")){
                                System.out.println("1)Fighter\n2)Rogue");
                                tmp = sc.nextInt();
                            }
                        }
                    }
                }
                choice = 0;
            }
            user.killCounter();
            //*************************************************** */
        }
        if(choice == 2){
            boolean isAuto = false;
            boolean hasDied;
            String typeUser = "";
            user = new Elves(user.lv);
            System.out.println("Choose a class \n1)Rogue\n2)Mage");
            choice = sc.nextInt();
            System.out.println("Dou you want to play automatically (Y = 1 or N = 0)");
            auto = sc.nextInt();
            int tmp = choice;
            Character bot = createBot(user.lv);
            String typeBot = botClass();
            while(user.currentHp > 0){ 
                hasDied = false;
                System.out.println("\nYour stats");   user.printStats();
                System.out.println("\nBot's stats");  bot.printStats();
                if(tmp == 1) {
                    typeUser = "rogue";
                    System.out.println("\nYour turn\n1)Attack\n2)Defend\n3)Mana Restore\n4)Shoot Arrow\n5)Quick Attack"); 
                }
                else if(tmp == 2){
                    typeUser = "mage";
                    System.out.println("Your turn\n1)Attack\n2)Defend\n3)Mana Restore\n4)Fire\n5)Blizzard\n6)Thunder"); 
                }
                if(auto == 1){
                    isAuto = true;
                }
                if(user.speed >= bot.speed){
                    userTurn(user, bot, choice, typeUser, typeBot, isAuto);
                    if(bot.currentHp <= 0){
                        System.out.println("\nYou have killed the bot " + bot);
                        bot = createBot(user.lv);
                        typeBot = botClass();
                        user.newStats();
                        hasDied = true;
                        System.out.println("Do you want to change your character (0 for YES -1 For NO)");
                        choice = sc.nextInt();
                        if(choice == 0){
                            if(typeUser.equals("rogue")){
                                System.out.println("3)Mage");
                                tmp = sc.nextInt();
                            }
                            if(typeUser.equals("mage")){
                                System.out.println("2)Rogue");
                                tmp = sc.nextInt();
                            }
                        }
                    }
                    if(!hasDied){
                        System.out.println("Bot's turn"); 
                        if(typeBot.equalsIgnoreCase("fighter")){
                            botFighter(user, bot, typeUser);
                        }
                        if(typeBot.equalsIgnoreCase("rogue")){
                            botRogue(user, bot, typeUser);
                        }
                        if(typeBot.equalsIgnoreCase("mage")){
                            botMage(user, bot, typeUser);
                        }
                    }
                }
                else{
                    if(!hasDied){
                        System.out.println("Bot's turn"); 
                        if(typeBot.equalsIgnoreCase("fighter")){
                            botFighter(user, bot, typeUser);
                        }
                        if(typeBot.equalsIgnoreCase("rogue")){
                            botRogue(user, bot, typeUser);
                        }
                        if(typeBot.equalsIgnoreCase("mage")){
                            botMage(user, bot, typeUser);
                        }
                    }
                    userTurn(user, bot, choice, typeUser, typeBot, isAuto);
                    if(bot.currentHp <= 0){
                        System.out.println("\nYou have killed the bot " + bot);
                        bot = createBot(user.lv);
                        typeBot = botClass();
                        user.newStats();
                        hasDied = true;
                        System.out.println("Do you want to change your character (0 for YES -1 For NO)");
                        choice = sc.nextInt();
                        if(choice == 0){
                            if(typeUser.equals("rogue")){
                                System.out.println("3)Mage");
                                tmp = sc.nextInt();
                            }
                            if(typeUser.equals("mage")){
                                System.out.println("2)Rogue");
                                tmp = sc.nextInt();
                            }
                        }
                    }
                }
                choice = 0;
            }
            user.killCounter();
        }
        if(choice == 3){
            boolean isAuto = false;
            boolean hasDied;
            String typeUser = "";
            user = new Dwarfs(user.lv);
            System.out.println("Choose a class \n1)Fighter\n2)Mage");
            choice = sc.nextInt();
            System.out.println("Dou you want to play automatically (Y = 1 or N = 0)");
            auto = sc.nextInt();
            int tmp = choice;
            Character bot = createBot(user.lv);
            String typeBot = botClass();
            while(user.currentHp > 0){
                hasDied = false;
                System.out.println("Your stats");   user.printStats();
                System.out.println("\nBot's stats");  bot.printStats();
                if(tmp == 1) {
                    typeUser = "fighter";
                    System.out.println("Your turn\n1)Attack\n2)Defend\n3)Rest\n4)Slash\n5)Burst"); 
                }
                else if(tmp == 2){
                    typeUser = "mage";
                    System.out.println("Your turn\n1)Attack\n2)Defend\n3)Rest\n4)Fire\n5)Blizzard\n6)Thunder"); 
                }
                if(auto == 1){
                    isAuto = true;
                }
                if(user.speed >= bot.speed){
                    userTurn(user, bot, choice, typeUser, typeBot, isAuto);
                    if(bot.currentHp <= 0){
                        System.out.println("\nYou have killed the bot " + bot);
                        bot = createBot(user.lv);
                        typeBot = botClass();
                        user.newStats();
                        hasDied = true;
                        System.out.println("Do you want to change your character (0 for YES -1 For NO)");
                        choice = sc.nextInt();
                        if(choice == 0){
                            if(typeUser.equals("fighter")){
                                System.out.println("3)Mage");
                                tmp = sc.nextInt();
                            }
                            if(typeUser.equals("mage")){
                                System.out.println("1)fighter");
                                tmp = sc.nextInt();
                            }
                        }
                    }
                    if(!hasDied){
                        System.out.println("Bot's turn"); 
                        if(typeBot.equalsIgnoreCase("fighter")){
                            botFighter(user, bot, typeUser);
                        }
                        if(typeBot.equalsIgnoreCase("rogue")){
                            botRogue(user, bot, typeUser);
                        }
                        if(typeBot.equalsIgnoreCase("mage")){
                            botMage(user, bot, typeUser);
                        }
                    }
                }
                else{
                    if(!hasDied){
                        System.out.println("Bot's turn"); 
                        if(typeBot.equalsIgnoreCase("fighter")){
                            botFighter(user, bot, typeUser);
                        }
                        if(typeBot.equalsIgnoreCase("rogue")){
                            botRogue(user, bot, typeUser);
                        }
                        if(typeBot.equalsIgnoreCase("mage")){
                            botMage(user, bot, typeUser);
                        }
                    }
                    userTurn(user, bot, choice, typeUser, typeBot, isAuto);
                    if(bot.currentHp <= 0){
                        System.out.println("\nYou have killed the bot " + bot);
                        bot = createBot(user.lv);
                        typeBot = botClass();
                        user.newStats();
                        hasDied = true;
                        System.out.println("Do you want to change your character (0 for YES -1 For NO)");
                        choice = sc.nextInt();
                        if(choice == 0){
                            if(typeUser.equals("fighter")){
                                System.out.println("3)Mage");
                                tmp = sc.nextInt();
                            }
                            if(typeUser.equals("mage")){
                                System.out.println("1)fighter");
                                tmp = sc.nextInt();
                            }
                        }
                    }
                }
                choice = 0;
            }
            user.killCounter();
        }
        if(choice == 4){
            boolean isAuto = false;
            boolean hasDied;
            String typeUser = "";
            user = new Halflings(user.lv);
            System.out.println("Choose a class \n1)Fighter\n2)Rogue");
            choice = sc.nextInt();
            int tmp = choice;
            Character bot = createBot(user.lv);
            String typeBot = botClass();
            while(user.currentHp > 0){  
                hasDied = false;
                System.out.println("Your stats");   user.printStats();
                System.out.println("\nBot's stats");  bot.printStats();
                if(tmp == 1) {
                    typeUser = "fighter";
                    System.out.println("Your turn\n1)Attack\n2)Defend\n3)Mimic\n4)Second Breakfast\n5)Burst\n6)Slash"); 
                }
                else if(tmp == 2){
                    typeUser = "rogue";
                    System.out.println("Your turn\n1)Attack\n2)Defend\n3)Mimic\n4)Second Breakfast\n5)Shoot Arrow\n6)Quick Attack"); 
                } 
                if(auto == 1){
                    isAuto = true;
                }
                if(user.speed >= bot.speed){
                    userTurn(user, bot, choice, typeUser, typeBot, isAuto);
                    if(bot.currentHp <= 0){
                        System.out.println("\nYou have killed the bot " + bot);
                        bot = createBot(user.lv);
                        typeBot = botClass();
                        user.newStats();
                        hasDied = true;
                        System.out.println("Do you want to change your character (0 for YES -1 For NO)");
                        choice = sc.nextInt();
                        if(choice == 0){
                            if(typeUser.equals("fighter")){
                                System.out.println("2)Rogue");
                                tmp = sc.nextInt();
                            }
                            if(typeUser.equals("rogue")){
                                System.out.println("1)Fighter");
                                tmp = sc.nextInt();
                            }
                        }
                    }
                    if(!hasDied){
                        System.out.println("Bot's turn"); 
                        if(typeBot.equalsIgnoreCase("fighter")){
                            botFighter(user, bot, typeUser);
                        }
                        if(typeBot.equalsIgnoreCase("rogue")){
                            botRogue(user, bot, typeUser);
                        }
                        if(typeBot.equalsIgnoreCase("mage")){
                            botMage(user, bot, typeUser);
                        }
                    }
                }
                else{
                    if(!hasDied){
                        System.out.println("Bot's turn"); 
                        if(typeBot.equalsIgnoreCase("fighter")){
                            botFighter(user, bot, typeUser);
                        }
                        if(typeBot.equalsIgnoreCase("rogue")){
                            botRogue(user, bot, typeUser);
                        }
                        if(typeBot.equalsIgnoreCase("mage")){
                            botMage(user, bot, typeUser);
                        }
                    }
                    userTurn(user, bot, choice, typeUser, typeBot, isAuto);
                    if(bot.currentHp <= 0){
                        System.out.println("\nYou have killed the bot " + bot);
                        bot = createBot(user.lv);
                        typeBot = botClass();
                        user.newStats();
                        hasDied = true;
                        System.out.println("Do you want to change your character (0 for YES -1 For NO)");
                        choice = sc.nextInt();
                        if(choice == 0){
                            if(typeUser.equals("fighter")){
                                System.out.println("2)Rogue");
                                tmp = sc.nextInt();
                            }
                            if(typeUser.equals("rogue")){
                                System.out.println("1)Fighter");
                                tmp = sc.nextInt();
                            }
                        }
                    }
                }
                choice = 0;
            }
            user.killCounter();
        }
        sc.close();
    }
    public static int dice(int boundary){
        //Will be used for use random ability
        double randomNumber = Math.random();
        int result = (int) (randomNumber * boundary);
        //Interval will be 1 - Boundary
        return result + 1;
    }

    public static String botClass(){
        String type = "";
        int randomNumber = dice(3);
        if(randomNumber == 1){
            type = "fighter";
        }
        else if(randomNumber == 2){
            type = "rogue";
        }
        else if(randomNumber == 3){
            type = "mage";
        }
        return type;
    }

    public static Character createBot(int lv){
        int randomNumber = dice(4);
        Character bot = new Character(lv);
        //LV or below 1 level
        if(dice(2) == 1 && lv != 1){
            lv -= 1;
        }
        if(randomNumber == 1){
            bot = new Humans(lv);
            return bot;
        }
        if(randomNumber == 2){
            bot = new Elves(lv);
            return bot;
        }
        if(randomNumber == 3){
            bot = new Dwarfs(lv);
            return bot;
        }
        if(randomNumber == 4){
            bot = new Halflings(lv);
            return bot;
        }
        return null;
    }

    public static void userTurn(Character user, Character bot, int choice, String typeUser, String typeBot, boolean isAuto){
        Scanner sc = new Scanner(System.in);
        if(isAuto){
            choice = dice(5);
        }
        else{
            choice = sc.nextInt();
        }
        if(user instanceof Humans && typeUser.equalsIgnoreCase("fighter")){
            if(choice == 1){
                user.attack(bot);
            }
            else if(choice == 2){
                user.defend();
            }
            else if(choice == 3){
                ((Humans)user).struggle(bot);;
            }
            else if(choice == 4){
                user.slash(bot);
            }
            else if(choice == 5){
                user.burst(bot);
            }
        }
        if(user instanceof Humans && typeUser.equalsIgnoreCase("rogue")){
            if(choice == 1){
                user.attack(bot);
            }
            else if(choice == 2){
                user.defend();
            }
            else if(choice == 3){
                ((Humans)user).struggle(bot);;
            }
            else if(choice == 4){
                user.shootArrow(bot);
            }
            else if(choice == 5){
                user.quickAttack(bot);
            }
        }
        if(user instanceof Humans && typeUser.equalsIgnoreCase("mage")){
            if(choice == 1){
                user.attack(bot);
            }
            else if(choice == 2){
                user.defend();
            }
            else if(choice == 3){
                ((Humans)user).struggle(bot);;
            }
            else if(choice == 4){
                user.fire(bot);
            }
            else if(choice == 5){
                user.blizzard(bot);
            }
            else if(choice == 6){
                user.thunder(bot);
            }
        }
        if(user instanceof Elves && typeUser.equalsIgnoreCase("rogue")){
            if(choice == 1){
                user.attack(bot);
            }
            else if(choice == 2){
                user.defend();
            }
            else if(choice == 3){
                ((Elves)user).manaRestore();
            }
            else if(choice == 4){
                user.shootArrow(bot);
            }
            else if(choice == 5){
                user.quickAttack(bot);
            }
        }
        if(user instanceof Elves && typeUser.equalsIgnoreCase("mage")){
            if(choice == 1){
                user.attack(bot);
            }
            else if(choice == 2){
                user.defend();
            }
            else if(choice == 3){
                ((Elves)user).manaRestore();
            }
            else if(choice == 4){
                user.thunder(bot);
            }
            else if(choice == 5){
                user.blizzard(bot);
            }
            else if(choice == 6){
                user.fire(bot);
            }
        }
        if(user instanceof Dwarfs && typeUser.equalsIgnoreCase("mage")){
            if(choice == 1){
                user.attack(bot);
            }
            else if(choice == 2){
                user.defend();
            }
            else if(choice == 3){
                ((Dwarfs)user).rest();
            }
            else if(choice == 4){
                user.thunder(bot);
            }
            else if(choice == 5){
                user.blizzard(bot);
            }
            else if(choice == 6){
                user.fire(bot);
            }
        }
        if(user instanceof Dwarfs && typeUser.equalsIgnoreCase("fighter")){
            if(choice == 1){
                user.attack(bot);
            }
            else if(choice == 2){
                user.defend();
            }
            else if(choice == 3){
                ((Dwarfs)user).rest();
            }
            else if(choice == 4){
                user.slash(bot);
            }
            else if(choice == 5){
                user.burst(bot);
            }
        }
        if(user instanceof Halflings && typeUser.equalsIgnoreCase("fighter")){
            if(choice == 1){
                user.attack(bot);
            }
            else if(choice == 2){
                user.defend();
            }
            else if(choice == 3){
                ((Halflings)user).mimic(bot, typeBot, false);
            }
            else if(choice == 4){
                ((Halflings)user).secondBreakfast();
            }
            else if(choice == 5){
                user.slash(bot);
            }
            else if(choice == 6){
                user.burst(bot);
            }
        }
        if(user instanceof Halflings && typeUser.equalsIgnoreCase("rogue")){
            if(choice == 1){
                user.attack(bot);
            }
            else if(choice == 2){
                user.defend();
            }
            else if(choice == 3){
                ((Halflings)user).mimic(bot, typeBot, false);
            }
            else if(choice == 4){
                ((Halflings)user).secondBreakfast();
            }
            else if(choice == 5){
                user.shootArrow(bot);
            }
            else if(choice == 6){
                user.quickAttack(bot);
            }
        }
        sc.close();
    }
    public static void botFighter(Character user, Character bot, String typeUser){
        if(bot instanceof Humans){
            int randomNumber = dice(5);     
            if(randomNumber == 1){
                System.out.println("Bot tried to use attack skill");
                bot.attack(user);
            }
            else if(randomNumber == 2){
                System.out.println("Bot tried to use defend skill");
                bot.defend();
            }
            else if(randomNumber == 3){
                System.out.println("Bot tried to use struggle skill");
                ((Humans)bot).struggle(user);;
            }
            else if(randomNumber == 4){
                System.out.println("Bot tried to use slash skill");
                bot.slash(user);
            }
            else if(randomNumber == 5){
                System.out.println("Bot tried to use burst skill");
                bot.burst(user);
            }
        }
        if(bot instanceof Dwarfs){
            int randomNumber = dice(5);     
            if(randomNumber == 1){
                System.out.println("Bot tried to use attack skill");
                bot.attack(user);
            }
            else if(randomNumber == 2){
                System.out.println("Bot tried to use defend skill");
                bot.defend();
            }
            else if(randomNumber == 3){
                System.out.println("Bot tried to use rest skill");
                ((Dwarfs)bot).rest();
            }
            else if(randomNumber == 4){
                System.out.println("Bot tried to use slash skill");
                bot.slash(user);
            }
            else if(randomNumber == 5){
                System.out.println("Bot tried to use burst skill");
                bot.burst(user);
            }
        }
        if(bot instanceof Halflings){
            int randomNumber = dice(6);     
            if(randomNumber == 1){
                System.out.println("Bot tried to use attack skill");
                bot.attack(user);
            }
            else if(randomNumber == 2){
                System.out.println("Bot tried to use defend skill");
                bot.defend();
            }
            else if(randomNumber == 3){
                System.out.println("Bot tried to use mimic skill");
                ((Halflings)bot).mimic(user, typeUser, true);;
            }
            else if(randomNumber == 4){
                System.out.println("Bot tried to use slash skill");
                bot.slash(user);
            }
            else if(randomNumber == 5){
                System.out.println("Bot tried to use burst skill");
                bot.burst(user);
            }
            else if(randomNumber == 6){
                System.out.println("Bot tried to use second breakfast skill");
                ((Halflings)bot).secondBreakfast();
            }
        }
    }
    public static void botRogue(Character user, Character bot, String typeUser){
        if(bot instanceof Humans){
            int randomNumber = dice(5);     
            if(randomNumber == 1){
                System.out.println("Bot tried to use attack skill");
                bot.attack(user);
            }
            else if(randomNumber == 2){
                System.out.println("Bot tried to use defend skill");
                bot.defend();
            }
            else if(randomNumber == 3){
                System.out.println("Bot tried to use struggle skill");
                ((Humans)bot).struggle(user);;
            }
            else if(randomNumber == 4){
                System.out.println("Bot tried to use shoot arrow skill");
                bot.shootArrow(user);;
            }
            else if(randomNumber == 5){
                System.out.println("Bot tried to use quick attack skill");
                bot.quickAttack(user);;
            }
        }
        if(bot instanceof Elves){
            int randomNumber = dice(5);     
            if(randomNumber == 1){
                System.out.println("Bot tried to use attack skill");
                bot.attack(user);
            }
            else if(randomNumber == 2){
                System.out.println("Bot tried to use defend skill");
                bot.defend();
            }
            else if(randomNumber == 3){
                System.out.println("Bot tried to use mana restore skill");
                ((Elves)bot).manaRestore();
            }
            else if(randomNumber == 4){
                System.out.println("Bot tried to use quick attack skill");
                bot.quickAttack(user);;
            }
            else if(randomNumber == 5){
                System.out.println("Bot tried to use shoot arrow skill");
                bot.shootArrow(user);;
            }
        }
        if(bot instanceof Halflings){
            int randomNumber = dice(6);     
            if(randomNumber == 1){
                System.out.println("Bot tried to use attack skill");
                bot.attack(user);
            }
            else if(randomNumber == 2){
                System.out.println("Bot tried to use defend skill");
                bot.defend();
            }
            else if(randomNumber == 3){
                System.out.println("Bot tried to use mimic skill");
                ((Halflings)bot).mimic(user, typeUser, true);;
            }
            else if(randomNumber == 4){
                System.out.println("Bot tried to use shoot arrow skill");
                bot.shootArrow(user);;
            }
            else if(randomNumber == 5){
                System.out.println("Bot tried to use quick attack skill");
                bot.quickAttack(user);
            }
            else if(randomNumber == 6){
                System.out.println("Bot tried to use second breakfast skill");
                ((Halflings)bot).secondBreakfast();
            }
        }
    }
    public static void botMage(Character user, Character bot, String typeUser){
        if(bot instanceof Humans){
            int randomNumber = dice(6);     
            if(randomNumber == 1){
                System.out.println("Bot tried to use attack skill");
                bot.attack(user);
            }
            else if(randomNumber == 2){
                System.out.println("Bot tried to use defend skill");
                bot.defend();
            }
            else if(randomNumber == 3){
                System.out.println("Bot tried to use struggle skill");
                ((Humans)bot).struggle(user);;
            }
            else if(randomNumber == 4){
                System.out.println("Bot tried to use fire skill");
                bot.fire(user);
            }
            else if(randomNumber == 5){
                System.out.println("Bot tried to use thunder skill");
                bot.thunder(user);
            }
            else if(randomNumber == 6){
                System.out.println("Bot tried to use blizzard skill");
                bot.blizzard(user);
            }
        }
        if(bot instanceof Dwarfs){
            int randomNumber = dice(6);     
            if(randomNumber == 1){
                System.out.println("Bot tried to use attack skill");
                bot.attack(user);
            }
            else if(randomNumber == 2){
                System.out.println("Bot tried to use defend skill");
                bot.defend();
            }
            else if(randomNumber == 3){
                System.out.println("Bot tried to use rest skill");
                ((Dwarfs)bot).rest();
            }
            else if(randomNumber == 4){
                System.out.println("Bot tried to use fire skill");
                bot.fire(user);
            }
            else if(randomNumber == 5){
                System.out.println("Bot tried to use thunder skill");
                bot.thunder(user);
            }
            else if(randomNumber == 6){
                System.out.println("Bot tried to use blizzard skill");
                bot.blizzard(user);
            }
        }
        if(bot instanceof Elves){
            int randomNumber = dice(6);     
            if(randomNumber == 1){
                System.out.println("Bot tried to use attack skill");
                bot.attack(user);
            }
            else if(randomNumber == 2){
                System.out.println("Bot tried to use defend skill");
                bot.defend();
            }
            else if(randomNumber == 3){
                System.out.println("Bot tried to use mana restore skill");
                ((Elves)bot).manaRestore();
            }
            else if(randomNumber == 4){
                System.out.println("Bot tried to use fire skill");
                bot.fire(user);
            }
            else if(randomNumber == 5){
                System.out.println("Bot tried to use thunder skill");
                bot.thunder(user);
            }
            else if(randomNumber == 6){
                System.out.println("Bot tried to use blizzard skill");
                bot.blizzard(user);
            }
        }
    }
}

