package com.ust.app.customerapp.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Entity
//@Table(name = "customerData") // optional annotation,sets a name for a database table
public class Customer {
	@Id
	private int id;
	@Column(name = "customer_name", length = 50, nullable = false) //optional
	private String name;
	@Column(unique = true)
	private String email;
	@JsonProperty("birthDate")
	private LocalDate dob;
	
	@Enumerated(EnumType.STRING)
	private UserType type;
	
//	@ElementCollection
//	private List<String> address;
//	@OneToOne(cascade = CascadeType.ALL)
//	private Address address;
//	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)//,fetch = FetchType.EAGER
	private List<Address> address;

}
