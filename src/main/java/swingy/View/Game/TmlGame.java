/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   TmlGame.java                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/12/01 18:08:49 by ahernand          #+#    #+#             */
/*   Updated: 2024/12/28 18:43:00 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package View;

import java.util.Random;
import java.util.Scanner;
import Hero.Artifact;

import Controller.GameController;
import Hero.Hero;
import Model.GameMap;
import View.MyFrame;


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
		System.out.println("You come out of your house looking for an adventure!\n");
	
		String userInput;
		
		do {

			System.out.println("Choose an option:\n- Start");
			userInput = scanner.nextLine().trim();
	
			cleanScreen();
	
			if (userInput.equalsIgnoreCase("gui")) {
				view.GUI = true;
				view.getController().welcomeScreen();
				break;
			} else if (userInput.equalsIgnoreCase("start")) {
				view.getController().walk();
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
				view.getController().walk();
				break;
			} else if (userInput.equalsIgnoreCase("North") || userInput.equalsIgnoreCase("N")) {
				hero.goNorth();
				view.getController().positionCheck();
				break;
			} else if (userInput.equalsIgnoreCase("East") || userInput.equalsIgnoreCase("E")) {
				hero.goEast();
				view.getController().positionCheck();
				break;
			} else if (userInput.equalsIgnoreCase("South") || userInput.equalsIgnoreCase("S")) {
				hero.goSouth();
				view.getController().positionCheck();
				break;
			} else if (userInput.equalsIgnoreCase("West") || userInput.equalsIgnoreCase("W")) {
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
				view.getController().confrontation();
				break;
			} else if (userInput.equalsIgnoreCase("Yes")) {
				controller.fightAlgo();
				view.getController().fight();
				break;
			} else if (userInput.equalsIgnoreCase("No")) {
				view.getController().runChancesResolve();
				break;
			}
		} while (true);
	}











    /*
    **  F I G H T
    */
	
    public void fight() {

		cleanScreen();

		String userInput;

		if (controller.getFightResult()) {
		
			do {

				System.out.println("Victory! Current XP " + hero.getExperience() + " / " + hero.formulaLevelUp() + ".\n\n");
				System.out.println("You see your foe's desecreated body: \n- Loot it");
				userInput = scanner.nextLine().trim();

				cleanScreen();
				if (userInput.equalsIgnoreCase("gui")) {
					view.GUI = true;
					view.getController().fight();
					break;
				} else if (userInput.equalsIgnoreCase("Loot it")) {
					view.getController().looting();
					view.getController().fight();
					break;
				}
			} while (true);

		} else {
			do {
			
				System.out.println("You gave all you had in the fight, however you failed");
				System.out.println("You know this is the last second of your life: \n-Bye");
				userInput = scanner.nextLine().trim();
				
				cleanScreen();
				if (userInput.equalsIgnoreCase("gui")) {
					view.GUI = true;
					view.getController().fight();
					break;
				} else if (userInput.equalsIgnoreCase("Bye")) {
					view.getController().goStart();
					break;
				}
			} while (true);
		}
	}











    /*
    **   L O O T I N G
    */
	
	Random rand = new Random();

	public void looting() {

		cleanScreen();
		int rnd = rand.nextInt(3);
		String userInput;
			
		int statChanged = (hero.getLevel() - (hero.getLevel() - map.enemy(hero.getPosY(), hero.getPosX()))) + 1;
		statChanged = statChanged < 1 ? 1 : statChanged;

		if (rnd == 1) { // 30 % 
			do {
			
				System.out.println("You only found blood and skin: \n- Move on");
				userInput = scanner.nextLine().trim();

				cleanScreen();

				if (userInput.equalsIgnoreCase("gui")) {
					view.GUI = true;
					view.getController().looting();
					break;
				} else if (userInput.equalsIgnoreCase("Move on")) {
					view.getController().walk();
					break;
				}
			} while (true);
			
		} else {

			rnd = rand.nextInt(3);
			
			statChanged = (hero.getLevel() - (hero.getLevel() - map.enemy(hero.getPosY(), hero.getPosX()))) + 1;
			statChanged = statChanged < 1 ? 1 : statChanged;

			switch (rnd) {
				case 0:
				{
					do {
						System.out.println("You found a Weapon. Level " + statChanged + ".");
						
						if (hero.getWeaponArtifact() != null) {
							System.out.println("You have a Weapon level " + hero.getWeaponArtifact().getStat() + ".\n- Take it\n- Leave it");
						}
						else {
							System.out.println("You don't have an Artifact of this type.\n- Take it\n- Leave it");
						}

						userInput = scanner.nextLine().trim();
						
						cleanScreen();
						
						if (userInput.equalsIgnoreCase("gui")) {
							view.GUI = true;
							view.getController().looting();
							break;
						} else if (userInput.equalsIgnoreCase("Take it")) {
							hero.setWeaponArtifact(new Artifact(statChanged, "Weapon"));
							view.getController().walk();
							break;
						} else if (userInput.equalsIgnoreCase("Leave it")) {
							view.getController().walk();
							break;
						}
						break;
					} while (true);
				}
				case 1:
				{
					do {
						System.out.println("You found a Armor. Level " + statChanged + ".");
						if (hero.getArmorArtifact() != null) {
							System.out.println("You have a Armor level " + hero.getArmorArtifact().getStat() + ".\n- Take it\n- Leave it");
						}
						else {
							System.out.println("You don't have an Artifact of this type.\n- Take it\n- Leave it");
						}

						userInput = scanner.nextLine().trim();
						cleanScreen();
						
						if (userInput.equalsIgnoreCase("gui")) {
							view.GUI = true;
							view.getController().looting();
							break;
						} else if (userInput.equalsIgnoreCase("Take it")) {
							hero.setArmorArtifact(new Artifact(statChanged, "Armor"));
							view.getController().walk();
							break;
						} else if (userInput.equalsIgnoreCase("Leave it")) {
							view.getController().walk();
							break;
						}
					} while (true);
				}
				case 2:
				{
					do {

						System.out.println("You found a Helm. Level " + statChanged + ".");
						if (hero.getHelmArtifact() != null) {
							System.out.println("You have a Helm level " + hero.getHelmArtifact().getStat() + ".\n- Take it\n- Leave it");
						}
						else {
							System.out.println("You don't have an Artifact of this type.\n- Take it\n- Leave it");
						}
						
						userInput = scanner.nextLine().trim();
						cleanScreen();
						
						if (userInput.equalsIgnoreCase("gui")) {
							view.GUI = true;
							view.getController().looting();
							break;
						} else if (userInput.equalsIgnoreCase("Take it")) {
							hero.setHelmArtifact(new Artifact(statChanged, "Helm"));
							view.getController().walk();
							break;
						} else if (userInput.equalsIgnoreCase("Leave it")) {
							view.getController().walk();
							break;
						}
					} while (true);
				}
			}
		}
	}











    /*
    **	W I N
    */

	public void win() {

		cleanScreen();

		String userInput;
		do {
			
			System.out.println("You have reached the end of level " + hero.getLevel() + ".");
			System.out.println("Will you continue to level " + (hero.getLevel() + 1) + "?\n- Yes\n- Main Menu");
			userInput = scanner.nextLine().trim();
	
			cleanScreen();
	
			if (userInput.equalsIgnoreCase("gui")) {
				view.GUI = true;
				view.getController().win();
				break;
			} else if (userInput.equalsIgnoreCase("Yes")) {
				view.getController().welcomeScreen();
				break;
			} else if (userInput.equalsIgnoreCase("Main Menu")) {
				view.getController().goStart();
				break;
			}
		} while (true);
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
