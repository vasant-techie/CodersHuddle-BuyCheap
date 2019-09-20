package com.ford.ch.buycheap.model;

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
@Table(name = "OUTLETS")
public class Outlet implements Serializable
{
	@Id
	@Column(name = "outlet_id")
	private String outletId;

	@Column(name = "outlet_name")
	@NotNull
	private String outletName;
}
