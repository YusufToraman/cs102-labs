package Lab3;

public class Character implements Fighter, Mage, Rogue{

    protected String type;
    protected int lv;
    protected int hp;
    protected int mp;
    protected int speed;
    protected int baseAttack;
    protected int baseMagic;
    protected int recoverHp;
    protected int currentHp;
    protected int currentMp;

    public Character(int lvl){
        lv = lvl;
        setHp();
        setMp();
        setSpeed();
        setBaseAttack();
        setBaseMagic();
        this.currentHp = hp;
        this.currentMp = mp;
    }

    public void setHp(){
        this.hp = (int)(4 * lv) + 20;
    }

    public void setMp(){
        this.mp = (int)(hp / 2);
    }

    public void setSpeed(){
        this.speed = lv;
    }

    public void setBaseAttack(){               
        this.baseAttack = (int)(hp / 10) + 1;
    }

    public void setBaseMagic(){
        this.baseMagic = (int)(mp / 5) + 2;
    }

    public void attack(Object obj){
        Character opponent = (Character) obj;
        if(opponent instanceof Mage){
            opponent.currentHp -= this.baseMagic;
        }
        else{
            opponent.currentHp -= this.baseAttack;
        }

    }

    public void defend(){
        this.currentHp += (int) (hp / 10);
    }

    public String toString(){
        String output = "Character Current HP is " + this.hp + "\nCurrent MP is: " + this.mp + "\nSpeed is: " + this.speed + "\nBase Attack is " + this.baseAttack + "\nBase magic is: " + this.baseMagic;
        return output;
    }

    public void printStats(){
        System.out.println("Current HP: " + currentHp + "\nCurrent Mana: " + currentMp + "\n" + "*".repeat(100));
    }

    public void newStats(){
        lv++;
        setHp();
        setMp();
        setSpeed();
        setBaseAttack();
        setBaseMagic();
        this.currentHp += (int)(this.hp / 10);
        this.currentMp += (int)(this.mp / 10);
    }

    public void killCounter(){
        System.out.println("You have killed " + (lv - 1) + " creature");
    }
    
    @Override
    public void quickAttack(Object obj) {
        Character opponent = (Character) obj;
        if(this.currentMp >= 2){
            this.currentMp -= 2;
            opponent.currentHp -= baseAttack;
        }
        else{
            System.out.println("You cannot use quick attack skill your mana is " + this.currentMp);
        }
    }

    @Override
    public void shootArrow(Object obj) {
        Character opponent = (Character) obj;
        if(this.currentHp > 3){
            this.currentHp -= 3;
            opponent.currentHp -= baseAttack + speed + 2;
        }
        else{
            System.out.println("You cannot use this skill your current HP is: " + this.currentHp);
        }
    }

    @Override
    public void fire(Object obj) {
        Character opponent = (Character) obj;
        int maxSpeed = opponent.speed;
        if(opponent.speed < this.speed){
            maxSpeed = speed;
        }
        opponent.currentHp -= 3 * maxSpeed;
        if(this.currentMp >= 2){
            this.currentMp -= 2;
        }
        else{
            if(opponent.currentHp > 0){
                this.currentHp -= 3;
            }
        }
    }

    @Override
    public void thunder(Object obj) {
        Character opponent = (Character) obj;
        if(this.currentMp >= 8){
            this.currentMp -= 8;
            opponent.currentHp -= baseMagic * 2;
        }
        else{
            System.out.println("Mana is not enough for skill Thunder (" + currentMp + ")");
        }
    }

    @Override
    public void blizzard(Object obj) {
        Character opponent = (Character) obj;
        final int TOTAL_LOSS = 12;
        int totalLoss1 = this.currentMp;
        int totalLoss2 = opponent.currentMp;

        if(totalLoss1 >= TOTAL_LOSS){
            this.currentMp -= TOTAL_LOSS;
        }
        else{
            int left = 12 - this.currentMp;
            this.currentMp -= this.currentMp;
            this.currentHp -= left;
        }

        if(totalLoss2 >= TOTAL_LOSS){
            opponent.currentMp -= TOTAL_LOSS;
        }
        else{
            int left = 12 - opponent.currentMp;
            opponent.currentMp -= opponent.currentMp;
            opponent.currentHp -= left;
        }
    }

    @Override
    public void slash(Object obj) {
        Character opponent = (Character) obj;
        if(this.currentMp >= 5){
            this.currentMp -= 5;
            opponent.currentHp -= this.baseAttack * 2;
        }
        else{
            System.out.println("Mana is not enough for slash (" + this.currentMp + ")");
        }
    }

    @Override
    public void burst(Object obj) {
        Character opponent = (Character) obj;
        int spentMp = this.currentMp;
        this.currentMp = 0;
        opponent.currentHp -= spentMp * 3;
    }
}
