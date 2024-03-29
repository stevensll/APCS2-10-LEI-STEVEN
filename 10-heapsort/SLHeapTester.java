import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class SLHeapTester {
    public static void main(String[] args) {
        // int[] test = new int[]{1,7,5,3,9,10,4};
        // int[] emptyArray = new int[]{};
        // int[] test2 = new int[]{1,1,1,1,1,1,1,1,1};
        // int[] test3 = new int[]{1,2};
        // int[] test4 = new int[]{1};

        // System.out.println(Arrays.toString(test));
        // System.out.println(Arrays.toString(test2));
        // System.out.println(Arrays.toString(test3));
        // System.out.println(Arrays.toString(test4));
        // System.out.println(Arrays.toString(emptyArray));

        // // MyHeap.pushDown(test, test.length, 0);
        // MyHeap.heapsort(test);
        // // System.out.println(Arrays.toString(test));

        // MyHeap.heapsort(test2);
        // MyHeap.heapsort(test3);
        // MyHeap.heapsort(test4);
        // MyHeap.heapsort(emptyArray);


        // System.out.println(Arrays.toString(test));
        // System.out.println(Arrays.toString(test2));
        // System.out.println(Arrays.toString(test3));
        // System.out.println(Arrays.toString(test4));
        // System.out.println(Arrays.toString(emptyArray));
        
        if(args[0].equals("auto")){
            int size = 10000000;
            int[]random = arrGen(size, "random", 1000);
            int[]sorted = arrGen(size, "sorted", 1000);
            int[]reversed = arrGen(size, "reversed", 1000);
            int[]binary = arrGen(size, "binary", 1000);
            int[]equal = arrGen(size, "equal", 1000);
            sortcheck(random);
            sortcheck(sorted);
            sortcheck(reversed);
            sortcheck(binary);
            sortcheck(equal);
        } else {
            int size = Integer.parseInt(args[0]);
            String type = args[1];
            int[]test = arrGen(size, type, 1000);
            if(sortcheck(test)){
                System.out.println("good");
            } else {
                System.out.println("fail");
            }
        }
    }
    public static boolean sortcheck(int[] data){
        int [] copy = Arrays.copyOf(data,data.length);
        Arrays.sort(copy);
        MyHeap.heapsort(data);
        if(!Arrays.equals(copy,data)){
            System.out.println(copy);
            System.out.println(data);
            return false;
        }
        return true;
    }
    public static int[] arrGen(int size, String type, int bound){
        Random gen = new Random();
        // bound = 10000; //by deafult element bound is 10e4
        int [] arr  = new int[size];
        for(int i = 0; i < size; i++){
            if(type.equals("binary")) arr[i] = gen.nextInt(2);
            else if(type.equals("equal")) arr[i] = 323;
            else arr[i] = gen.nextInt(bound+1);
        }
        if(type.equals("reversed")){
            int[] arrDesc = Arrays.stream(arr).boxed()
                            .sorted(Collections.reverseOrder())
                            .mapToInt(Integer::intValue)
                            .toArray();
            arr = arrDesc;
        }
        if(type.equals("sorted")){
            Arrays.sort(arr);
        }
        return arr;
    }
}
