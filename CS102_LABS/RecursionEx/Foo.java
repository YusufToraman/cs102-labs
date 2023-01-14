package RecursionEx;

public class Foo {
    
    int num1;
    int num2;

    public Foo(int _num1, int _num2){
        num1 = _num1;
        num2 = _num2;
    }

    public void modify(Foo obj){
        obj.num1 += 100;
        obj.num2 += 1000;
    }
}
