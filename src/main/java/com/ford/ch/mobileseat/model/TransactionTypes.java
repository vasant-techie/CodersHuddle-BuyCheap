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
@Table(name = "TRANSACTIONTYPES")
public class TransactionTypes implements Serializable
{
	@Id
	@Column(name = "transtypeid")
	private Integer transTypeId;

	@Column(name = "transtypename")
	@NotNull
	private String transTypeName;

}
