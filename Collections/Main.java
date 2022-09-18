package Collections;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Threatre threatre = new Threatre("Empire", 6, 6);
        String seatNum = "E01";
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
    }
    
}
