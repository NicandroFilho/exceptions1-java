package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duration(){
        long duration = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(duration, TimeUnit.MILLISECONDS);
    }

    public String updateDates(Date checkIn, Date checkOut){

        Date now = new Date();

        if(checkIn.before(now) || checkOut.before(now) ) {
            return "Update must be for a future date.";
        }
        if(!checkOut.after(checkIn)){
            return "Check-out date must be after Check-in date.";
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber +
                ", Check-In: " + sdf.format(checkIn) +
                ", Check-Out: " + sdf.format(checkOut)+
                ", " + duration() +
                " nights.";
    }
}
