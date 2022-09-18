package Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class Threatre {
   
    private String threatreName;
    private int numRows ;
    private int numCol; 
    private  List<Seat> seats = new ArrayList<>();

    public Threatre(String threatreName, int numRows, int numCol) {
        if(threatreName.isEmpty()){
            threatreName = "Empire";
        }
        else{
          this.threatreName = threatreName;
        }
        this.numRows = numRows;
        this.numCol = numCol;
        int lastRow = 'A' + (numRows-1);
        for (char row = 'A'; row <=lastRow; row++) {
            for (int column = 0; column < numCol; column++) {
                Seat seat = new Seat(row + String.format("%02d", column));
                seats.add(seat);
            }
        }
    }

    public boolean getSeatByNum(String seatNum){
        Seat requestedSeat = null;
        for (Seat seat : seats) {
            if(seatNum.equals(seat.getNumSeat())){
                requestedSeat = seat;
                break;
            }
        }
        if(requestedSeat==null){
            System.out.println("Sorry there is no seat which you have requested");
            return  false;
        }
        return requestedSeat.reserve();
    }


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

class Seat{

    private String seatNum;
    private boolean reserved = false;

    public Seat(String numSeat) {
        this.seatNum = numSeat;
    }
    
    public String getNumSeat() {
        return seatNum;
    }
    public void setNumSeat(String numSeat) {
        this.seatNum = numSeat;
    }
    public boolean isReserved() {
        return reserved;
    }
    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public boolean reserve() {
        if(!this.reserved) {
            this.reserved = true;
            return true;
        } else {
            return false;
        }
    }
}