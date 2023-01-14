package Linkedlist;
import java.util.*;

class Program {
  public static boolean balancedBrackets(String str) {
    Stack<Character> stack = new Stack<Character>();
    for(int i = 0; i < str.length(); i++){
      if(str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{'){
        stack.push(str.charAt(i));
      }
      if(!stack.isEmpty()){
        if(stack.peek() == '('){
          if(str.charAt(i) == '}' || str.charAt(i) == ']'){
            return false;
          }
          else if(str.charAt(i) == ')'){
            stack.pop();
          }
        }
        else if(stack.peek() == '{'){
          if(str.charAt(i) == ')' || str.charAt(i) == ']'){
            return false;
          }
          else if(str.charAt(i) == '}'){
            stack.pop();
          }
        }
        else if(stack.peek() == '['){
          if(str.charAt(i) == '}' || str.charAt(i) == ')'){
            return false;
          }
          else if(str.charAt(i) == ']'){
            stack.pop();
          }
        }
      }
    }
    return stack.isEmpty();
  }
  public static void main(String[] args) {
    String s = ")[]}";
    System.out.println(balancedBrackets(s));
  }
}
