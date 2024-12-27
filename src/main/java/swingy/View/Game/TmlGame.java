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
import Hero.Artifact;
import java.util.Random;
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
			} else if (userInput.equalsIgnoreCase("start")) {
				walk();
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
			} else if (userInput.equalsIgnoreCase("North")) {
				hero.goNorth();
				view.getController().positionCheck();
			} else if (userInput.equalsIgnoreCase("East")) {
				hero.goEast();
				view.getController().positionCheck();
			} else if (userInput.equalsIgnoreCase("South")) {
				hero.goSouth();
				view.getController().positionCheck();
			} else if (userInput.equalsIgnoreCase("West")) {
				hero.goWest();
				view.getController().positionCheck();
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
				view.GuiG.confrontation();
			} else if (userInput.equalsIgnoreCase("Yes")) {
				controller.fight();
			} else if (userInput.equalsIgnoreCase("No")) {
				controller.runChancesResolve();
			}
		} while (true);
	}











    /*
    **  F I G H T
    */
	
    public void fight() {

		cleanScreen();

		String userInput;

		if (controller.fightAlgo() == true) {
		
			System.out.println("Victory! Current XP " + hero.getExperience() + " / " + hero.formulaLevelUp() + "." );
			System.out.println("You see your foe's desecreated body: \n- Loot it");
			userInput = scanner.nextLine().trim();

			cleanScreen();
			if (userInput.equalsIgnoreCase("gui")) {
				view.GUI = true;
				view.GuiG.fight();
			} else if (userInput.equalsIgnoreCase("Loot it")) {
				controller.looting();
			}
		} else {

			System.out.println("You gave all you had in the fight, however you failed");
			System.out.println("You know this is the last second of your life: \n -Bye");
			userInput = scanner.nextLine().trim();
			
			cleanScreen();
			if (userInput.equalsIgnoreCase("gui")) {
				view.GUI = true;
				view.GuiG.fight();
			} else if (userInput.equalsIgnoreCase("Bye")) {
				controller.goStart();
			}
		}
	}

	Random rand = new Random();

	public void looting() {

		int rnd = rand.nextInt(3);
			
		int statChanged = (hero.getLevel() - (hero.getLevel() - map.enemy(hero.getPosY(), hero.getPosX()))) + 1;
		statChanged = statChanged < 1 ? 1 : statChanged;

		cleanScreen();

		String userInput;

		rnd = rand.nextInt(3);
		if (rnd == 1) { // 30 % 
		
			System.out.println("You only found blood and skin: \n-Move on");

			userInput = scanner.nextLine().trim();

			cleanScreen();
			if (userInput.equalsIgnoreCase("gui")) {
				view.GUI = true;
				view.GuiG.looting();
			} else if (userInput.equalsIgnoreCase("Move on")) {
				controller.walk();
			}
		} else {

			rnd = rand.nextInt(3);
			
			statChanged = (hero.getLevel() - (hero.getLevel() - map.enemy(hero.getPosY(), hero.getPosX()))) + 1;
			statChanged = statChanged < 1 ? 1 : statChanged;

			switch (rnd) {
				case 0:
				{
					userInput = scanner.nextLine().trim();

					System.out.println("You found a Weapon. Level " + statChanged + ".");
					if (hero.getWeaponArtifact() != null) {
						System.out.println("You have a Weapon level " + hero.getWeaponArtifact().getStat() + ".\n-Take it\n-Leave it");
					}
					else {
						System.out.println("You don't have an Artifact of this type.\n-Take it\n-Leave it");
					}
					
					cleanScreen();
					if (userInput.equalsIgnoreCase("gui")) {
						view.GUI = true;
						view.GuiG.looting();
					} else if (userInput.equalsIgnoreCase("Take it")) {
						hero.setWeaponArtifact(new Artifact(statChanged, "Weapon"));
						controller.walk();
					} else if (userInput.equalsIgnoreCase("Leave it")) {
						controller.goStart();
					}
					break;
				}
				case 1:
				{
					userInput = scanner.nextLine().trim();

					System.out.println("You found a Armor. Level " + statChanged + ".");
					if (hero.getArmorArtifact() != null) {
						System.out.println("You have a Armor level " + hero.getArmorArtifact().getStat() + ".\n-Take it\n-Leave it");
					}
					else {
						System.out.println("You don't have an Artifact of this type.\n-Take it\n-Leave it");
					}
					
					cleanScreen();
					if (userInput.equalsIgnoreCase("gui")) {
						view.GUI = true;
						view.GuiG.looting();
					} else if (userInput.equalsIgnoreCase("Take it")) {
						hero.setArmorArtifact(new Artifact(statChanged, "Armor"));
						controller.walk();
					} else if (userInput.equalsIgnoreCase("Leave it")) {
						controller.goStart();
					}
					break;
				}
				case 2:
				{
					userInput = scanner.nextLine().trim();

					System.out.println("You found a Helm. Level " + statChanged + ".");
					if (hero.getHelmArtifact() != null) {
						System.out.println("You have a Helm level " + hero.getHelmArtifact().getStat() + ".\n-Take it\n-Leave it");
					}
					else {
						System.out.println("You don't have an Artifact of this type.\n-Take it\n-Leave it");
					}
					
					cleanScreen();
					if (userInput.equalsIgnoreCase("gui")) {
						view.GUI = true;
						view.GuiG.looting();
					} else if (userInput.equalsIgnoreCase("Take it")) {
						hero.setHelmArtifact(new Artifact(statChanged, "Helm"));
						controller.walk();
					} else if (userInput.equalsIgnoreCase("Leave it")) {
						controller.goStart();
					}
					break;
				}
			}
		}
	}


















    public void win() {

		// Text Prompt for name

		// JLabel labelOnToprintmvn = new JLabel("Your name is: " + controller.getHero().getName() + ", a true " + controller.getHero().getClass() + ".");
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
