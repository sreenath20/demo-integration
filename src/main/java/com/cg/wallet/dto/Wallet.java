package com.cg.wallet.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity

public class Wallet {

	@Id
	@GeneratedValue

	private Integer id;

	@NotEmpty(message = "Customer Name is Mandatory.")
	@Column(name = "Customer_name", length = 25)
	@Size(min = 3, max = 25, message = "Length should be min3 and max 25 characters.")
	@Pattern(regexp = "([A-Za-z]+)|([A-Za-z]+[ ][A-Za-z]+)", message = "Only Alphabets and space is allowed.")
	private String name;

	@NotNull(message = "Balance is Mandatory")
	@Min(value = 1000, message = "Opening Amount should be Rs 1000.")
	private Double balance;
	// @Transient

	public Wallet() {
		super();
	}

	public Wallet(Integer id, String name, Double balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Wallet [id=" + id + ", name=" + name + ", balance=" + balance;
	}

}
