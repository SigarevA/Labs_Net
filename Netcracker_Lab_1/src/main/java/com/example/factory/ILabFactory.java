package com.example.factory;

import com.example.entities.IDivision;
import com.example.entities.IPerson;
import com.example.repository.IPersonRepository;
import com.example.repository.IRepository;

public interface ILabFactory {

	/**
	 * Create {@link IPerson} entity
	 * 
	 * @return {@link IPerson} entity
	 */ 
	//Use a simple code like return new Person()
	IPerson createPerson();

	/**
	 * @return {@link IDivision} entity
	 */
	//Use a simple code like return new Division()
	IDivision createDivision();

	// If you don't know how to work with generic then skip it and work with
	// createPersonRepository() method
	default <T> IRepository<T> createRepository(Class<T> clazz) {
		return null;
	}
	
	//Currently use a simple code like return new PersonRepository()
	IPersonRepository createPersonRepository();

}
