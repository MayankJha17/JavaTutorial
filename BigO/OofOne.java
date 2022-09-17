package BigO;

// O(1) --> means constant time 

// Example in this case is printing first and second item in array , it does not iterate through loop
public class OofOne {

    private static void printFirstTwoItems(int[] arr) {

        System.out.println(arr[0]); // O(1)
        System.out.println(arr[1]); //O(1)
        
    }

    public static void main(String[] args) {
        final int[] arr = new int[]{1,2,3,4,5};
        printFirstTwoItems(arr);    
    }
    
}
