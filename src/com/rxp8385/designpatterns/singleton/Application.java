package com.rxp8385.designpatterns.singleton;

import javax.swing.SwingUtilities;

import com.rxp8385.designpatterns.singleton.controller.Controller;
import com.rxp8385.designpatterns.singleton.model.Model;
import com.rxp8385.designpatterns.singleton.view.View;

public class Application {
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable (){

			@Override
			public void run() {
				runApp();
				
			}

			
			
		});
		
	}
	
	public static void runApp() {
		Model model = new Model();
		View view = new View(model);
		
		Controller controller = new Controller(view, model);
		
		view.setLoginListener(controller);
		
	}

}
