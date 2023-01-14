package HierarchyEx;

public class Zoo{
    public static void main(String[] args) {
        Animal [] zoo = new Animal[4];
        zoo[0] = new Lion();
        zoo[1] = new Reptile();
        zoo[2] = new Bat();
        zoo[3] = new Dragon();
        ((Lion)zoo[0]).roar();
        zoo[0].sleep();
        zoo[0].eat();
        ((Lion)zoo[0]).controlTemp();
        System.out.println();
        Animal m = new Bat();
        ((Bat)m).sleep();
        System.out.println();
        zoo[1].eat();
        zoo[1].sleep();
        ((Reptile)zoo[1]).layEgg();
        System.out.println();
        ((Reptile)zoo[3]).layEgg();
        System.out.println();

        Animal a = new Lion();
        ((Mammal)a).controlTemp();
        // Mammal joe = new Mammal();
        // Mammal joeL = new Lion();
        // Bat betty = new Bat();

        // joe.controlTemp();
        // joe.eat();
        // joe.sleep();
        // //((Lion)joe).roar();       CAST EXCEPTION
        // System.out.println("*".repeat(40));
        // joeL.controlTemp();
        // joeL.eat();
        // joeL.sleep();
        // ((Lion)joeL).roar();
        // System.out.println("*".repeat(40));
        // ((Bat)betty).controlTemp();
        // betty.eat();
        // betty.sleep();
        // ((Bat)betty).fly();
    }
}
