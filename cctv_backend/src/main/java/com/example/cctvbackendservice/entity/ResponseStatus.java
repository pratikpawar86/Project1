


package com.example.cctvbackendservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStatus {

	@JsonProperty("status")
	public boolean status;
	
	@JsonProperty("message")
	public String message;

}
