import java.util.*;

public class MaxHeap {

    public static long total_time, start_time, end_time;
    public static void main(String[] args) {

        

        Scanner stdin = new Scanner(System.in);
        
        System.out.println("Size of the array: ");
        int size = stdin.nextInt();
        System.out.println("Enter node elements: ");
        int[] heapArray = new int[size];
        for(int i = 0; i < size; i++)
        {
            int element = stdin.nextInt();
            heapArray[i] = element;
        }

        int n = heapArray.length-1;
        //find the time taken to sort the array
        start_time = System.nanoTime();
        
        if(isHeap(heapArray, 0, n))
        {
            System.out.println("Yes, it is a max heap");
        }
        else{
            System.out.println("No, it is not a max heap");
        }

        stdin.close();
        end_time = System.nanoTime();
        total_time = end_time-start_time;

        System.out.println("Runnning time: "+total_time+" nanoseconds");
       
    }

    //left child = 2*i + 1
    //right child = 2*i +2
    //parent = (index - 1) /2
    static boolean isHeap(int[] heapArray, int i, int n) 
    {
        //floor function to check whether it is a leaf node
       //check for children's existence
        if((2* i + 1) > n && (2* i + 2) > n)
        {
            return true; 
        }
        //check for possible right side child with parent
        if((2* i + 2) <= n)
        {//if so then continue checking whether parent element smaller than child
            if(heapArray[i] < heapArray[2* i +2])
            {
                return false;
            }
        }
        //check left side child element is larger than parent
        if(heapArray[i] < heapArray[2* i +1])
        {
            return false;
        }
        //recursive to loop and continue to chain of nodes 
            return isHeap(heapArray, 2*i +1, n) && isHeap(heapArray, 2*i +2, n);

       
         
    }
}