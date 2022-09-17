package Collections;

import java.util.ArrayList;
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

    public Optional<Seat> getSeatByNum(String seatNum){
        Seat reservedSeat = null;
        for (Seat seat : seats) {
            if(seatNum.equals(seat.getNumSeat())){
                reservedSeat = seat;
                break;
            }
        }
        if(reservedSeat==null){
            System.out.println("Sorry there is no seat which you have requested");
            return  Optional.empty();
        }
        return Optional.of(reservedSeat);
    }

    public void changeSeatReservedStatus(Seat seatReserve){
           
        for (Seat seat : seats) {
             if(seatReserve.getNumSeat().equals(seat.getNumSeat())){
                seat.setReserved(true);
                break;
             }
        }
    }

    public static void main(String[] args) {
        Threatre threatre = new Threatre("Empire", 6, 6);
        Optional<Seat> optionalSeat = threatre.getSeatByNum("E01");
        if(optionalSeat.isPresent()){
            Seat seat = optionalSeat.get();
            if(seat.isReserved()){
                System.out.println("Seat is reserved");
            }
            else{
                System.out.println("Please pay ");
                System.out.println(seat.isReserved());
                // Considering customer has done payment we can change reserved statuds to true
                threatre.changeSeatReservedStatus(seat);
            }
        }
        else{
            System.out.println("There is no seat available which you are requested");
        }


    }

}

class Seat{

    private String seatNum;
    private boolean reserved;

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
}