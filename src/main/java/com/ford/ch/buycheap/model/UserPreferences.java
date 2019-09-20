package com.ford.ch.buycheap.model;

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
@Table(name = "USER_PREFERENCES")
public class UserPreferences implements Serializable
{
	/*@Id
	@Column(name = "username")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String transId;*/

	@JoinColumn(name = "username")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private User user;

	@Column(name = "radius")
	@NotNull
	private Integer radius;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "outlet_id", referencedColumnName = "outlet_id", nullable = false)
	private Outlet outlet;


}
