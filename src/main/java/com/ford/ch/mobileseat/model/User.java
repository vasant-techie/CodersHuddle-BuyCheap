package com.ford.ch.mobileseat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	private String cdsid;

	@Column(name = "name")
	@NotNull
	private String name;

	@Column(name = "password")
	@NotNull
	private String password;
}
