package com.ford.ch.mobileseat.service;


import com.ford.ch.mobileseat.model.BookingInfo;
import com.ford.ch.mobileseat.model.User;


public abstract class BookingService implements MainService<User>
{
    public abstract BookingInfo add(BookingInfo bookingInfo);
    public abstract BookingInfo getById(Integer bookingId);
    //public abstract BookingInfo cancelBookingById(String bookingId);
    //public abstract BookingInfo updateBooking(BookingInfo bookingInfo, String cdsid);
    //public abstract List<User> getBooksById(int id );
}
