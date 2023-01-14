package HierarchyQuestions;

public class B extends A{
    int k = 50;
    int c = 40;
    public B(){
        super.c = 5;
        System.out.println(super.c);
        
        

        System.out.println(k+c);
    }
    // public static void display() {
    //     System.out.println("Inside static method of this class");
    // }
}
