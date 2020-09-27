package com.zhangnx.tools.entity;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue
	private int id;
	@Column(name="user_name")
	private String userName;
	@Column(name="password")
	private String password;
	@Column(name="email")
	private String email;
	@Column(name="description")
	private String description;
	@Column(name="adress")
	private String address;

}
