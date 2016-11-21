package com.rxp8385.designpatterns.singleton.controller;

import java.sql.SQLException;

import com.rxp8385.designpatterns.singleton.model.DAOFactory;
import com.rxp8385.designpatterns.singleton.model.Model;
import com.rxp8385.designpatterns.singleton.model.Person;
import com.rxp8385.designpatterns.singleton.model.PersonDAO;
import com.rxp8385.designpatterns.singleton.view.CreateUserEvent;
import com.rxp8385.designpatterns.singleton.view.CreateUserListener;
import com.rxp8385.designpatterns.singleton.view.View;

public class Controller implements CreateUserListener{
	private View view;
	private Model model;
	
	private PersonDAO personDAO = DAOFactory.getPersonDAO();
	
	public Controller (View view, Model model){
		this.view = view;
		this.model = model;
	}

	@Override
	public void userCreated(CreateUserEvent event) {
		System.out.println("Login event received: " + event.getName() + "; " + event.getPassword());
		
		try {
			personDAO.addPerson(new Person(event.getName(), event.getPassword()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}