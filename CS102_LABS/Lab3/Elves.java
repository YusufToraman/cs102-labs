package Lab3;

public class Elves extends Character{
    public Elves(int lv){
        super(lv);
        type = "Elves";
        setMp();
    }

    public void setMp(){
        this.mp = this.hp - 10;
        this.speed = lv + 4;
    }

    public void manaRestore(){
        if(this.currentHp > 2){
            this.currentHp -= 2;
            this.currentMp += lv * 2;
        }
        else{
            System.out.println("You cannot use this skill your hp is: " + currentHp);
        }

    }

    public String toString(){
        String output = "Level " + this.lv + " Elf";
        return output;
    }
}
