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
@Table(name = "USERS")
public class User implements Serializable
{
	@Id
	@Column(name = "username")
	private String username;

	@Column(name = "name")
	@NotNull
	private String name;

	@Column(name = "password")
	@NotNull
	private String password;

	@Column(name = "city")
	@NotNull
	private String city;

	@Column(name = "area")
	@NotNull
	private String area;

	@Column(name = "zip_code")
	@NotNull
	private String zipCode;
}
