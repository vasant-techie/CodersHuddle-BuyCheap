package com.ford.ch.buycheap.controller;

import com.ford.ch.buycheap.constants.TransType;
import com.ford.ch.buycheap.model.BookingInfo;
import com.ford.ch.buycheap.model.UserPreferences;
import com.ford.ch.buycheap.model.TransactionTypes;
import com.ford.ch.buycheap.service.BookingService;
import com.ford.ch.buycheap.service.TransactionService;
import com.ford.ch.buycheap.service.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;


@Validated
@RestController
@RequestMapping("/api/v1/booking")
public class TransactionController
{

	@Autowired
	private BookingService bookingMainService;
	@Autowired
	private TransactionService transactionMainService;
	@Autowired
	private TransactionTypeService transactionTypeMainService;

	@PostMapping
	public BookingInfo createBooking( @RequestBody @Valid  BookingInfo bookingInfo )
	{
		BookingInfo persistedBookingData = bookingMainService.add(bookingInfo);

		//Add an entry into Transaction table
		UserPreferences transaction = new UserPreferences();
		TransactionTypes transType = transactionTypeMainService.getById(TransType.NEW_BOOKING.transTypeId);
		transaction.setTransType(transType);
		transaction.setTransTime(Instant.now());
		transaction.setBookingInfo(persistedBookingData);
		transactionMainService.add(transaction);

		return persistedBookingData;
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public BookingInfo getBookingById(
			@PathVariable(value = "id") Integer bookingId )
	{
		return bookingMainService.getById(bookingId);
	}


	@GetMapping(value = "/{startTime}/{endTime}", produces = "application/json")
	public BookingInfo getBookingInfoForTimeline(String givenStartTime, String givenEndTime)
	{
		//return bookingMainService.getById(bookingId);
		return null;
	}


	/*@DeleteMapping(value = "/{id}")
	public ResponseWrapper<BookingInfo> cancelBooking(
			@Valid @PathVariable(value = "id") String bookingId )
	{
		return new ResponseWrapper<>( bookingMainService.cancelBookingById( bookingId ), HttpStatus.OK );
	}

	@PatchMapping(value = "/{id}")
	public ResponseWrapper<BookingInfo> updateBooking( @Valid @RequestBody User user,
			@Valid @PathVariable(value = "id") String cdsid )
	{
		return new ResponseWrapper<>( bookingMainService.updateBooking( user, cdsid), HttpStatus.OK );
	}*/

}
