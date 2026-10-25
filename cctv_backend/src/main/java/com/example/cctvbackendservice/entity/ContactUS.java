package com.example.cctvbackendservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactUS {

	@JsonProperty("name")
	public String name;

	@JsonProperty("mobile_number")
	public String mobileNumber;

	@JsonProperty("message")
	public String message;

}
