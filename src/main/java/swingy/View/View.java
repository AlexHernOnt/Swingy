/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   View.java                                          :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/03 17:46:02 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/23 17:39:46 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package View;

import Controller.Controller;
import Controller.States;
import Hero.Hero;
import View.GuiCreateHero;
import java.util.Scanner;


public class View {

	/*
	** Variables
	*/

	public Controller controller;
	private GuiCreateHero Gui;
	private Scanner scanner;
	protected boolean GUI = true;










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












	/*
	**  Continue Game
	*/

	public void loadSave() {

		if (GUI) {
			Gui.loadSave();
		}
	}










	/*
	**  Select Hero And Present Game
	*/

	public void startGame() {

		String str;

		if (GUI) {
			Gui.startGame();
		}
		else {
			cleanScreen();
			System.out.println("Welcome to Swingy");

			do {
				str = promptForSelectHero();
			} while (!selectHeroOk(str));
		}
	}

	private boolean selectHeroOk(String str) {
		cleanScreen();
		switch (str) {
			case "gui":
				GUI = true;
				Gui.startGame();
				return true;
			case "Continue":
				viewSetHeroName();
				return true;
			case "New Game":
				viewSetHeroName();
				return true;
			default:
				return false;
		}
	}

	public String promptForSelectHero() {
		System.out.println("Choose an option:\n- Continue\n- New Game");
		String str = scanner.nextLine();
		return str;
	}











	/*
	**  Name
	*/
	
	public String heroName;

	public void viewSetHeroName() {

		controller.currentState = States.SETHERONAME;

		if (GUI) {
			Gui.SetHeroName();
		}
		else {

			// Prompt for hero name until a valid one is provided
	
			do {
				heroName = promptForName();
			} while (!nameOK(heroName));

			// Print for name

			cleanScreen();
			if (!heroName.equals("gui")) {
				System.out.println("The hero's name is '" + heroName + "'");
				viewSetHeroClass();
			}
		}
	}

	private boolean nameOK(String str) {
		cleanScreen();
		switch (str) {
			case "gui":
			{
				GUI = true;
				Gui.SetHeroName();
				return true;
			}
			case "":
			{
				cleanScreen();
				System.out.println("Please, input a name.");
				return false;
			}
			default:
				return true;
		}
	}

	public String promptForName() {
		System.out.println("Write your hero's name:");
		String str = scanner.nextLine();
		return str;
	}










	/*
	**  C L A S S
	*/

	public String heroClass;

	public void	viewSetHeroClass() {

		controller.currentState = States.SETHEROCLASS;

		// Prompt for hero class until a valid one is provided

		if (GUI) {
			Gui.SetHeroClass();
		}
		else
		{
			do {
				heroClass = promptForClass();
			} while (!classOk(heroClass));
			printClass(heroClass);
		}
	}

	private String promptForClass() {

		System.out.println("Choose a class: \n- Warrior\n- Wizard\n- Knight\n- Archer");
		String str = scanner.nextLine();
		return str;
	}

	private boolean classOk(String str) {
		if (str.equals("Warrior") || str.equals("Wizard") || str.equals("Knight") || str.equals("Archer")) {
			return true;
		}
		else if (str.equals("gui")) {
			GUI = true;
			Gui.SetHeroClass();
			return true;
		}
		else if (!str.isEmpty()) {
			cleanScreen();
			System.out.println("Please, input a valid class name.");
		}
		cleanScreen();
		return (false);
	}







	/*
	** Print and end
	*/

	private void printClass(String str) {
		cleanScreen();
		if (!str.equals("gui")) {
			cleanScreen();
			System.out.println("Here's your hero's stats: \n");
			System.out.println(controller.createHeroController(heroClass, heroName));
			controller.goToGame();
		}
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
}
