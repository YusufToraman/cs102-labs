package Lab3;

public class Halflings extends Character{
    public Halflings(int lv){
        super(lv);
        type = "Halflings";
    }

    public void secondBreakfast(){
        this.hp += 5;
        this.mp += 5;
    }

    //Boolean isBot
    public void mimic(Object obj, String type, boolean isBot){
        
        Character opponent = (Character) obj;
        if(obj instanceof Humans && (type.equalsIgnoreCase("fighter"))){
            int rand = (int)(Math.random() * 5);
            if(rand == 0){
                int subtractedHp = 10;
                if(this.hp - subtractedHp > 0){
                    opponent.currentHp = opponent.currentHp - (this.hp / 4); 
                        this.currentHp = this.currentHp - subtractedHp;
                }
                else{
                    System.out.println("You cannot use struggle skill your hp is: " + currentHp);
                }
            }
            if(rand == 1){
                this.attack(opponent);
            }
            if(rand == 2){
                this.defend();
            }
            if(rand == 3){
                this.slash(opponent);
            }
            if(rand == 4){
                this.burst(opponent);
            }
        }
        if(obj instanceof Humans && (type.equalsIgnoreCase("rogue"))){
            int rand = (int)(Math.random() * 5);
            if(rand == 0){
                int subtractedHp = 10;
                if(this.hp - subtractedHp > 0){
                    opponent.currentHp = opponent.currentHp - (this.hp / 4); 
                        this.currentHp = this.currentHp - subtractedHp;
                }
                else{
                    System.out.println("You cannot use struggle skill your hp is: " + currentHp);
                }
            }
            if(rand == 1){
                this.attack(opponent);
            }
            if(rand == 2){
                this.defend();
            }
            if(rand == 3){
                this.quickAttack(opponent);
            }
            if(rand == 4){
                this.shootArrow(opponent);
            }
        }
        if(obj instanceof Humans && (type.equalsIgnoreCase("mage"))){
            int rand = (int)(Math.random() * 6);
            if(rand == 0){
                int subtractedHp = 10;
                if(this.hp - subtractedHp > 0){
                    opponent.currentHp = opponent.currentHp - (this.hp / 4); 
                        this.currentHp = this.currentHp - subtractedHp;
                }
                else{
                    System.out.println("You cannot use struggle skill your hp is: " + currentHp);
                }
            }
            if(rand == 1){
                this.attack(opponent);
            }
            if(rand == 2){
                this.defend();
            }
            if(rand == 3){
                this.fire(opponent);
            }
            if(rand == 4){
                this.blizzard(opponent);
            }
            if(rand == 5){
                this.thunder(opponent);
            }
        }
        if(obj instanceof Elves && (type.equalsIgnoreCase("rogue"))){
            int rand = (int)(Math.random() * 5);
            if(rand == 0){
                if(this.currentHp > 2){
                    this.currentHp -= 2;
                    this.currentMp += lv * 2;
                }
                else{
                    System.out.println("You cannot use this skill your hp is: " + currentHp);
                }
            }
            if(rand == 1){
                this.attack(opponent);
            }
            if(rand == 2){
                this.defend();
            }
            if(rand == 3){
                this.quickAttack(opponent);
            }
            if(rand == 4){
                this.shootArrow(opponent);
            }
        }
        if(obj instanceof Elves && (type.equalsIgnoreCase("mage"))){
            int rand = (int)(Math.random() * 6);
            if(rand == 0){
                if(this.currentHp > 2){
                    this.currentHp -= 2;
                    this.currentMp += lv * 2;
                }
                else{
                    System.out.println("You cannot use this skill your hp is: " + currentHp);
                }
            }
            if(rand == 1){
                this.attack(opponent);
            }
            if(rand == 2){
                this.defend();
            }
            if(rand == 3){
                this.fire(opponent);
            }
            if(rand == 4){
                this.blizzard(opponent);
            }
            if(rand == 5){
                this.thunder(opponent);
            }
        }
        if(obj instanceof Dwarfs && (type.equalsIgnoreCase("fighter"))){
            int rand = (int)(Math.random() * 5);
            if(rand == 0){
                if(this.currentMp >= 7){
                    this.currentHp += 20;
                    this.currentMp -= 7;
                }
                else{
                    System.out.println("Your Mana Power is less than 7");
                }
            }
            if(rand == 1){
                this.attack(opponent);
            }
            if(rand == 2){
                this.defend();
            }
            if(rand == 3){
                this.slash(opponent);
            }
            if(rand == 4){
                this.burst(opponent);
            }
        }
        if(obj instanceof Dwarfs && (type.equalsIgnoreCase("mage"))){
            int rand = (int)(Math.random() * 6);
            if(rand == 0){
                if(this.currentMp >= 7){
                    this.currentHp += 20;
                    this.currentMp -= 7;
                }
                else{
                    System.out.println("Your Mana Power is less than 7");
                }
            }
            if(rand == 1){
                this.attack(opponent);
            }
            if(rand == 2){
                this.defend();
            }
            if(rand == 3){
                this.fire(opponent);
            }
            if(rand == 4){
                this.blizzard(opponent);
            }
            if(rand == 5){
                this.thunder(opponent);
            }
        }
        if(obj instanceof Halflings && (type.equalsIgnoreCase("fighter"))){
            int rand = (int)(Math.random() * 5);
            if(rand == 0){
                this.hp += 5;
                this.mp += 5;
            }
            if(rand == 1){
                this.attack(opponent);
            }
            if(rand == 2){
                this.defend();
            }
            if(rand == 3){
                this.slash(opponent);
            }
            if(rand == 4){
                this.burst(opponent);
            }
        }
        if(obj instanceof Halflings && (type.equalsIgnoreCase("rogue"))){
            int rand = (int)(Math.random() * 5);
            if(rand == 0){
                this.hp += 5;
                this.mp += 5;
            }
            if(rand == 1){
                this.attack(opponent);
            }
            if(rand == 2){
                this.defend();
            }
            if(rand == 3){
                this.shootArrow(opponent);
            }
            if(rand == 4){
                this.quickAttack(opponent);
            }
        }
    }

    public String toString(){
        String output = "Level " + this.lv + " Halfling";
        return output;
    }

}
