package com.ford.ch.mobileseat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BOOKING_INFO")
public class BookingInfo implements Serializable
{
	@Id
	@Column(name = "bookingid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;

	@Column(name = "date")
	@NotNull
	private String date;

	@Column(name = "starttime")
	@NotNull
	private String startTime;

	@Column(name = "endtime")
	@NotNull
	private String endTime;

	@JoinColumn(name = "cdsid")
	@Column(name = "cdsid")
	@NotNull
	private String cdsId;

	@Column(name = "seatid")
	@NotNull
	private String seatId;

	@Column(name = "is_active")
	@NotNull
	private Boolean isActive;

	/*@OneToMany
	@JoinTable(name = "Transaction", joinColumns = @JoinColumn(name = "bookingid"))
	private List<Transaction> txns;*/

}
