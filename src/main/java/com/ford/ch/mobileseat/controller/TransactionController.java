package com.ford.ch.mobileseat.controller;

import com.ford.ch.mobileseat.model.BookingInfo;
import com.ford.ch.mobileseat.model.User;
import com.ford.ch.mobileseat.results.ResponseWrapper;
import com.ford.ch.mobileseat.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Validated
@RestController
@RequestMapping("/api/v1/booking")
public class TransactionController
{

	@Autowired
	private BookingService bookingMainService;

	@PostMapping
	public ResponseWrapper<BookingInfo> createBooking( @RequestBody @Valid  BookingInfo bookingInfo )
	{
		return new ResponseWrapper<>( bookingMainService.add( bookingInfo ), HttpStatus.OK );
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
