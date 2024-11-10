/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   ViewGame.java                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/03 17:46:02 by ahernand          #+#    #+#             */
/*   Updated: 2024/11/10 16:36:13 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package View;
import java.util.Scanner;

import Hero.Hero;
import swingy.View.MyFrame;

public class ViewGame {

	/*
	** Parameters
	*/
	
	boolean GUI = true;
	Scanner scanner = new Scanner(System.in);
	MyFrame frame = new MyFrame();
	
	/*
	** Methods
	*/
	
	public ViewGame() {

	}

	public void cleanScreen() {
		int i = 0;

		while (i < 100) {
			System.err.println("\n");
			++i;
		}
	}

	/*
	 *  Introduction
	 */
	
	public void printPresentGame() {
		if (GUI) {
			
		}
		else {
			cleanScreen();
			System.err.println("Welcome to The Brighest Night");
		}
	}

	public void printName(String str) {
		cleanScreen();
		System.out.println("The hero's name is '" + str + "'");
	}

	public void printClass(String str) {
		cleanScreen();
		System.out.println("The hero's class is '" + str + "'");
	}

	public String promptForName() {
		System.out.println("Write your hero's name:");
		String str = scanner.nextLine();
		return str;
	}

	public String promptForClass() {
		System.out.println("Choose a class: \n- Warrior\n- Wizard\n- Knight\n- Archer");
		String str = scanner.nextLine();
		return str;
	}

	public void printErrorClass() {
		cleanScreen();
		System.out.println("Please, input a valid class name.");
	}

	public void printErrorName() {
		cleanScreen();
		System.out.println("Please, input a name.");
	}

	public void printHeroData(Hero h) {
		cleanScreen();
		System.out.println("Here's your hero's stats: \n");
		System.out.println(h);
	}
}
