package com.ford.ch.mobileseat.service;

import com.ford.ch.mobileseat.constants.ApiConstants;
import com.ford.ch.mobileseat.exception.ResourceNotFoundException;
import com.ford.ch.mobileseat.model.BookingInfo;
import com.ford.ch.mobileseat.repository.BookingInfoRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

	public BookingInfo add(BookingInfo bookingInfo)
	{
		boolean isBookingFound = isAlreadyBookedForDay(bookingInfo.getDate(), bookingInfo.getCdsId());

		//Check whether the user already has a booking in his id
		if(isBookingFound)
			throw new ResourceNotFoundException(ApiConstants.MESSAGE_FOR_ONE_BOOKING_PER_DAY);

		//Check whether the chosen Seat for new booking is already booked
		BookingInfo bookingInfoHist = getSeatBookingInfo(bookingInfo.getDate(), bookingInfo.getSeatId());
		if(null != bookingInfoHist)
			throw new ResourceNotFoundException(ApiConstants.MESSAGE_FOR_SEAT_ALREADY_BOOKED + bookingInfoHist.getCdsId());

		return bookingRepository.save(bookingInfo);


	}

	public BookingInfo update( BookingInfo bookingInfoUpdate, Integer bookingId )
	{
		BookingInfo bookingInfo = checkIfIdIsPresentandReturnBooking( bookingId );
		bookingInfo.setSeatId(bookingInfoUpdate.getSeatId());
		return bookingRepository.save(bookingInfo);
	}

	public BookingInfo getById(Integer bookingId)
	{
		return checkIfIdIsPresentandReturnBooking(bookingId);
	}

	private BookingInfo checkIfIdIsPresentandReturnBooking(Integer bookingId)
	{
		if ( !bookingRepository.findById(bookingId).isPresent() )
			throw new ResourceNotFoundException( " Booking id = " + bookingId + " not found" );
		else
			return bookingRepository.findById(bookingId).get();
	}

	private boolean isAlreadyBookedForDay(String date, String cdsid)
	{
		if ( bookingRepository.findByDateAndCdsIdAndIsActive(date, cdsid, true).size() > 0)
			return true;
		else
			return false;
	}


	private BookingInfo getSeatBookingInfo(String date, String seatId) {
		List<BookingInfo> seatBookHist = bookingRepository.findByDateAndSeatIdAndIsActive(date, seatId, true);
		if(seatBookHist.size() > 0)
			return seatBookHist.get(0);
		else
			return null;
	}

}
