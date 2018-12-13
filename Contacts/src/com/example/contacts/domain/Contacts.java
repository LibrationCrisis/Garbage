package com.example.contacts.domain;

import org.litepal.crud.LitePalSupport;

public class Contacts extends LitePalSupport {
	private Integer id;
	private String name;
	private Integer phone;

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

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Contacts [id=" + id + ", name=" + name + ", phone=" + phone
				+ "]";
	}

}
