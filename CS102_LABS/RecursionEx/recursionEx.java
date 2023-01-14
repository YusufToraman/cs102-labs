package RecursionEx;

import java.util.ArrayList;

public class recursionEx {
    
    public static void main(String[] args) {
        System.out.println(power(2, 3));
    }

    public static boolean palindrom(String word){
        word = word.toLowerCase();
        int len = word.length();
        if(len <= 1){
            return true;
        }
        else{
            if(Character.isLetter(word.charAt(0)) && Character.isLetter(word.charAt(len -1))){
                if(word.charAt(0) == word.charAt(len - 1)){
                    return palindrom(word.substring(1, len - 1));
                }
                else{
                    return false;
                }
            }
            else if(!Character.isLetter(word.charAt(0))){
                return palindrom(word.substring(1, len));
            }
            else{
                return palindrom(word.substring(0, len - 1));
            }
        }
    }

    public static long fib(int n){
        if(n <= 2){
            return 1;
        }
        else{
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static ArrayList<String> permutations(String word){
        ArrayList <String> list = new ArrayList<>();
        if(word.length() == 0) return list;
        else if(word.length() == 1) list.add(word);
        else{
            for(int i = 0; i < word.length(); i++){
                ArrayList<String> shorterPermutations = permutations(word.substring(0, i) + word.substring(i + 1));
                for (String s : shorterPermutations){
                    list.add(word.charAt(i) + s);
                 }
            }
        }
        return list;
    }

    
    public static int factorial(int n){
        if(n <= 1){
            return 1;
        }
        else{
            return n * factorial(n - 1);
        }
    }

    public static int power(int base, int power){
        if(power == 0){
            return 1;
        }
        return base * power(base, power - 1);
    }

    public static void permutations(String remainingString , String permutation) {
        if(remainingString.length() == 0 ) {
            System.out.println(permutation);
        }
     
        for(int i = 0; i < remainingString.length();i++) {
            char ch = remainingString.charAt(i);
            String permute = permutation+ch;
            String next = remainingString.substring(0,i)  + 
                          remainingString.substring(i+1);
            permutations(next,permute);
        }   
    }

    public static int binarySearch(int[] arr, int left, int right, int target){
        int mid = (right + left) / 2;
        if(left > right) return -1;
        else if(arr[mid] == target){
            return mid;
        }
        else if(arr[mid] < target){
            return binarySearch(arr, left + 1, right, target);
        }
        else{
            return binarySearch(arr, left, right - 1, target);
        }
    }

    public static int linearSearch(int[] arr, int target, int index){
        if(arr[index] == target){
            return index;
        }
        else if(0 == index){
            return -1;
        }
        else{
            return linearSearch(arr, target, index - 1);
        }
    }

    //Write a program to calculate the sum of arithmetic series from 1 to N?
    public static int sumOfSeries(int n){
        if(n == 1){
            return 1;
        }
        else{
            return n + sumOfSeries(n - 1);
        }
    }

    //Write a program to calculate Greatest Common Division  GCD using Euclid's algorithm
    public static int gcd(int k, int l){
        if(l == 0){
            return k;
        }
        else{
            return gcd(l, k % l);
        }
    }

    public static String reverseString(String word){
        if(word.length() == 1){
            return word;
        }
        else{
            String shorter = word.substring(0, word.length() - 1);
            return word.charAt(word.length() - 1) + reverseString(shorter);
        }
    }

    public static int[] reverseIntArray(int[] arr, int i, int k){
        if(i > k){
            return arr;
        }
        else{
            int tmp = arr[i];
            arr[i] = arr[k];
            arr[k] = tmp;
            return reverseIntArray(arr, i + 1, k - 1);
        }
    }
    public static String dtoB(int n){
        if(n == 0){
            return "";
        }
        else{
            return dtoB(n / 2) + n % 2 ;
        }
    }
    
}
