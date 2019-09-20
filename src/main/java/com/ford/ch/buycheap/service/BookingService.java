package com.ford.ch.buycheap.service;


import com.ford.ch.buycheap.model.BookingInfo;
import com.ford.ch.buycheap.model.User;


public abstract class BookingService implements MainService<User>
{
    public abstract BookingInfo add(BookingInfo bookingInfo);
    public abstract BookingInfo getById(Integer bookingId);
    //public abstract BookingInfo cancelBookingById(String bookingId);
    //public abstract BookingInfo updateBooking(BookingInfo bookingInfo, String cdsid);
    //public abstract List<User> getBooksById(int id );
}
