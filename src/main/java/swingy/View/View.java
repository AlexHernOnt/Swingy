/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   View.java                                          :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/03 17:46:02 by ahernand          #+#    #+#             */
/*   Updated: 2025/01/03 19:02:24 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package View;

import Controller.Controller;
import Controller.States;
import Hero.Hero;
import Model.SQLutils;
import View.GuiCreateHero;
import java.util.Scanner;
import java.util.Set;

import View.MyFrame;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;

public class View {

	/*
	** Variables
	*/

	public Controller controller;
	private GuiCreateHero Gui;
	private Scanner scanner;
	protected boolean GUI = true;
	private SQLutils sql = new SQLutils();

	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();








	/*
	**	Methods
	*/

	public View(Controller controller, boolean GUI) {

		// Assign Constructor Variables

		this.controller = controller;
		this.GUI = GUI;

		// Initialize variables

		Gui = new GuiCreateHero(controller, this);
		scanner = new Scanner(System.in);
	}

	public View(Controller controller, boolean GUI, boolean active, MyFrame frame) {

		// Assign Constructor Variables

		this.controller = controller;
		this.GUI = GUI;

		// Initialize variables

		Gui = new GuiCreateHero(controller, this);
		Gui.setActive(active);
		if (frame != null)
			Gui.setFrame(frame);
		scanner = new Scanner(System.in);
	}











	/*
	**  Continue Game
	*/

	public void loadSave() {

		if (GUI) {
			Gui.loadSave();
		} else {

			cleanScreen();

			System.out.println("Choose a save file:");
			String userInput;

			if (sql.getNameFromSave(1) != null) {
				System.out.println("\n- 1: (" + sql.getNameFromSave(1) + " - " + "Level " + sql.getLevelFromSave(1) + " " + sql.getArtifactsPrintable(1) + ")");
			}
			else {
				System.out.println("\n- 1: Empty");
			}
			if (sql.getNameFromSave(2) != null) {
				System.out.println("- 2: (" + sql.getNameFromSave(2) + " - " + "Level " + sql.getLevelFromSave(2) + " " + sql.getArtifactsPrintable(1) + ")");
			}
			else {
				System.out.println("- 2: Empty");
			}
			if (sql.getNameFromSave(3) != null) {
				System.out.println("- 3: (" + sql.getNameFromSave(3) + " - " + "Level " + sql.getLevelFromSave(3) + " " + sql.getArtifactsPrintable(1) + ")");
			}
			else {
				System.out.println("- 3: Empty");
			}
			System.out.println("- Back.");

			userInput = scanner.nextLine().trim();
			
			if (userInput.equalsIgnoreCase("gui"))
			{
				GUI = true;
				controller.loadSave();
			}
			else if (userInput.equalsIgnoreCase("1"))
			{
				if (sql.getNameFromSave(1) != null)
				{
					controller.saveHero(sql.createHeroObjFromEntry(1));
					controller.goToGame();
				}
				else
				{
					System.out.println("(1): Empty Save File.");
					controller.loadSave();
				}
			}
			else if (userInput.equalsIgnoreCase("2"))
			{
				if (sql.getNameFromSave(2) != null) {
					controller.saveHero(sql.createHeroObjFromEntry(2));
					controller.goToGame();
				}
				else
				{
					controller.loadSave();
					System.out.println("(2): Empty Save File.");
				}
			}
			else if (userInput.equalsIgnoreCase("3"))
			{
				if (sql.getNameFromSave(3) != null)
				{
					controller.saveHero(sql.createHeroObjFromEntry(3));
					controller.goToGame();
				}
				else
				{
					controller.loadSave();
					System.out.println("(3): Empty Save File.");
				}
			} else if (userInput.equalsIgnoreCase("Back")) {
				controller.startGame();
			}
			else {
				controller.loadSave();
			}
		}
	}










	/*
	**  Select Hero And Present Game
	*/

    public void startGame() {
		
		if (GUI) {
			Gui.startGame();
		} else {

			cleanScreen();

			System.out.println("Welcome to Swingy!");
			String userInput;
		
			System.out.println("Choose an option:\n- Continue\n- New Game");
			userInput = scanner.nextLine().trim();
	
			cleanScreen();
	
			if (userInput.equalsIgnoreCase("gui")) {
				GUI = true;
				controller.startGame();
			} else if (userInput.equalsIgnoreCase("Continue")) {
				controller.loadSave();
			} else if (userInput.equalsIgnoreCase("New Game")) {
				controller.setHeroName();
			} else {
				controller.startGame();
			}
		}
	}








	/*
	**  Name
	*/
	
	public String heroName;
	
	public void setHeroName() {
		
		if (GUI) {
			Gui.setHeroName();
		} else {

			cleanScreen();

			System.out.println("Please, write your hero's name!");
			String userInput;
		
			userInput = scanner.nextLine().trim();
	
			cleanScreen();
	
			if (userInput.equalsIgnoreCase("gui")) {
				GUI = true;
				controller.setHeroName();
			} else if (userInput.equalsIgnoreCase("")) {
				controller.setHeroName();
			} else {
				Hero dummy = new Hero("Warrior", userInput);

				// Validate the Hero object
				Set<ConstraintViolation<Hero>> violations = validator.validate(dummy);

				// Handle validation results
				if (!violations.isEmpty()) {
					for (ConstraintViolation<Hero> violation : violations) {
						System.out.println("Validation error: " + violation.getMessage());
					}
					controller.setHeroName();
				} else {
					heroName = userInput;
					System.out.println("The hero's name is '" + heroName + "'");
					controller.setHeroClass();
				}
			}
		}
	}










	/*
	**  C L A S S
	*/

	public String heroClass;
	
	public void setHeroClass() {

		if (GUI) {
			Gui.setHeroClass();
		} else {
			cleanScreen();
	
			System.out.println("Choose a class: \n- Warrior\n- Wizard\n- Knight\n- Archer");
			String userInput = scanner.nextLine().trim();
	
			cleanScreen();
	
			if (userInput.equalsIgnoreCase("gui")) {
				GUI = true;
				controller.setHeroClass();
			} else if (userInput.equalsIgnoreCase("Warrior") || userInput.equalsIgnoreCase("Wizard") || 
					   userInput.equalsIgnoreCase("Knight") || userInput.equalsIgnoreCase("Archer")) {
				heroClass = userInput;
				System.out.println("The hero's class is '" + heroClass + "'");
				printClass();
			} else {
				System.out.println("Please, input a valid class name.");
				controller.setHeroClass();
			}
		}
	}






	/*
	** Print and end
	*/

	private void printClass() {
		cleanScreen();
		controller.goToGame();
	}











	/*
	**  Utils
	*/

	public void closeWindows() 	{
		Gui.closeWindow();
	}
	
	public void cleanScreen() {
		int i = 0;

		while (i < 100) {
			System.out.println("\n");
			++i;
		}
	}









	/*
	**  Getters
	*/

	public boolean getGUIOnOff() {
		return GUI;
	}

	public MyFrame getFrame() {
		return Gui.getFrame();
	}
	
	public boolean getActive() {
		return Gui.getActive();
	}









	/*
	**  Setters
	*/

	public void setGUI(boolean GUI) {
		this.GUI = GUI;
	}

	public void setActive(boolean active) {
		Gui.setActive(active);
	}
}
