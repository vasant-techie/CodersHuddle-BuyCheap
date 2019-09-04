package com.ford.ch.mobileseat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LOCATION")
public class Location implements Serializable
{
	@Id
	@Column(name = "seatid")
	private String seatId;

	@Column(name = "floornum")
	@NotNull
	private String floorNum;

	@Column(name = "buildingid")
	@NotNull
	private String buildingId;
}
