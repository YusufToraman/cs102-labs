package AbstractClass;

public class Wolf extends Animal{

    public void eat(String food){
        System.out.println("The wolf eats " + food);
    }

    @Override
    public void vocalize(int volume) {
        if(volume < 5){
            System.out.println("The wolf barks");
        }
        else{
            System.out.println("The wolf howles");
        }
    }

    public static void walk(){
        System.out.println("ahhahaha");
    }

    public void kill(){
        System.out.println("Wolf kill someone");
    }
    
}
