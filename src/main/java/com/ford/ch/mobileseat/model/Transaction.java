package com.ford.ch.mobileseat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TRANSACTIONS")
public class Transaction implements Serializable
{
	@Id
	@Column(name = "transid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String transId;

	@JoinColumn(name = "transtypeid")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private TransactionTypes transType;

	@Column(name = "transtime")
	@NotNull
	private Instant transTime;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "bookingid", referencedColumnName = "bookingid", nullable = false)
	private BookingInfo bookingInfo;
}
