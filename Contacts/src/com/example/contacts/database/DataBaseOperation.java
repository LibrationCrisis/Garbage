package com.example.contacts.database;

import java.util.List;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import com.example.contacts.domain.Contacts;

public class DataBaseOperation {

	public void insert(Contacts contacts) {
		contacts.save();
	}

	public void update(Contacts contacts, Integer id) {
		contacts.update(id);
	}

	public void remove(Class<Contacts> modelClass, Long id) {
		LitePal.delete(modelClass, id);
	}

	public Contacts select(Class<Contacts> modelClass, Long id) {
		Contacts find = LitePal.find(modelClass, id);
		return find;
	}

	public List<Contacts> listAll(Class<Contacts> modelClass) {
		List<Contacts> list = LitePal.findAll(modelClass);
		return list;

	}
}
