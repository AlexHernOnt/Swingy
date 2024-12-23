/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   TmlGame.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/12/01 18:08:49 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/23 18:46:13 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package View;

import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import View.MyFrame;
import Controller.GameController;
import Model.GameMap;
import Hero.Hero;
import Model.GameMap;

public class TmlGame {

	/*
    **	V A R I A B L E S
	*/
	
    private GameView view;
    private GameController controller;
    private MyFrame frame;
	private Scanner scanner;

	Hero hero;
	GameMap map;









    /*
    **  C O N S T R U C T O R 
    */
	
	public TmlGame(GameController controller, GameView view, Hero hero, GameMap map) {

		// Assign Constructor Variables

		this.view = view;
		this.controller = controller;
		this.hero = hero;
		this.map = map;

		scanner = new Scanner(System.in);
	}










    /*
    **  W E L C O M E     S C R E E N
    */
    
    public void welcomeScreen() {

		cleanScreen();

		System.out.println("Your name is: " + controller.getHero().getName() + ", a true " + controller.getHero().getClassType() + ".");
		System.out.println("You come out of your house looking for an adventure!");
	
		String userInput;
		
		do {

			System.out.println("Choose an option:\n- Start");
			userInput = scanner.nextLine().trim();
	
			cleanScreen();
	
			if (userInput.equalsIgnoreCase("gui")) {
				view.GUI = true;
				view.GuiG.welcomeScreen();
				break;
			} else if (userInput.equalsIgnoreCase("start")) {
				walk();
				break;
			}
		} while (true);
	}











    /*
    **  W A L K
    */

    public void walk() {

		cleanScreen();
		System.out.println("You are at X " + (hero.getPosX() + 1) + " / " + (map.getSize() + 1) + ". And Y " + (hero.getPosY() + 1) + " / " + (map.getSize() + 1) + ".");
	
		String userInput;
		
		do {

			System.out.println("Which direction will you walk?:\n- North\n- East\n- South\n- West");
			userInput = scanner.nextLine().trim();
	
			cleanScreen();
	
			if (userInput.equalsIgnoreCase("gui")) {
				view.GUI = true;
				view.GuiG.walk();
				break;
			} else if (userInput.equalsIgnoreCase("North")) {
				hero.goNorth();
				view.getController().positionCheck();
				break;
			} else if (userInput.equalsIgnoreCase("East")) {
				hero.goEast();
				view.getController().positionCheck();
				break;
			} else if (userInput.equalsIgnoreCase("South")) {
				hero.goSouth();
				view.getController().positionCheck();
				break;
			} else if (userInput.equalsIgnoreCase("West")) {
				hero.goWest();
				view.getController().positionCheck();
				break;
			}
		} while (true);
	}










    /*
    **  C O N F R O N T A T I O N
    */

	public void confrontation() {

		cleanScreen();
		System.out.println("You face a terrible lvl " + map.enemy(hero.getPosY(), hero.getPosX()) + " creature before you.");
		
		String userInput;
		do {

			System.out.println("Do you want to fight it? (You're level) " + hero.getLevel() + ":\n- Yes\n- No");
			userInput = scanner.nextLine().trim();
	
			cleanScreen();
	
			if (userInput.equalsIgnoreCase("gui")) {
				view.GUI = true;
				view.GuiG.walk();
				break;
			} else if (userInput.equalsIgnoreCase("Yes")) {
				break;
			} else if (userInput.equalsIgnoreCase("No")) {
				break;
			}
		} while (true);
	}










    /*
    **  F I G H T
    */

	public void fight() {

		// Text Prompt for name

		// JLabel labelOnToprint = new JLabel("Your name is: " + controller.getHero().getName() + ", a true " + controller.getHero().getClass() + ".");
		// JLabel labelOnToprint2 = new JLabel("Welcome to the world, you come out of your house looking for an adventure!.");
	}

	public void looting() {

		// Text Prompt for name

		// JLabel labelOnToprint = new JLabel("Your name is: " + controller.getHero().getName() + ", a true " + controller.getHero().getClass() + ".");
		// JLabel labelOnToprint2 = new JLabel("Welcome to the world, you come out of your house looking for an adventure!.");
	}

    public void win() {

		// Text Prompt for name

		// JLabel labelOnToprint = new JLabel("Your name is: " + controller.getHero().getName() + ", a true " + controller.getHero().getClass() + ".");
		// JLabel labelOnToprint2 = new JLabel("Welcome to the world, you come out of your house looking for an adventure!.");
	}









	/*
	**  Utils
	*/

	public void closeWindows() 	{
		view.GuiG.closeWindow();
	}
	
	public void cleanScreen() {
		int i = 0;

		while (i < 100) {
			System.out.println("\n");
			++i;
		}
	}
}
