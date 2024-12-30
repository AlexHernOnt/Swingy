/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   View.java                                          :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/03 17:46:02 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/30 18:16:09 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package View;

import Controller.Controller;
import Controller.States;
import Hero.Hero;
import Model.SQLutils;
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
	private SQLutils sql = new SQLutils();










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
		} else {

			cleanScreen();

			System.out.println("Choose a save file:");
			String userInput;
			
			do {

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
					break;
				}
				else if (userInput.equalsIgnoreCase("1"))
				{
					if (sql.getNameFromSave(1) != null)
					{
						controller.saveHero(sql.createHeroObjFromEntry(1));
						controller.goToGame();
						break;
					}
					else
					{
						System.out.println("(1): Empty Save File.");
					}
				}
				else if (userInput.equalsIgnoreCase("2"))
				{
					if (sql.getNameFromSave(2) != null) {
						controller.saveHero(sql.createHeroObjFromEntry(2));
						controller.goToGame();
						break;
					}
					else
					{
						System.out.println("(2): Empty Save File.");
					}
				}
				else if (userInput.equalsIgnoreCase("3"))
				{
					if (sql.getNameFromSave(3) != null)
					{
						controller.saveHero(sql.createHeroObjFromEntry(3));
						controller.goToGame();
						break;
					}
					else
					{
						System.out.println("(3): Empty Save File.");
					}
				} else if (userInput.equalsIgnoreCase("Back")) {
					controller.startGame();
					break;
				}
			} while (true);
		}
	}










	/*
	**  Select Hero And Present Game
	*/

    public void startGame() {
		
		System.err.println("At start game  in CRETE: Active:" + getActive() + ". And GUI: " +  GUI + ".");

		if (GUI) {
			Gui.startGame();
		} else {

			cleanScreen();

			System.out.println("Welcome to Swingy!");
			String userInput;
			
			do {

				System.out.println("Choose an option:\n- Continue\n- New Game");
				userInput = scanner.nextLine().trim();
		
				cleanScreen();
		
				if (userInput.equalsIgnoreCase("gui")) {
					GUI = true;
					controller.startGame();
					break;
				} else if (userInput.equalsIgnoreCase("Continue")) {
					controller.loadSave();
					break;
				} else if (userInput.equalsIgnoreCase("New Game")) {
					controller.setHeroName();
					break;
				}
			} while (true);
		}
	}








	/*
	**  Name
	*/
	
	public String heroName;

	public void viewSetHeroName() {

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
				controller.setHeroClass();
			}
		}
	}

	private boolean nameOK(String str) {

		cleanScreen();
		
		switch (str) {
			case "gui":
			{
				GUI = true;
				controller.setHeroName();
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
			controller.setHeroClass();
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
