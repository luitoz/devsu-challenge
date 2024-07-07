package com.customerservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "customerId")
public class Customer extends Person {
    @Column(name="password")
    private String password;
    @Column(name="state")
    private Boolean state;

    public Customer(long id, String name, Gender gender, Integer age, String address, String phoneNumber, String password, Boolean state) {
        super(id, name, gender, age, address, phoneNumber);
        this.password = password;
        this.state = state;
    }

    public Customer() {}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}
    
    
}
