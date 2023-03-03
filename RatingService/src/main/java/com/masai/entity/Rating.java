package com.masai.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rating {
	@Id
	private String ratingId;
	private String userId;
	private String hotelId;
	private String rating;
	private String feedback;

}
