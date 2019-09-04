package com.ford.ch.mobileseat.service;

import com.ford.ch.mobileseat.exception.ResourceNotFoundException;
import com.ford.ch.mobileseat.model.BookingInfo;
import com.ford.ch.mobileseat.repository.BookingInfoRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@NoArgsConstructor
public class BookingServiceImp extends BookingService
{

	@Autowired
	private BookingInfoRepository bookingRepository;

	public List<BookingInfo> getAll()
	{
		return bookingRepository.findAll();
	}

	public BookingInfo add( BookingInfo bookingInfo )
	{
		return bookingRepository.save( bookingInfo );
	}

	public BookingInfo update( BookingInfo bookingInfoUpdate, Integer bookingId )
	{
		BookingInfo bookingInfo = checkIfIdIsPresentandReturnBooking( bookingId );
		bookingInfo.setSeatId(bookingInfoUpdate.getSeatId());
		return bookingRepository.save( bookingInfo );
	}

	public BookingInfo getById( Integer bookingId )
	{
		return checkIfIdIsPresentandReturnBooking(bookingId);
	}


	private BookingInfo checkIfIdIsPresentandReturnBooking( Integer bookingId )
	{
		if ( !bookingRepository.findById( bookingId ).isPresent() )
			throw new ResourceNotFoundException( " Booking id = " + bookingId + " not found" );
		else
			return bookingRepository.findById( bookingId ).get();
	}
}
