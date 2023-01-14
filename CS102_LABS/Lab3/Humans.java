package Lab3;

public class Humans extends Character{
    public Humans(int lv){
        super(lv);
        type = "Humans";
        setHp();
    }

    public void setHp(){
        this.hp = (int)(3 * lv + 35);
    }

    public void struggle(Object obj){
        //TypeCasting
        Character opponent = (Character) obj;

        int subtractedHp = 10;
        if(this.hp - subtractedHp > 0){
            opponent.currentHp = opponent.currentHp - (this.hp / 4); 
            this.currentHp = this.currentHp - subtractedHp;
        }
        else{
            System.out.println("You cannot use struggle skill your hp is: " + currentHp);
        }
    }

    public String toString(){
        String output = "Level " + this.lv + " Human";
        return output;
    }
}
