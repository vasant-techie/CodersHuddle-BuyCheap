package com.ford.ch.mobileseat.controller;

import com.ford.ch.mobileseat.constants.TransType;
import com.ford.ch.mobileseat.model.BookingInfo;
import com.ford.ch.mobileseat.model.Transaction;
import com.ford.ch.mobileseat.model.TransactionTypes;
import com.ford.ch.mobileseat.model.User;
import com.ford.ch.mobileseat.results.ResponseWrapper;
import com.ford.ch.mobileseat.service.BookingService;
import com.ford.ch.mobileseat.service.TransactionService;
import com.ford.ch.mobileseat.service.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
		Transaction transaction = new Transaction();
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
