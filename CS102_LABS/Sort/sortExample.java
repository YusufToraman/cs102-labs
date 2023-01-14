package Sort;

public class sortExample {
    public static void main(String[] args) {
        int [] a = {13, 7, 21, 3, 12, 18, 25, 1};
        insertionSort(a);
        for(int i: a){
            System.out.println(i);
        }
    }

    public static void selectionSort(int[] a){
        for(int i = 0; i < a.length - 1; i++){
            int minPos = minPos(a, i);
            swap(a, minPos, i);
        }
    }

    public static void insertionSort(int [] a){
        for(int i = 1; i < a.length; i++){
            int key = a[i];
            int j = i - 1;
            while(j >= 0 && a[j] > key){
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
    }

    public static int minPos(int [] a, int from){
        int minPos = from;
        for(int i = from + 1; i < a.length; i++){
            if(a[i] < a[minPos]){
                minPos = i;
            }
        }
        return minPos;
    }
    public static void swap(int [] a, int minPos, int i){
        int tmp = a[i];
        a[i] = a[minPos];
        a[minPos] = tmp;
    }


}
