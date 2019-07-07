package com.epam.automation.classes.a;

public class Seat {
    private SeatClass seatClass;
    private boolean occupied;

    public enum SeatClass {
        FIRST, SECOND, THIRD, LUXURY
    }

    public Seat(SeatClass seatClass) {
        this.seatClass = seatClass;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatClass=" + seatClass +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seat seat = (Seat) o;

        return seatClass == seat.seatClass;
    }

    @Override
    public int hashCode() {
        int result = seatClass != null ? seatClass.hashCode() : 0;
        result = 31 * result ;
        return result;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(SeatClass seatClass) {
        this.seatClass = seatClass;
    }

}
