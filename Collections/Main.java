package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Threatre threatre = new Threatre("Empire", 6, 6);
        List<Threatre.Seat> seatsCopy = new ArrayList<>(threatre.seats);
        printList(seatsCopy);
        System.out.println("=========================================");

        seatsCopy.get(1).reserve(); // reserving seat A01 which means seatsCopy and seats(list inside class) are pointing same
        // sets of objects
        String seatNum = "A01";
        if(threatre.getSeatByNum(seatNum)){
               System.out.println("Please pay");
        }
        else{
            System.out.println("Sorry seat is already reserved");
        }
        if(threatre.getSeatByNum(seatNum)){
            System.out.println("Please pay");
     }
     else{
         System.out.println("Sorry seat is already reserved");
     }
     System.out.println("=========================================");

      Collections.reverse(seatsCopy);  // reversing the order of the list
      printList(seatsCopy);

      Collections.shuffle(seatsCopy); // randomly shuffle the list 
      printList(seatsCopy);

    }

    public static void printList(List<Threatre.Seat> seats){

        for (Threatre.Seat seat : seats) {
            System.out.print(" " + seat.getNumSeat());
        }

    }
    
}
