/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   ViewGame.java                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/03 17:46:02 by ahernand          #+#    #+#             */
/*   Updated: 2024/11/12 20:58:34 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package View;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Hero.Hero;
import swingy.View.MyFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;


import java.awt.FlowLayout;

public class ViewGame {

	/*
	** Parameters
	*/

	public boolean GUI = true;
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
	**  Select Hero And Present Game
	*/

	public void printPresenteAndSelectHero() {
		if (GUI) {
			ImageIcon img = new ImageIcon("/home/ahernand/swingy/src/main/java/swingy/View/zelda.png");

			// Panel Settings;
	
			JPanel panel = new JPanel();
	
			panel.setBounds((frame.WIDTH / 2) - 400, (frame.HEIGHT / 6), 800, 800);
			
			// Welcome Label
	
			JLabel welcome = new JLabel("Welcome to Swingy!");
	
			welcome.setIcon(img);
			welcome.setHorizontalTextPosition(JLabel.CENTER);
			welcome.setVerticalTextPosition(JLabel.TOP);
			welcome.setFont(new Font("Monospaced", Font.PLAIN, 42));
			welcome.setIconTextGap(20);
			welcome.setHorizontalAlignment(JLabel.CENTER);
			welcome.setVerticalAlignment(JLabel.CENTER);
			welcome.setBackground(Color.decode(frame.COLOR));

	
			// chooseClass.setHorizontalAlignment(JLabel.CENTER);
			// chooseClass.setVerticalAlignment(JLabel.BOTTOM);
	
			panel.add(welcome);

			frame.add(panel);
			frame.setVisible(true);
			// frame.refresh();			
		}
		else {
			cleanScreen();
			System.err.println("Welcome to The Brighest Night");
		}
	}

	public String promptForSelectHero() {
		if (GUI) {
			JPanel panel2 = new JPanel();
			panel2.setBounds((frame.WIDTH / 2) - 400, (frame.HEIGHT / 2), 800, 800); 

			JLabel chooseClass = new JLabel("Choose a class: ");
			chooseClass.setHorizontalTextPosition(JLabel.CENTER);
			chooseClass.setVerticalTextPosition(JLabel.BOTTOM);
			chooseClass.setFont(new Font("Monospaced", Font.PLAIN, 42));
			chooseClass.setBackground(Color.CYAN);
	
			// Buttons
	
			JButton[] classButtons = new JButton[4];
			classButtons[0] = new JButton("Warrior");
			classButtons[1] = new JButton("Wizard");
			classButtons[2] = new JButton("Knight");
			classButtons[3] = new JButton("Archer");
	
			for (int i = 0; i < classButtons.length; ++i) {
				panel2.add(classButtons[i]);
			}

			panel2.add(chooseClass);
			frame.add(panel2);
			frame.setVisible(true);
			
			return "Continue";
		}
		else {
			System.err.println("Choose an option:\n- Continue\n- New Game");
			String str = scanner.nextLine();
			return str;
		}
	}




	/*
	**  Set Hero's Name
	*/

	public String promptForName() {
		System.out.println("Write your hero's name:");
		String str = scanner.nextLine();
		return str;
	}

	public void printName(String str) {
		if (GUI) {
			
		}
		else {
			cleanScreen();
			System.out.println("The hero's name is '" + str + "'");
		}
	}

	public void printErrorName() {
		cleanScreen();
		System.out.println("Please, input a name.");
	}




	/*
	**  Set Hero's Class
	*/

	public String promptForClass() {
		System.out.println("Choose a class: \n- Warrior\n- Wizard\n- Knight\n- Archer");
		String str = scanner.nextLine();
		return str;
	}

	public void printClass(String str) {
		if (GUI) {
			
		}
		else {
			cleanScreen();
			System.out.println("The hero's class is '" + str + "'");
		}
	}

	public void printErrorClass() {
		cleanScreen();
		System.out.println("Please, input a valid class name.");
	}

	public void printHeroData(Hero h) {
		cleanScreen();
		System.out.println("Here's your hero's stats: \n");
		System.out.println(h);
	}
}
