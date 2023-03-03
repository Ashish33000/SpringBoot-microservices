package com.masai.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="micro_users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@Column(name="ID")	
	private String userId;
	private String name;
	private String email;
	private String about;
	@Transient
	private List<Rating> ratings=new ArrayList<>();

}
