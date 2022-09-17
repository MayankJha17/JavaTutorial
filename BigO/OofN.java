package BigO;

public class OofN {

    // O(n) --> Linear time.
    // As no. of elements increases no. of operation also increases.

    private static void searchItem(String[] arr ) {

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == "Table"){
                System.out.println("Table found");
            }
        }
        
    }

     public static void main(String[] args) {
        final String[] arr = new String[]{"Table" , "Chair" };
        searchItem(arr);
    }
    
}
