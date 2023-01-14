package AbstractClass;

public abstract class Animal {
    public void eat(String food){
        System.out.println("Animal eats " + food);
    }
    public static void walk(){
        System.out.println("Animal walks");
    }
    public abstract void vocalize(int volume);
}
