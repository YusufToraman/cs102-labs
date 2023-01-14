package AbstractClass;

public class Zoo {
    public static void main(String[] args) {
        Animal a = new Wolf();
        a.eat("böörek");
        a.vocalize(20);
        ((Wolf)a).kill();
    }
}
