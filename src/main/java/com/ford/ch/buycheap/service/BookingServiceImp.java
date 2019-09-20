package com.ford.ch.buycheap.service;

import com.ford.ch.buycheap.constants.ApiConstants;
import com.ford.ch.buycheap.exception.ResourceNotFoundException;
import com.ford.ch.buycheap.model.BookingInfo;
import com.ford.ch.buycheap.repository.BookingInfoRepository;
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

	public BookingInfo add(BookingInfo bookingInfo)
	{

		//Check whether the user already has a booking in his id
		boolean isBookingFound = isAlreadyBookedForDay(bookingInfo.getDate(), bookingInfo.getCdsId());
		if(isBookingFound)
			throw new ResourceNotFoundException(ApiConstants.MESSAGE_FOR_ONE_BOOKING_PER_DAY);

		//Check whether the chosen Seat for new booking is already booked
		BookingInfo bookingInfoHist = getSeatBookingInfo(bookingInfo.getDate(), bookingInfo.getSeatId(), bookingInfo.getStartTime(), bookingInfo.getEndTime());
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


	private BookingInfo getSeatBookingInfo(String date, String seatId, String givenStartTime, String givenEndTime) {
		List<BookingInfo> seatBookHist = bookingRepository.findByDateAndSeatIdAndIsActive(date, seatId, true);

		if (seatBookHist.size() == 0)
			return null;
		else
			return seatBookHist.get(0);

		/*for (BookingInfo existingBookingInfo : seatBookHist) {
			String existingStartTime = existingBookingInfo.getStartTime();
			String existingEndTime = existingBookingInfo.getEndTime();

			LocalTime givenStartLocalTime = LocalTime.parse(givenStartTime, DateTimeFormatter.ofPattern("HH:mm:ss"));
			LocalTime givenEndLocalTime = LocalTime.parse(givenEndTime, DateTimeFormatter.ofPattern("HH:mm:ss"));
			LocalTime existStartLocalTime = LocalTime.parse(existingStartTime, DateTimeFormatter.ofPattern("HH:mm:ss"));
			LocalTime existEndLocalTime = LocalTime.parse(existingEndTime, DateTimeFormatter.ofPattern("HH:mm:ss"));

			if (
					((givenStartLocalTime.compareTo(existStartLocalTime) < 0 && givenStartLocalTime.compareTo(existEndLocalTime) > 0)
							&& givenEndLocalTime.compareTo(existStartLocalTime) < 0)
							||
							((givenEndLocalTime.compareTo(existStartLocalTime) < 0 && givenEndLocalTime.compareTo(existEndLocalTime) > 0)
									&& givenStartLocalTime.compareTo(existEndLocalTime) < 0)
			) {
				return existingBookingInfo;
			}
		}*/

	}

}
