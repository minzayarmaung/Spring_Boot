package com.zayar.practice.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "web_order")
public class WebOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id", nullable = false )
	private Long id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id" , nullable = false)
	private LocalUser user;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "address_id", nullable = false)
	private Address address;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<WebOrderQuantities> quantities = new ArrayList<>();

	
	public List<WebOrderQuantities> getQuantities() {
		return quantities;
	}

	public void setQuantities(List<WebOrderQuantities> quantities) {
		this.quantities = quantities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalUser getUser() {
		return user;
	}

	public void setUser(LocalUser user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	
}
