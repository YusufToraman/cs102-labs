package Lab3;

public class Dwarfs extends Character{
    public Dwarfs(int lv){
        super(lv);
        setHp();
        setMp();
        setSpeed();
        type = "Dwarfs";
    }

    public void setHp(){
        this.hp = 40 + lv;
    }

    public void setMp(){
        this.mp = 10 + lv;
    }

    public void setSpeed(){
        this.speed = (int)lv / 2 + 1;
    }

    public void rest(){
        if(this.currentMp >= 7){
            this.currentHp += 20;
            this.currentMp -= 7;
        }
        else{
            System.out.println("Your Mana Power is less than 7");
        }
    }

    public String toString(){
        String output = "Level " + this.lv + " Dwarf";
        return output;
    }
}
