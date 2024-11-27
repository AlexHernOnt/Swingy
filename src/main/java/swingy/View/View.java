/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   View.java                                          :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/03 17:46:02 by ahernand          #+#    #+#             */
/*   Updated: 2024/11/27 20:38:07 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package View;

import Controller.Controller;
import Controller.States;
import Hero.Hero;
import View.ViewCreateHero;
import java.util.Scanner;


public class View {

	/*
	** Variables
	*/

	public ViewCreateHero VCHero;
	public Controller controller;

	private Scanner scanner = new Scanner(System.in);

	public boolean GUI = true;






	


	/*
	** Methods
	*/

	public View(Controller pController, boolean pGUI) {

		// Assign Constructor Variables

		controller = pController;
		GUI = pGUI;

		// Initialize variables

		VCHero = new ViewCreateHero(pController, this);
	}

	public void cleanScreen() {
		int i = 0;

		while (i < 8) { //100) {
			System.err.println("\n");
			++i;
		}
	}










	/*
	**  Select Hero And Present Game
	*/
	public void showPresentation() {

		String str;

		if (GUI) {
			VCHero.GUIpromptForSelectHero();
		}
		else {
			printPresenteAndSelectHero();

			do {
				str = promptForSelectHero();
			} while (!selectHeroOk(str));
		}
	}

	public void printPresenteAndSelectHero() {
		cleanScreen();
		System.err.println("Welcome to The Brighest Night");
	}

	private boolean selectHeroOk(String str) {
		cleanScreen();
		switch (str) {
			case "GUI":
				GUI = true;
				VCHero.GUIpromptForSelectHero();
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
		System.err.println("Choose an option:\n- Continue\n- New Game");
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
			VCHero.GUIpromptForName();
		}
		else {

			// Prompt for hero name until a valid one is provided
	
			do {
				heroName = promptForName();
			} while (!nameOK(heroName));
			printName(heroName);
			viewSetHeroClass();
		}
	}

	private boolean nameOK(String str) {
		if (str.isEmpty()) {
			printErrorName();
			return (false);
		}
		else if (str.equals("GUI")) {
			GUI = true;
		}
		return true;
	}

	public String promptForName() {
		System.out.println("Write your hero's name:");
		String str = scanner.nextLine();
		return str;
	}

	public void printName(String str) {
		cleanScreen();
		if (!str.equals("GUI"))
			System.out.println("The hero's name is '" + str + "'");
	}

	public void printErrorName() {
		cleanScreen();
		System.out.println("Please, input a name.");
	}










	/*
	**  C L A S S
	*/

	public String heroClass;

	public void	viewSetHeroClass() {

		controller.currentState = States.SETHEROCLASS;

		// Prompt for hero class until a valid one is provided

		if (GUI) {
			VCHero.GUIpromptForClass();
		}
		else
		{
			do {
				heroClass = promptForClass();
			} while (!classOk(heroClass));
			printClass(heroClass);

			// Create new hero in the model

			printHeroData(controller.createHeroController(heroClass, heroName));
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
		else if (!str.isEmpty()) {
			printErrorClass();
		}
		cleanScreen();
		return (false);
	}

	private void printClass(String str) {
		cleanScreen();
		System.out.println("The hero's class is '" + str + "'");
	}

	private void printErrorClass() {
		cleanScreen();
		System.out.println("Please, input a valid class name.");
	}










	/*
	**  Show Info
	*/

	public void printHeroData(Hero h) {
		cleanScreen();
		System.out.println("Here's your hero's stats: \n");
		System.out.println(h);
	}

}
