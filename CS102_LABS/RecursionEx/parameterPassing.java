package RecursionEx;

public class parameterPassing {
    public static void main(String[] args) {
        int x = 5;
        int y = 10;
        System.out.println(x + " " + y);
        modify(x, y);
        x += 2;
        y += 2;
        System.out.println(x + " " + y);
        Foo boo = new Foo(x, y);
        System.out.println(x + " " + y);
        boo.modify(boo);
        System.out.println(boo.num1 + " " + boo.num2);
        System.out.println(x + " " + y);
    }

    public static void modify(int x1, int y1){
        System.out.println(x1 + " " + y1);
        x1 += 3;
        y1 += 1;
        System.out.println(x1 + " " + y1);
    }
}
