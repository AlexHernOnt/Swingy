/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   ViewGame.java                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ahernand <ahernand@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/11/03 17:46:02 by ahernand          #+#    #+#             */
/*   Updated: 2024/11/15 21:02:37 by ahernand         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package View;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Hero.Hero;
import swingy.View.MyFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;


import java.awt.FlowLayout;

public class ViewGame extends JFrame implements ActionListener{

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
		
		}
		else {
			cleanScreen();
			System.err.println("Welcome to The Brighest Night");
		}
	}

	public void GUIpromptForSelectHero() {

		ImageIcon img = new ImageIcon("/home/ahernand/swingy/src/main/java/swingy/View/zelda.png");

		// Panel Settings;

		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 100, 1600, 300);


		// Welcome Label

		JLabel welcome = new JLabel("Welcome to Swingy!");
	
		welcome.setIcon(img);
		welcome.setHorizontalTextPosition(JLabel.CENTER);
		welcome.setVerticalTextPosition(JLabel.TOP);
		welcome.setFont(new Font("Monospaced", Font.PLAIN, 42));
		welcome.setIconTextGap(100);
		welcome.setHorizontalAlignment(JLabel.CENTER);
		welcome.setVerticalAlignment(JLabel.CENTER);
		welcome.setBackground(Color.decode(frame.COLOR));
		panel1.add(welcome);


		// Choose menu

		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 500, 1600, 100);

		JLabel chooseSelectMode = new JLabel("Choose an option: ");
		chooseSelectMode.setHorizontalTextPosition(JLabel.CENTER);
		chooseSelectMode.setVerticalTextPosition(JLabel.BOTTOM);
		chooseSelectMode.setFont(new Font("Monospaced", Font.PLAIN, 42));
		chooseSelectMode.setBackground(Color.CYAN);
		panel2.add(chooseSelectMode);

		// Buttons

		JPanel panel3 = new JPanel();
		panel3.setBounds(0, 700, 1600, 500);


		// JButton[] setHeroButton = new JButton[2];
		JButton setHeroButtonContinue = new JButton("Continue");
		JButton setHeroButtonNewGame = new JButton("New Game");
		
		setHeroButtonContinue.setBounds(550, 0, 200, 70);
		setHeroButtonContinue.setFocusable(false);
		setHeroButtonContinue.setFont(new Font("Monospaced", Font.PLAIN, 21));
		setHeroButtonContinue.addActionListener(this);

		setHeroButtonNewGame.setBounds(850, 0, 200, 70);
		setHeroButtonNewGame.setFocusable(false);
		setHeroButtonNewGame.setFont(new Font("Monospaced", Font.PLAIN, 21));
		setHeroButtonNewGame.addActionListener(this);
		
		panel3.setLayout(null);
		panel3.add(setHeroButtonContinue);
		panel3.add(setHeroButtonNewGame);

		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);

		frame.setVisible(true);
	}

	public String promptForSelectHero() {
		System.err.println("Choose an option:\n- Continue\n- New Game");
		String str = scanner.nextLine();
		return str;
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
	public void promptForClassGUI() {
		// Buttons
		JPanel panel2 = new JPanel();

		JButton[] classButtons = new JButton[4];
		classButtons[0] = new JButton("Warrior");
		classButtons[1] = new JButton("Wizard");
		classButtons[2] = new JButton("Knight");
		classButtons[3] = new JButton("Archer");

		for (int i = 0; i < classButtons.length; ++i) {
			panel2.add(classButtons[i]);
		}
	}

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
