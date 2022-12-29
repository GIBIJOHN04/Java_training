package com.example.UserDetails.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="UserDetails")
public class User {

	@Id
	@GeneratedValue
	private int id;
	@NotBlank(message = "Name is mandatory")
	private String Name;
	@NotBlank(message = "Address is mandatory")
	private String Address;
	@NotBlank(message = "Field is mandatory")
	private String Field;
	@NotBlank(message = "Description is mandatory")
	private String Description;
	@NotBlank(message = "Hour is mandatory")
	private int hours;
	@NotBlank(message = "Cost is mandatory")
	private int cost;
	@NotBlank(message = "Phone number is mandatory")
	@Size(min=0,max=10)
	private long phone;
	
	
	public User(int id, String name, String address, String field, String description, int hours, int cost,long phone) {
	
		this.id = id;
		this.Name = name;
		this.Address = address;
		this.Field = field;
		this.Description = description;
		this.hours = hours;
		this.cost = cost;
		this.phone = phone;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getField() {
		return Field;
	}
	public void setField(String field) {
		Field = field;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}

}
