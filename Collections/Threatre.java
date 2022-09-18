package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


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
        Seat requestedSeat = new Seat(seatNum);
        int foundSeat = Collections.binarySearch(seats , requestedSeat , null);
        if(foundSeat>=0){
            System.out.println("Seat found with seat number "+ seatNum);
            return seats.get(foundSeat).reserve();
        }
        else{
            System.out.println("No seat found with seat number "+seatNum);
            return false;
        }
    }
 
    public void getSeats(){
        for (Seat seat : this.seats) {

            System.out.println(seat.getNumSeat());
            
        }
    }
    
    private class Seat implements Comparable<Seat>{

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
    
        @Override
        public int compareTo(Seat seat) {
            return this.seatNum.compareToIgnoreCase(seat.getNumSeat());
        }
        
    }

}

