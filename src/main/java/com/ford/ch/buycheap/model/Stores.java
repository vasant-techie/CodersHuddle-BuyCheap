package com.ford.ch.buycheap.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "STORES")
public class Stores implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer storeId;

	@Column(name = "store_name")
	@NotNull
	private String storeName;

	@Column(name = "city")
	@NotNull
	private String city;

	@Column(name = "area")
	@NotNull
	private String area;

	@Column(name = "distance_from_landmark")
	@NotNull
	private String distanceFrom;

	@Column(name = "zip_code")
	@NotNull
	private String zipCode;

	@Column(name = "phone_number")
	@NotNull
	private String phoneNumber;

	@Column(name = "street_name")
	@NotNull
	private String streetName;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "outlet_id", referencedColumnName = "outlet_id", nullable = false)
	private Outlet outlet;

	@Column(name = "discount_percentage")
	@NotNull
	private String discountPercentage;

	@Column(name = "coupon_code")
	@NotNull
	private String couponCode;
}
